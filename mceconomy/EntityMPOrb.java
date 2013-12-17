package mceconomy;

import mceconomy.api.ISoundManager;
import mceconomy.api.MCEconomyAPI;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMPOrb extends EntityXPOrb{

	public EntityMPOrb(World par1World) {
		super(par1World);
	}

	public EntityMPOrb(World par1World, double par2, double par4, double par6,int par8) {
		super(par1World, par2, par4, par6, par8);
	}


	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if (!this.worldObj.isRemote)
        {
            if (this.field_70532_c == 0 && par1EntityPlayer.xpCooldown == 0)
            {
                par1EntityPlayer.xpCooldown = 2;
                //MCEconomyAPI.playCoinSoundEffect(worldObj, chunkCoordX, chunkCoordY, chunkCoordZ);
                this.playSound(ISoundManager.COIN_SOUND, 0.1F, 0.5F * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.8F));
                par1EntityPlayer.onItemPickup(this, 1);
                MCEconomyAPI.addPlayerMP(par1EntityPlayer, getXpValue());
                //par1EntityPlayer.addExperience(this.getXpValue());
                this.setDead();
            }
        }
    }

}
