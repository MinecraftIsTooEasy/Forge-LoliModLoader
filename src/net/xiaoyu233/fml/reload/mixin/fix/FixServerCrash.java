package net.xiaoyu233.fml.reload.mixin.fix;

import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldServer.class)
public class FixServerCrash {
   @Overwrite
   public void verifyWMs() {
   }
}
