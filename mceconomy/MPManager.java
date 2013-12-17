package mceconomy;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import mceconomy.api.IMPManager;

public class MPManager implements IMPManager {

	@Override
	public void addPlayerMP(EntityPlayer entityPlayer, int amount) {

		if(amount<0){
			return ;
		}

		if(entityPlayer.getEntityData()==null){
			return ;
		}

		if(entityPlayer instanceof EntityPlayerMP){

			NBTTagCompound nbt = entityPlayer.getEntityData();

			int i = 0;

			i = nbt.getInteger("money") + amount;

			nbt.setInteger("money", i);

			MCEconomy.Log.info("addPlayerMP : PlayerName "+entityPlayer.getEntityName()+" : Amount "+ amount+" MP");

			EntityPlayerMP P = (EntityPlayerMP) entityPlayer;
			P.playerNetServerHandler.sendPacketToPlayer(MCEPacketHandler.getPacket(entityPlayer));

		}


	}

	@Override
	public void reducePlayerMP(EntityPlayer entityPlayer, int amount) {

		if(amount<0){
			return ;
		}

		if(entityPlayer.getEntityData()==null){
			return ;
		}

		if(entityPlayer instanceof EntityPlayerMP){

			NBTTagCompound nbt = entityPlayer.getEntityData();

			int i = 0;

			i = nbt.getInteger("money") - amount;

			nbt.setInteger("money", i);

			MCEconomy.Log.info("reducePlayerMP : PlayerName "+entityPlayer.getEntityName()+" : Amount "+ amount+" MP");

			EntityPlayerMP P = (EntityPlayerMP) entityPlayer;
			P.playerNetServerHandler.sendPacketToPlayer(MCEPacketHandler.getPacket(entityPlayer));

		}

	}

	@Override
	public void setPlayerMP(EntityPlayer entityPlayer, int amount) {

		if(amount<0){
			return ;
		}

		if(entityPlayer.getEntityData()==null){
			return ;
		}

		if(entityPlayer instanceof EntityPlayerMP){

			NBTTagCompound nbt = entityPlayer.getEntityData();

			int i = 0;

			i = amount;

			nbt.setInteger("money", i);

			MCEconomy.Log.info("setPlayerMP : PlayerName "+entityPlayer.getEntityName()+" : Amount "+ amount+" MP");

			EntityPlayerMP P = (EntityPlayerMP) entityPlayer;
			P.playerNetServerHandler.sendPacketToPlayer(MCEPacketHandler.getPacket(entityPlayer));

		}


	}

	@Override
	public int getPlayerMP(EntityPlayer entityPlayer) {

		int i = 0;

		if(entityPlayer.getEntityData()==null){
			return 0;
		}

		NBTTagCompound nbt = entityPlayer.getEntityData();

		i = nbt.getInteger("money");

		MCEconomy.Log.info("getPlayerMP : PlayerName "+entityPlayer.getEntityName()+" : Amount "+ i+" MP");

		return i;
	}

	@Override
	public void printChatMPMessage(EntityPlayer entityPlayer) {

		if(entityPlayer.getEntityData()==null){
			return ;
		}

		NBTTagCompound nbt = entityPlayer.getEntityData();

		int i = 0;

		i = nbt.getInteger("money") ;

		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("あなたの所持金は"+i+"MPです");

	}

	@Override
	public void spawnWorldMP(World world, int x, int y, int z, int amount) {

		dropMP(world, x, y, z, amount);

	}

	protected void dropMP(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {

        	par1World.spawnEntityInWorld(new EntityMPOrb(par1World, (double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, par5));

        	/*
            while (par5 > 0)
            {
                int i1 = EntityXPOrb.getXPSplit(par5);
                //par5 -= i1;
                par1World.spawnEntityInWorld(new EntityMPOrb(par1World, (double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, i1));
            }*/
        }
    }



}
