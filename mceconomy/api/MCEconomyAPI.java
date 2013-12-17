package mceconomy.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * MCEconomyのAPI
 * MCEconomyとのやりとりはこのClassのメソッドを使用する(他の場合は互換性の保証が出来ない)
 * @author Shift02
 */
public class MCEconomyAPI {

	public static IMPManager MPManager ;

	public static ISoundManager SoundManager ;

	/*
	 *-----------------------
	 *  Minecraft Point
	 *-----------------------
	 */
	public static void addPlayerMP(EntityPlayer entityPlayer, int amount){
		MPManager.addPlayerMP(entityPlayer, amount);
	}

	public static void reducePlayerMP(EntityPlayer entityPlayer, int amount){
		MPManager.reducePlayerMP(entityPlayer, amount);
	}

	public static void setPlayerMP(EntityPlayer entityPlayer, int amount){
		MPManager.setPlayerMP(entityPlayer, amount);
	}

	public static int getPlayerMP(EntityPlayer entityPlayer){
		return MPManager.getPlayerMP(entityPlayer);
	}

	public static void printChatMPMessage(EntityPlayer entityPlayer){
		MPManager.printChatMPMessage(entityPlayer);
	}

	//未実装
	public static void spawnWorldMP(World world, int x, int y, int z, int amount){
		MPManager.spawnWorldMP(world, x, y, z, amount);
	}

	/*
	 *-----------------------
	 *  Sound
	 *-----------------------
	 */
	public static void playCoinSoundEffect(World world, int x, int y, int z){
		SoundManager.playCoinSoundEffect(world, x, y, z);
	}

}
