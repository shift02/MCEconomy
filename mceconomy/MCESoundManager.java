package mceconomy;

import net.minecraft.world.World;
import mceconomy.api.ISoundManager;

public class MCESoundManager implements ISoundManager {

	@Override
	public void playCoinSoundEffect(World world, int x, int y, int z) {

		world.playSoundEffect(x, y, z, COIN_SOUND, 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);

	}

}
