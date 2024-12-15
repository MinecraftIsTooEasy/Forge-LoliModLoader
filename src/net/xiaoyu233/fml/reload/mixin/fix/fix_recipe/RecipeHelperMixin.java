package net.xiaoyu233.fml.reload.mixin.fix.fix_recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RecipeHelper.class})
public class RecipeHelperMixin {

    @Inject(method = "addRecipe", at = @At("HEAD"), cancellable = true)
    private static void inject(IRecipe recipe, boolean include_in_lowest_crafting_difficulty_determination, CallbackInfo ci) {
        ItemStack recipe_output = recipe.getRecipeOutput();
        Item output_item = recipe_output.getItem();
        if (output_item.num_recipes >= output_item.recipes.length) {
            ci.cancel();
        }
    }

}