package net.xiaoyu233.fml.reload.mixin.client;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import net.xiaoyu233.fml.reload.event.TileEntityRendererRegisterEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;
import java.util.Map;

@Mixin(TileEntityRenderer.class)
public class TileEntityRendererMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Ljava/util/Map;values()Ljava/util/Collection;"))
    private Collection<TileEntitySpecialRenderer> injectRegisterRenderer(Map<Class<? extends TileEntity>, TileEntitySpecialRenderer> rendererMap){
        MITEEvents.MITE_EVENT_BUS.post(new TileEntityRendererRegisterEvent(rendererMap::put));
        return rendererMap.values();
    }
}
