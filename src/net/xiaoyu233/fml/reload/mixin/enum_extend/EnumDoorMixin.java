package net.xiaoyu233.fml.reload.mixin.enum_extend;

import net.minecraft.world.gen.structure.EnumDoor;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnumDoor.class)
@SuppressWarnings("unused") // For mixin loader to trigger enum extender
public class EnumDoorMixin {
}
