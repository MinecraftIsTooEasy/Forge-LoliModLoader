package net.xiaoyu233.fml.reload.mixin.util;

import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(WorldServer.class)
public interface WorldServerAccessor {
    @Accessor("pendingTickListEntriesHashSet")
    Set getPendingTickListEntriesHashSet();
}
