package mceconomy;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class MCESoundEvents {

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {
		event.manager.soundPoolSounds.addSound("mceconomy:coin.ogg");
	}

}
