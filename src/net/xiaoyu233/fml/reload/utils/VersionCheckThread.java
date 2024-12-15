package net.xiaoyu233.fml.reload.utils;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.xiaoyu233.fml.FishModLoader;

public class VersionCheckThread extends Thread {
   private final EntityPlayerMP par1EntityPlayerMP;

   public VersionCheckThread(EntityPlayerMP player) {
      this.par1EntityPlayerMP = player;
   }

   public void run() {
      String onlineVersion = FishModLoader.getOnlineVersion();
      if (onlineVersion == null) {
         this.par1EntityPlayerMP.sendChatToPlayer(ChatMessageComponent.createFromText(I18n.getString("fishmodloader.update.offline")));
      } else if (!onlineVersion.equals(FishModLoader.VERSION)) {
         this.par1EntityPlayerMP.sendChatToPlayer(ChatMessageComponent.createFromText(I18n.getStringParams("fishmodloader.update.available", onlineVersion)));
      }

   }
}
