package mceconomy;

import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.ARMOR;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class MCEEventHandler {

    public static final ResourceLocation icons = new ResourceLocation("mceconomy:textures/gui/coin.png");

    public static int left_height = 39;
    public static int right_height = 39;

    public static Minecraft mc = FMLClientHandler.instance().getClient();

    public static boolean AIR = false;

    //描写のEvent
    @ForgeSubscribe
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent event) {

        int width = event.resolution.getScaledWidth();
        int height = event.resolution.getScaledHeight();
        //System.out.println("onRenderGameOverlayEvent");
        //System.out.println("onRenderGameOverlayEvent"+event.type);

        //FMLClientHandler.instance().getClient().playerController.enableEverythingIsScrewedUpMode() インベントリを開いているかどうか

        if(event.type == ElementType.CROSSHAIRS&&FMLClientHandler.instance().getClient().playerController.enableEverythingIsScrewedUpMode()){

            event.setCanceled(true);
            bind(this.icons);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_COLOR);
            drawTexturedModalRect(width / 2 - 7, height / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(GL11.GL_BLEND);

        }

        if(event.type == ElementType.HEALTH){
            renderMoney( width, height);
        }

        if(event.type == ElementType.AIR){
        	//System.out.println("AIR");

            if(!AIR){
                GuiIngameForge.right_height+=10;
               // System.out.println("AIR222");
                AIR =true;
            }else
                GuiIngameForge.right_height-=10;
                AIR =false;
        }


    }


    protected void renderMoney(int width, int height)
    {

        mc.mcProfiler.startSection("money");

        bind(icons);

        int air =0;
        /*
        if(mc.thePlayer.isInsideOfMaterial(Material.water)){
            air = -10;
        }*/

        int left = width / 2 +9;
        int top = height - left_height-10+air;

        //int level = ForgeHooks.getTotalArmorValue(mc.thePlayer);
        drawTexturedModalRect(left, top, 9, 0, 9, 9);
        drawTexturedModalRect(left+65, top, 0, 18, 9, 9);
        drawTexturedModalRect(left+74, top, 9, 18, 9, 9);
       // drawTexturedModalRect(left+8, top, 9, 0, 9, 9);
        //drawTexturedModalRect(left+16, top, 9, 0, 9, 9);
        //drawTexturedModalRect(left+24, top, 9, 0, 9, 9);

        int money = 0;

        if(mc.thePlayer!=null){
        	NBTTagCompound nbt = mc.thePlayer.getEntityData();
        	money = nbt.getInteger("money");
        }

        left +=56;


        for (int i = 1; i<= String.valueOf(money).length(); i += 1)
        {
        	String s = String.valueOf(money).substring(String.valueOf(money).length()-i, String.valueOf(money).length()-i+1);
        	drawTexturedModalRect(left, top, 9*Integer.parseInt(s), 9, 9, 9);
        	left-=8;
        }

        /*
        for (int i = 1; level > 0 && i < 20; i += 2)
        {
            if (i < level)
            {
                drawTexturedModalRect(left, top, 34, 9, 9, 9);
            }
            else if (i == level)
            {
                drawTexturedModalRect(left, top, 25, 9, 9, 9);
            }
            else if (i > level)
            {
                drawTexturedModalRect(left, top, 16, 9, 9, 9);
            }
            left += 8;
        }
        */
        //left_height += 10;

        mc.mcProfiler.endSection();
        bind(Gui.icons);

    }

    private void bind(ResourceLocation res)
    {
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(res);
    }

    public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        float zLevel = -90.0F;

        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }


    @ForgeSubscribe
    public void onGuiOpenEvent(GuiOpenEvent event) {
    	if(event.gui instanceof GuiInventory){

    		event.gui = new GuiNCEInventory(mc.thePlayer);

    		/*
    		bind(icons);

    		int left = event.gui.width / 2 +9;
            int top = event.gui.height +20;

            drawTexturedModalRect(left, top, 9, 0, 9, 9);
            */

    		System.out.println("GuiOpenEvent");
    	}

    }


}
