package net.xiaoyu233.fml.reload.mixins.id_extend;

import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(RenderWitch.class)
public class WitchRendererMixin {
    @Redirect(method = {
            "func_82411_a(Lnet/minecraft/EntityWitch;F)V",
    }, at = @At(value = "FIELD", target = "Lnet/minecraft/ItemStack;itemID:I"), slice = @Slice(to = @At(value = "CONSTANT", args = "intValue=256")))
    private int injected(ItemStack stack) {
        if (stack.getItem() instanceof ItemBlock) return 0;
        return stack.itemID;
    }
}
