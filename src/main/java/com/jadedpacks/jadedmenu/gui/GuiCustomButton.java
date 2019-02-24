package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.utils.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCustomButton extends GuiButton {
	// TODO: Custom texture
	private ResourceLocation texture = new ResourceLocation("textures/gui/widgets.png");
	private String hoverText;

	public GuiCustomButton(final int buttonID, final int posX, final int posY, final int width, final int height, String text, String hoverText) {
		super(buttonID, posX, posY, width, height, text);
		this.hoverText = hoverText;
	}

	@Override
	public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
		if(drawButton) {
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			final boolean hovered = mouseX > xPosition && mouseY > yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
			final int i = getHoverState(hovered);
			GL11.glEnable(3042);
			//OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(770, 771);
			mc.getTextureManager().bindTexture(texture);
			Render.drawPartialImage(xPosition, yPosition, 0, (i - 1) * height, width, height, width, height);
			mouseDragged(mc, mouseX, mouseY);
			int color = 14737632;
			if(!enabled) {
				color = -6250336;
			} else if(hovered) {
				color = 16777120;
			}
			drawCenteredString(mc.fontRenderer, hovered ? hoverText : displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);
		}
	}
}