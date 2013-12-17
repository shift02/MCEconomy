package mceconomy.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * MCEの音楽を管理するClass
 * @author Shift02
 */
public interface ISoundManager {

	public static final String COIN_SOUND = "mceconomy:coin";

	/**
	 * playCoinSoundEffect コインを取得した時の音をならす
	 * @param world ワールド
	 * @param x x軸
	 * @param y y軸
	 * @param z z軸
	 */
	public void playCoinSoundEffect(World world, int x, int y, int z);

}
