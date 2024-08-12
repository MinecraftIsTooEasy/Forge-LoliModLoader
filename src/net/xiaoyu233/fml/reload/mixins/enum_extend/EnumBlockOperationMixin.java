package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.util.EnumBlockOperation;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumBlockOperation.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumBlockOperationMixin {
}
