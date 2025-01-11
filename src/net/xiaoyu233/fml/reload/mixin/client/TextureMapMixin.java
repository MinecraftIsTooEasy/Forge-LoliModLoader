//package net.xiaoyu233.fml.reload.mixin.client;
//
//import net.fabricmc.loader.impl.ModContainerImpl;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.texture.Stitcher;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.client.renderer.texture.TextureMap;
//import net.minecraft.client.resources.ResourceManager;
//import net.minecraft.util.ResourceLocation;
//import net.xiaoyu233.fml.FishModLoader;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//
//@Mixin(TextureMap.class)
//public class TextureMapMixin {
//
//    @Shadow @Final private Map mapRegisteredSprites;
//
//    @Shadow @Final private String basePath;
//
//    @Inject(method = "loadTextureAtlas", at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
//    private void loadModResourceDomain(ResourceManager par1ResourceManager, CallbackInfo ci, int var2, Stitcher var3) {
//        Iterator var4 = this.mapRegisteredSprites.entrySet().iterator();
//
//        TextureAtlasSprite var17;
//        while(var4.hasNext()) {
//            for (ModContainerImpl value : FishModLoader.getModsMap().values()) {
//                Map.Entry var5 = (Map.Entry) var4.next();
//                ResourceLocation var6 = new ResourceLocation((String) var5.getKey(), false);
//                var17 = (TextureAtlasSprite) var5.getValue();
//                ResourceLocation var8 = new ResourceLocation(value.getMetadata().getId(), String.format("%s/%s%s", this.basePath, var6.getResourcePath(), ".png"), false);
//
//                try {
//                    var17.loadSprite(par1ResourceManager.getResource(var8));
//                } catch (RuntimeException var14) {
//                    RuntimeException var13 = var14;
//                    Minecraft.getMinecraft().getLogAgent().logSevere(String.format("Unable to parse animation metadata from %s: %s", var8, var13.getMessage()));
//                    continue;
//                } catch (IOException var15) {
//                    String error_message = "Missing resource: " + var8.getResourcePath();
//                    Minecraft.getMinecraft().getLogAgent().logSevere(error_message);
//                    Minecraft.setErrorMessage(error_message, false);
//                    continue;
//                }
//
//                var3.addSprite(var17);
//            }
//        }
//    }
//}
