package mceconomy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.IPlayerTracker;

public class MCEPlayerTracker implements IPlayerTracker{

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		if(player instanceof EntityPlayerMP){
			EntityPlayerMP P = (EntityPlayerMP) player;
			P.playerNetServerHandler.sendPacketToPlayer(MCEPacketHandler.getPacket(player));
		}

	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
