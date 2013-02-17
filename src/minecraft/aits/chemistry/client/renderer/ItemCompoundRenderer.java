package aits.chemistry.client.renderer;

import java.util.Random;

import aits.chemistry.Chemistry;
import aits.chemistry.items.ItemCompound;
import aits.chemistry.util.EnumClassificationList;
import aits.chemistry.util.EnumCompoundList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

public class ItemCompoundRenderer implements IItemRenderer
{
	private final Minecraft MC;
	private ItemStack item;
	Random r = new Random();

	public ItemCompoundRenderer()
	{
		super();
		MC = Minecraft.getMinecraft();
	}


	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		if(type == ItemRenderType.INVENTORY)
			return true;

		if(type == ItemRenderType.EQUIPPED)
			return true;

		if(type == ItemRenderType.ENTITY)
			return true;

		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
					ItemRendererHelper helper)
	{
		if(helper == ItemRendererHelper.ENTITY_BOBBING)
			return true;

		if(helper == ItemRendererHelper.ENTITY_ROTATION)
			return true;

		if(helper == ItemRendererHelper.EQUIPPED_BLOCK)
			return true;

		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data)
	{
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		item = itemstack;
		if(type == ItemRenderType.INVENTORY)
		{
			RenderItemInInventory(itemstack);
		}
		else if(type == ItemRenderType.EQUIPPED)
		{
			RenderItemInHand(itemstack);
		}
		else
		{
			EntityItem EntityItem = (EntityItem)data[1];


			float angle = (MC.getSystemTime() % 8000L) / 8000.0F * 360.0F;
			GL11.glPushMatrix();


			GL11.glTranslatef(-0.345F, 0.0F, 0.065F);


			RenderItemAsEntity(itemstack);
			GL11.glPopMatrix();
		}
	}

	private void RenderItemAsEntity(ItemStack itemstack)
	{
		EnumCompoundList compound = ItemCompound.GetCompoundFromIS(itemstack);

		//		int frame = (int)RChemHelper.translateValue((MC.getSystemTime() % 1500), 0, 1500, 0, 7);
		int TextureID;

		// These are the ones that are centred; we don't render the item name, so there's
		// no need for them to be offset.

		if(ItemCompound.GetStateInRoomTemp(compound) == EnumClassificationList.Gas)
			TextureID = 33;


		else if(ItemCompound.GetStateInRoomTemp(compound) == EnumClassificationList.Liquid)
			TextureID = 34;

		else
			TextureID = 35;




		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		SetColourForCompound(compound);
		DrawTextureIn3D(TextureID);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		DrawTextureIn3D(32);

		// Turn off unneeded transparency flags
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}

	private void DrawTextureIn3D(int TextureID)
	{
		Tessellator tesselator = Tessellator.instance;


		float x = (TextureID % 16 * 16 + 16) / 256.0F;
		float y = (TextureID / 16 * 16 + 0) / 256.0F;
		float u = (TextureID % 16 * 16 + 0) / 256.0F;
		float v = (TextureID / 16 * 16 + 16) / 256.0F;

		float scale = 0.7F;

		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);

		float thickness = 0.075F;

		if(item.stackSize > 16)
			thickness = 0.125F;

		if(item.stackSize > 32)
			thickness = 0.175F;

		if(item.stackSize > 48)
			thickness = 0.225F;

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


		ItemRenderer.renderItemIn2D(tesselator, x, y, u, v, thickness);

		// Turn off unneeded transparency flags
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}

	public static Color ConvertHexColourToRGB(String colour)
	{
		if(colour == "")
		{
			return new Color(255, 255, 255, 128);
		}
		else
		{
			return new Color(Integer.valueOf(colour.substring(3, 5), 16),
							Integer.valueOf(colour.substring(5, 7), 16),
							Integer.valueOf(colour.substring(7, 9), 16),
							Integer.valueOf(colour.substring(1, 3), 16));
		}
	}

	private void SetColourForCompound(EnumCompoundList compound)
	{
		Color C = ConvertHexColourToRGB(compound.GetHexColour());
		GL11.glColor4f(C.getRed() / 255.0F, C.getGreen() / 255.0F, C.getBlue() / 255.0F, C.getAlpha() / 255.0F);
	}


	private void RenderItemInHand(ItemStack itemstack)
	{
		float scale = 0.06F;
		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);




		GL11.glScalef(scale, scale, scale);

		GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-1.1875f, 0.25F, 0.45F);

		RenderCapsuleContents(itemstack);
		for(float i = 0.0F; i < 1.0F; i += 0.1F)
		{
			RenderCapsule(0, 0, i);
		}

		// Turn off unneeded transparency flags
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}

	private void RenderItemInInventory(ItemStack itemstack)
	{
		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


		RenderCapsule(0, 0, 0);
		RenderCapsuleContents(itemstack);



		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);

		if(ItemCompound.GetCompoundFromIS(itemstack).IsElement())
			RenderElementName(Chemistry.GetCompoundList()[itemstack.getItemDamage()].GetChemName(), ItemCompound.GetCompoundFromIS(itemstack));

		GL11.glPopMatrix();
	}

	private void RenderElementName(String ChemName, EnumCompoundList element)
	{
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		FontRenderer fontrenderer = MC.getMinecraft().fontRenderer;

		String unicode = "";

		String NewChemName = ChemName;
		if(element.GetIsIsotope())
		{
			NewChemName = ChemName.substring(0, ChemName.indexOf('_', 0));

			// get the unicode for the isotope number (atomic weight)
			switch(element.GetAtomicNumber() + element.GetNeutronNumber())
			{
				case 1:
					unicode = "\u2071";
					break;

				case 2:
					unicode = "\u00B2";
					break;

				case 3:
					unicode = "\u00B3";
					break;

				case 4:
					unicode = "\u2074";
					break;

				case 5:
					unicode = "\u2075";
					break;

				case 6:
					unicode = "\u2076";
					break;

				case 7:
					unicode = "\u2077";
					break;

				case 8:
					unicode = "\u2078";
					break;
			}
		}
		if(NewChemName.length() < 2)
		{
			NewChemName = " " + unicode + NewChemName;
			unicode = "";
		}
		int xpos = 4;

		if(element.GetIsIsotope())
			xpos -= 2;


		fontrenderer.drawString(unicode + NewChemName, xpos, 8, 0xFFFFFF);
	}

	private void RenderCapsule(float i, float j, float k)
	{
		GL11.glPushMatrix();

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		if(ItemCompound.GetCompoundFromIS(item).IsElement())
			DrawTexturedRectUV(i, j, k, 0, 0, 16, 16);

		else
			DrawTexturedRectUV(i, j, k, 0, 16, 16, 16);


		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);


		GL11.glPopMatrix();
	}


	public void DrawTexturedRectUV(float x, float y, float z, int u, int v, int w, int h)
	{
		float scale = 0.00390625F;
		Tessellator tesselator = Tessellator.instance;
		tesselator.startDrawingQuads();
		tesselator.addVertexWithUV(x, y + h, z, u * scale, (v + h) * scale);
		tesselator.addVertexWithUV(x + w, y + h, z, (u + w) * scale, (v + h) * scale);
		tesselator.addVertexWithUV(x + w, y, z, (u + w) * scale, v * scale);
		tesselator.addVertexWithUV(x, y, z, u * scale, v * scale);
		tesselator.draw();
	}


	private void RenderCapsuleContents(ItemStack itemstack)
	{
		//		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int row = 0;
		int col = 0;
		EnumCompoundList compound = ItemCompound.GetCompoundFromIS(itemstack);
		//		int frame = (int) RChemHelper.translateValue((MC.getSystemTime() % 1500), 0, 1500, 0, 7);

		if(ItemCompound.GetStateInRoomTemp(compound) == EnumClassificationList.Gas)
		{
			col = 1;
			row = 0;
		}
		else if(ItemCompound.GetStateInRoomTemp(compound) == EnumClassificationList.Liquid)
		{
			col = 2;
			row = 0;
		}
		else
		{
			col = 3;
			row = 0;
		}

		SetColourForCompound(compound);
		DrawTexturedRectUV(0, 0, 0, col * 16, row * 16, 16, 16);
		return;
	}
}
