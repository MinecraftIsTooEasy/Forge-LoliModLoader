package net.xiaoyu233.fml.reload.mixin.client;

import net.fabricmc.loader.impl.ModContainerImpl;
import net.fabricmc.loader.impl.util.UrlUtil;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;
import net.xiaoyu233.fml.FishModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Mixin(SimpleReloadableResourceManager.class)
public class SimpleResourceManagerMixin {
    @Redirect(method = "getAllResources", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/ResourceManager;getAllResources(Lnet/minecraft/util/ResourceLocation;)Ljava/util/List;"))
    private List enhanceGetAllResources(ResourceManager obj, ResourceLocation location) {
        List allResources = obj.getAllResources(location);
        for (ModContainerImpl value : FishModLoader.getModsMap().values()) {
            MetadataSerializer metadataSerializer = new MetadataSerializer();
            try {
                InputStream resourceAsStream = UrlUtil.asUrl(value.getPath("assets/" + location.getResourceDomain() + "/" + location.getResourcePath())).openStream();
                InputStream metaStream = null;
                try {
                     metaStream = UrlUtil.asUrl(value.getPath("assets/" + location.getResourceDomain() + "/" + location.getResourcePath() + ".mcmeta")).openStream();
                } catch (Exception ignored) {}
                if (resourceAsStream != null) {
                    allResources.add(new SimpleResource(location, resourceAsStream, metaStream, metadataSerializer));
                }
            } catch (IOException ignored) {}
        }
        return allResources;
    }
}
