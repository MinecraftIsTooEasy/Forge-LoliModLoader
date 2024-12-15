package net.xiaoyu233.fml.util;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;

public class EnumExtends {
    public static final EnumAdder CHAT_FORMATTING = ClassTinkerers.enumBuilder("net.minecraft.util.EnumChatFormatting", char.class, int.class, int.class, int.class);
    public static final EnumAdder EQUIPMENT_MATERIAL = ClassTinkerers.enumBuilder("net.minecraft.util.EnumEquipmentMaterial",float.class, int.class, "Lnet.minecraft.EnumQuality;", String.class);
//    public static final EnumConstructor<EnumToolMaterial> TOOL_MATERIAL = new EnumConstructor<EnumToolMaterial>(EnumToolMaterial.class);
//    public static final EnumConstructor<EnumArmorMaterial> ARMOR_MATERIAL = new EnumConstructor<EnumArmorMaterial>(EnumArmorMaterial.class);
    public static final EnumAdder PARTICLE = ClassTinkerers.enumBuilder("net.minecraft.util.EnumParticle");
    public static final EnumAdder OPTIONS = ClassTinkerers.enumBuilder("net.minecraft.client.settings.EnumOptions", String.class, boolean.class, boolean.class);
    public static final EnumAdder GAME_TYPE = ClassTinkerers.enumBuilder("net.minecraft.world.EnumGameType", int.class, String.class);
    public static final EnumAdder LEVEL_BONUS = ClassTinkerers.enumBuilder("net.minecraft.util.EnumLevelBonus");
    public static final EnumAdder QUALITY = ClassTinkerers.enumBuilder("net.minecraft.util.EnumQuality", String.class, String.class, float.class);
    public static final EnumAdder SPECIAL_SPLASH = ClassTinkerers.enumBuilder("net.minecraft.util.EnumSpecialSplash", String.class, String.class, String.class, int.class, String.class, int.class, int.class, int.class, String.class);
    public static final EnumAdder SPECIAL_SPLASH_SIMPLE = ClassTinkerers.enumBuilder("net.minecraft.util.EnumSpecialSplash", String.class);

    public static void buildEnumExtending(){
        CHAT_FORMATTING.build();
        EQUIPMENT_MATERIAL.build();
        PARTICLE.build();
        OPTIONS.build();
        GAME_TYPE.build();
        LEVEL_BONUS.build();
        QUALITY.build();
        SPECIAL_SPLASH.build();
        SPECIAL_SPLASH_SIMPLE.build();
    }
}
