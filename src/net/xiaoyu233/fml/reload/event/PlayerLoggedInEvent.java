package net.xiaoyu233.fml.reload.event;

import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerLoggedInEvent {
   private final EntityPlayerMP player;

   public PlayerLoggedInEvent(EntityPlayerMP player) {
      this.player = player;
   }

   public EntityPlayerMP getPlayer() {
      return this.player;
   }
}
