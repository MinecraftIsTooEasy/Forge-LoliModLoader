package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.util.EnumBlockBreakReason;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumBlockBreakReason.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumBlockBreakReasonMixin {
}
