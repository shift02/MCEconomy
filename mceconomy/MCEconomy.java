package mceconomy;

import java.util.logging.Logger;



import mceconomy.api.MCEconomyAPI;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod
(
	    modid   = "MCEconomy",
	    name    = "MC Economy",
	    version = MCEconomy.version
)

@NetworkMod
(
	    clientSideRequired = true,
	    serverSideRequired = false,
	    channels = {MCEconomy.channels , MCEconomy.channels2},
		packetHandler = MCEPacketHandler.class
)
public class MCEconomy {

	public static final String version = "1.0.0";

	public static final String channels = "Money";
	public static final String channels2 = "Money2";

	public static final Logger Log = Logger.getLogger("MCEconomy");

	@Mod.Instance("MCEconomy")
    public static MCEconomy instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		MCEconomyAPI.MPManager = new MPManager();
		MCEconomyAPI.SoundManager = new MCESoundManager();

		MinecraftForge.EVENT_BUS.register(new MCEEventHandler());
		Log.info("Starting up MCEconomy preInit");


		if(event.getSide()==Side.CLIENT){
			RenderingRegistry.registerEntityRenderingHandler(EntityMPOrb.class, new RenderMPOrb());

		}
		EntityRegistry.registerModEntity(EntityMPOrb.class, "MPOrb", 1, this, 100, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityMPOrb.class, "MPOrb", 240);


	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {

		Log.info("Starting up MCEconomy Init");

		GameRegistry.registerPlayerTracker(new MCEPlayerTracker());
		MinecraftForge.EVENT_BUS.register(new MCESoundEvents());

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}
