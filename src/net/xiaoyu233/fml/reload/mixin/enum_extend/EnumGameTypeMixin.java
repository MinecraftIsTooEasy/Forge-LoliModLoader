package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.world.EnumGameType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumGameType.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumGameTypeMixin {
}
