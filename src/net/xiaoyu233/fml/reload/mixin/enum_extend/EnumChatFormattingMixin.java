package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.util.EnumChatFormatting;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = EnumChatFormatting.class, priority = 10000)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumChatFormattingMixin {
}
