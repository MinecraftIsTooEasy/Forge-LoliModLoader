package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.enchantment.EnumEnchantmentType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumEnchantmentType.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumEnchantmentTypeMixin {
}
