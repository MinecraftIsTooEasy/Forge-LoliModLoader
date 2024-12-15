package net.xiaoyu233.fml.reload.mixin.client;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.xiaoyu233.fml.util.Constants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public abstract class MainMenuMixin extends GuiScreen {
    @Inject(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;getVersionDescriptor(Z)Ljava/lang/String;", shift = At.Shift.BEFORE))
    private void injectRenderFMLVersion(CallbackInfo callbackInfo){
        this.drawString(this.fontRenderer, "FishModLoader Version: " + Constants.VERSION, 2, this.height - 20, 0xFFFFFF);
    }
}
