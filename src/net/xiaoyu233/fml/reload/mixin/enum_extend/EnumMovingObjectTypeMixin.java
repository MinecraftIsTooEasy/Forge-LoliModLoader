package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.util.EnumMovingObjectType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumMovingObjectType.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumMovingObjectTypeMixin {
}
