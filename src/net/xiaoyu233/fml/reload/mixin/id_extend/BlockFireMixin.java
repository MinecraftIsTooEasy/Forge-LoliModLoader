package net.xiaoyu233.fml.reload.mixin.id_extend;

import net.minecraft.block.BlockFire;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BlockFire.class)
public class BlockFireMixin {
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 256))
    private int modifyChanceTableSize(int val){
        return 4096;
    }
}
