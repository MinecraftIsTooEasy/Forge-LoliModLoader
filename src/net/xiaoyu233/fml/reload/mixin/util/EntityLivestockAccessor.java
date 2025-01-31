package net.xiaoyu233.fml.reload.mixin.util;

import net.minecraft.entity.EntityLivestock;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityLivestock.class)
public interface EntityLivestockAccessor {
   @Invoker("setFood")
   @Intrinsic
   void setFood(float food);

   @Invoker("setWater")
   @Intrinsic
   void setWater(float water);
}
