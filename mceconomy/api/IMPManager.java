package mceconomy.api;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

/**
 * MPを管理するClass
 * @author Shift02
 */
public interface IMPManager {

	public static final Minecraft mc = FMLClientHandler.instance().getClient();

	/**
	 * addPlayerMP 指定したプレイヤーのMPを追加
	 * @param entityPlayer MPを追加するプレイヤー
	 * @param amount MPの額
	 */
	public void addPlayerMP(EntityPlayer entityPlayer, int amount);

	/**
	 * reducePlayerMP 指定したプレイヤーのMPを削減
	 * @param entityPlayer MPを追加するプレイヤー
	 * @param amount MPの額
	 */
	public void reducePlayerMP(EntityPlayer entityPlayer, int amount);

	/**
	 * setPlayerMP  指定したプレイヤーのMPを設定
	 * @param entityPlayer MPを設定するプレイヤー
	 * @param amount MPの額
	 */
	public void setPlayerMP(EntityPlayer entityPlayer, int amount);

	/**
	 * getPlayerMP 指定したプレーヤーの所持金額を返す
	 * @param entityPlayer MPを所持するプレイヤー
	 * @return プレイヤーの所持しておるMP量
	 */
	public int getPlayerMP(EntityPlayer entityPlayer);


	/**
	 * printChatMPMessage 指定したプレーヤーの所持金額ををチャット欄に表示
	 * @param entityPlayer MPを所持するプレイヤー
	 */
	public void printChatMPMessage(EntityPlayer entityPlayer);

	/**
	 * spawnWorldMP ワールドにMPコインをスポーンさせる
	 * @param world ワールド
	 * @param x x軸
	 * @param y y軸
	 * @param z z軸
	 * @param amount MPの額
	 */
	public void spawnWorldMP(World world, int x, int y, int z, int amount);

}
