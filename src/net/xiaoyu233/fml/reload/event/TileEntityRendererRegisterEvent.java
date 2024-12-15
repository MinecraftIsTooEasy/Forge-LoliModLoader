package net.xiaoyu233.fml.reload.event;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import java.util.function.BiConsumer;

public class TileEntityRendererRegisterEvent {
    private final BiConsumer<Class<? extends TileEntity>, TileEntitySpecialRenderer> rendererRegisterer;

    public TileEntityRendererRegisterEvent(BiConsumer<Class<? extends TileEntity>, TileEntitySpecialRenderer> rendererRegisterer) {
        this.rendererRegisterer = rendererRegisterer;
    }

    public void register(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer){
        this.rendererRegisterer.accept(tileEntity, renderer);
    }
}
