package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.util.EnumLevelBonus;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumLevelBonus.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumLevelBonusMixin {
}
