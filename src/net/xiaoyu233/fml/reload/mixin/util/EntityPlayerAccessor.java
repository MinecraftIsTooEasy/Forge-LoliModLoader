package net.xiaoyu233.fml.reload.mixin.util;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityPlayer.class)
public interface EntityPlayerAccessor {
   @Invoker("getExperienceRequired")
   static int getExpRequired(int level) {
      throw new AssertionError();
   }
}
