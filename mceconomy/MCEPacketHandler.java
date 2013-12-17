package mceconomy;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class MCEPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(MCEconomy.channels))
		{

			//System.out.println("packet.channel");
			ByteArrayDataInput data = ByteStreams.newDataInput(packet.data);
			String name ;
			int money;
			try
			{
				//name = data.readByte();
				money = data.readInt();

				if(player instanceof EntityPlayer){
					//System.out.println("EntityPlayer");
					((EntityPlayer) player).getEntityData().setInteger("money", money);
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	public static Packet getPacket(EntityPlayer Player)
	{

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//System.out.println("getPacket");



		try
		{
			//dos.writeBytes(Player.getEntityName());
			dos.writeInt(Player.getEntityData().getInteger("money"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = MCEconomy.channels;
		packet.data    = bos.toByteArray();
		packet.length  = bos.size();
		packet.isChunkDataPacket = true;

		return packet;


	}

}
