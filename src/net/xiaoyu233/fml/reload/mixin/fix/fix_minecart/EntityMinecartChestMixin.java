package net.xiaoyu233.fml.reload.mixin.fix.fix_minecart;

import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EntityMinecartChest.class)
public class EntityMinecartChestMixin extends EntityMinecartContainer {
   @Unique
   private boolean isInPortal;

   public EntityMinecartChestMixin(World par1World) {
      super(par1World);
   }

   @Shadow
   public int getMinecartType() {
      return 0;
   }

   @Shadow
   public int getSizeInventory() {
      return 0;
   }

   public void setInPortal(int destination_dimension_id) {
      this.isInPortal = true;
      super.setInPortal(destination_dimension_id);
   }

   @Override
   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
      return super.isUseableByPlayer(par1EntityPlayer) && !this.isInPortal;
   }

   public boolean onEntityRightClicked(EntityPlayer player, ItemStack item_stack) {
      if (player.onServer() && !this.isInPortal) {
         super.onEntityRightClicked(player,item_stack);
      }

      return true;
   }

   protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
      this.isInPortal = false;
   }
}
