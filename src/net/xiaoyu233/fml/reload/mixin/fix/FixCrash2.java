package net.xiaoyu233.fml.reload.mixin.fix;

import net.minecraft.client.model.TexturedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TexturedQuad.class)
public class FixCrash2 {
   @Overwrite
   private static void SysX() {
   }

   @Overwrite
   private static boolean isRbf() {
      return true;
   }

   @Overwrite
   private static void method2() {
   }
}
