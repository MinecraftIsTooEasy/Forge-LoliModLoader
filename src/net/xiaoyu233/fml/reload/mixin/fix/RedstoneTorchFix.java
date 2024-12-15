package net.xiaoyu233.fml.reload.mixin.fix;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.BlockTorch;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRedstoneTorch.class)
public abstract class RedstoneTorchFix extends BlockTorch {
   protected RedstoneTorchFix(int par1, boolean par2) {
      super(par1);
   }

   @Inject(method = "canBeReplacedBy", at = @At("HEAD"), cancellable = true)
   public void fixReplaceCrash(int metadata, Block other_block, int other_block_metadata, CallbackInfoReturnable<Boolean> callbackInfo) {
      if (other_block instanceof BlockRailBase){
         callbackInfo.setReturnValue(false);
      }
   }
}
