//package net.xiaoyu233.fml.test;
//
//import net.minecraft.block.material.Material;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemSword;
//import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
//import net.xiaoyu233.fml.reload.utils.IdUtil;
//import net.xiaoyu233.fml.util.ReflectHelper;
//
//public class Items extends Item {
//    public static final ItemSword VIBRANIUM_SWORD = (ItemSword) ReflectHelper.createInstance(ItemSword.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.rusted_iron);
//    public static void registerItems(ItemRegistryEvent event) {
//        event.register("FishModLoader", "vibranium_sword", VIBRANIUM_SWORD);
//    }
//}
