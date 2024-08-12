package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.entity.EnumEntitySize;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumEntitySize.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumEntitySizeMixin {
}
