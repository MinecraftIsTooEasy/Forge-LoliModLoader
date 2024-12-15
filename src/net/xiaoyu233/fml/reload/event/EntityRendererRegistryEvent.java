package net.xiaoyu233.fml.reload.event;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class EntityRendererRegistryEvent {
    private final Map<Class<? extends Entity>, Render> rendererMap = new HashMap<>();

    public void register(Class<? extends Entity> clazz, Render render){
        this.rendererMap.put(clazz,render);
    }

    public Map<? extends Class<? extends Entity>, ? extends Render> getRendererMap() {
        return rendererMap;
    }
}
