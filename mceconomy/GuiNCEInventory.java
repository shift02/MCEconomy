package mceconomy;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class GuiNCEInventory extends GuiInventory{

	public GuiNCEInventory(EntityPlayer par1EntityPlayer) {
		super(par1EntityPlayer);
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
		this.mc.getTextureManager().bindTexture(MCEEventHandler.icons);

		//int k = this.guiLeft/2+30;
        //int l = this.guiTop/2+80;

		super.drawGuiContainerForegroundLayer(par1, par2);
    }

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(MCEEventHandler.icons);
		//int k = this.guiLeft/2;
        //int l = this.guiTop/2;
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k+83, l+64, 0, 27, 86, 15);

        this.drawTexturedModalRect(k+86, l+67, 9, 0, 9, 9);

        int a = -3;

        drawTexturedModalRect(k+(86 +65)+a, l+67, 0, 18, 9, 9);
        drawTexturedModalRect(k+(86 +74)+a, l+67, 9, 18, 9, 9);

        int money = 0;

        if(mc.thePlayer!=null){
        	NBTTagCompound nbt = mc.thePlayer.getEntityData();
        	money = nbt.getInteger("money");
        }
        k += (86 +56)+a;

        for (int i = 1; i<= String.valueOf(money).length(); i += 1)
        {
        	String s = String.valueOf(money).substring(String.valueOf(money).length()-i, String.valueOf(money).length()-i+1);
        	drawTexturedModalRect(k, l+67, 9*Integer.parseInt(s), 9, 9, 9);
        	k-=8;
        }



    }

}
