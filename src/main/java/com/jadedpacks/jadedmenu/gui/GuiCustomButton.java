package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.gui.action.IAction;
import com.jadedpacks.jadedmenu.utils.Position;
import com.jadedpacks.jadedmenu.utils.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCustomButton extends GuiButton {
	// TODO: Custom texture
	private ResourceLocation texture = new ResourceLocation("textures/gui/widgets.png");
	private String hoverText;
	private Position position;
	IAction action;

	GuiCustomButton(final int buttonID, final Position position, final int xPosition, final int yPosition, final int width, final int height, String text, String hoverText, IAction action) {
		super(buttonID, xPosition, yPosition, width, height, text);
		this.position = position;
		this.hoverText = hoverText;
		this.action = action;
	}

	@Override
	public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
		if(drawButton) {
			final int xPos = position.modX(mc.currentScreen.width, xPosition),
				yPos = position.modY(mc.currentScreen.height, yPosition);
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			final boolean hovered = mouseX > xPos && mouseY > yPos && mouseX < xPos + width && mouseY < yPos + height;
			final int i = getHoverState(hovered);
			GL11.glEnable(3042);
			//OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(770, 771);
			mc.getTextureManager().bindTexture(texture);
			Render.drawPartialImage(xPos, yPos, 0, (i - 1) * height, width, height, width, height);
			mouseDragged(mc, mouseX, mouseY);
			int color = 14737632;
			if(!enabled) {
				color = -6250336;
			} else if(hovered) {
				color = 16777120;
			}
			drawCenteredString(mc.fontRenderer, I18n.getString(hovered && hoverText != null ? hoverText : displayString), xPos + width / 2, yPos + (height - 8) / 2, color);
		}
	}
}