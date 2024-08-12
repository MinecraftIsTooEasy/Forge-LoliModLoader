package net.xiaoyu233.fml.reload.mixins.enum_extend;


import net.minecraft.entity.EnumCreatureType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumCreatureType.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumCreatureTypeMixin {
}
