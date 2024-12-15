package net.xiaoyu233.fml.reload.event.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings(value = {"OptionalUsedAsFieldOrParameterType", "unused"})
public class ShapelessRecipeModifier implements RecipeModifier{
    private final ItemStack targetItem;
    private final List<ItemStack> ingredients;
    private final boolean includeInLowestCraftingDifficultyDetermination;
    private final Optional<Float> craftingDifficulty;

    public ShapelessRecipeModifier(ItemStack targetItem, List<ItemStack> ingredients, boolean includeInLowestCraftingDifficultyDetermination, Optional<Float> craftingDifficulty) {
        this.targetItem = targetItem;
        this.ingredients = ingredients;
        this.includeInLowestCraftingDifficultyDetermination = includeInLowestCraftingDifficultyDetermination;
        this.craftingDifficulty = craftingDifficulty;
    }

    public ItemStack getOutput() {
        return targetItem;
    }

    @Override
    public boolean isIncludeInLowestCraftingDifficultyDetermination() {
        return includeInLowestCraftingDifficultyDetermination;
    }

    public Object[] toObjArgs() {
        Object[] result = new Object[ingredients.size()];
        int currentIndex = 0;
        for (; currentIndex < ingredients.size(); currentIndex++) {
            result[currentIndex] = ingredients.get(currentIndex);
        }
        return result;
    }

    @Override
    public Optional<Float> getCraftingDifficulty() {
        return craftingDifficulty;
    }

    @Override
    public RecipeType getType() {
        return RecipeType.SHAPED;
    }

    public static class Builder{
        private final ItemStack item;
        private final List<ItemStack> ingredients = new ArrayList<>();
        private boolean includeInLowestCraftingDifficultyDetermination = false;
        private Optional<Float> craftingDifficulty = Optional.empty();
        private Builder(ItemStack item) {
            this.item = item;
        }

        public static Builder of(ItemStack item){
            return new Builder(item);
        }

        public Builder ingredient(Item ingredient){
            this.ingredients.add(new ItemStack(ingredient));
            return this;
        }

        public Builder ingredient(ItemStack ingredient){
            this.ingredients.add(ingredient);
            return this;
        }

        public Builder includeInLowestCraftingDifficultyDetermination(){
            includeInLowestCraftingDifficultyDetermination = true;
            return this;
        }

        public Builder difficulty(float craftingDifficulty){
            this.craftingDifficulty = Optional.of(craftingDifficulty);
            return this;
        }

        public ShapelessRecipeModifier build(){
            return new ShapelessRecipeModifier(item, ingredients, includeInLowestCraftingDifficultyDetermination, craftingDifficulty);
        }
    }
}
