package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.util.EnumMaterialHardness;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumMaterialHardness.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumMaterialHardnessMixin {
}
