package net.xiaoyu233.fml.reload.mixin.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CraftingManager.class)
public interface CraftingManagerInvoker {
    @Invoker("addRecipe")
    @Intrinsic
    ShapedRecipes addRecipe(ItemStack par1ItemStack, boolean include_in_lowest_crafting_difficulty_determination, Object... par2ArrayOfObj);
    @Invoker("addShapelessRecipe")
    @Intrinsic
    ShapelessRecipes addShapelessRecipe(ItemStack par1ItemStack, boolean include_in_lowest_crafting_difficulty_determination, Object... par2ArrayOfObj);
}
