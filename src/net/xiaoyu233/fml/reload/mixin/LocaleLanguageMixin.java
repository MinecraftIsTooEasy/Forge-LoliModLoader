package net.xiaoyu233.fml.reload.mixin;

import net.minecraft.util.StringTranslate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({StringTranslate.class})
public class LocaleLanguageMixin {
   @Shadow
   private static StringTranslate instance;

   @Inject(method = "<clinit>", at = @At("RETURN"))
   private static void injectAddTranslation(CallbackInfo callbackInfo) {
      ((StringTranslateAccessor) instance).getLanguageList().put("enchantment.slaying", "杀害");
   }
}
