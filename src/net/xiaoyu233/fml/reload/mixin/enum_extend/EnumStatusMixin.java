package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.entity.player.EnumStatus;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumStatus.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumStatusMixin {
}
