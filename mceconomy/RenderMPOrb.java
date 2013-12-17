package mceconomy;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderXPOrb;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class RenderMPOrb extends RenderXPOrb{

	private static final ResourceLocation MP_ORB = new ResourceLocation("mceconomy:textures/Items/coin.png");
	private Random random = new Random();

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
		this.bindTexture(MP_ORB);
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return MP_ORB;
	}


}
