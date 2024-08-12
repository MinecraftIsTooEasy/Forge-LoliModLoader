package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.block.EnumMobType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumMobType.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumMobTypeMixin {
}
