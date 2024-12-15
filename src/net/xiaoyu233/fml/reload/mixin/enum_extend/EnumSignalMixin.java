package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.util.EnumSignal;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumSignal.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumSignalMixin {
}
