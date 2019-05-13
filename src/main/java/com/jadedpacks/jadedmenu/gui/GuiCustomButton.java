package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.gui.action.IAction;
import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCustomButton extends GuiButton {
	private ResourceLocation texture;
	private String hoverText;
	private Position position;
	IAction action;

	GuiCustomButton(final int buttonID, final Position position, final int xPosition, final int yPosition, final int width, final int height, String text, String hoverText, String texture, IAction action) {
		super(buttonID, xPosition, yPosition, width, height, text);
		this.position = position;
		this.hoverText = hoverText;
		this.texture = new ResourceLocation(texture == null ? "jadedmenu:textures/gui/button3.png" : texture);
		this.action = action;
	}

	@Override
	public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
		final int xPos = position.modX(mc.currentScreen.width, xPosition),
			yPos = position.modY(mc.currentScreen.height, yPosition);
		final boolean hovered = mousePressed(mc, mouseX, mouseY);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(xPos, yPos, 0, (getHoverState(hovered) - 1) * height, width, height);
		mouseDragged(mc, mouseX, mouseY);
		int color = 14737632;
		if(!enabled) {
			color = -6250336;
		} else if(hovered) {
			color = 16777120;
		}
		drawCenteredString(mc.fontRendererObj, I18n.format(hovered && hoverText != null ? hoverText : displayString), xPos + width / 2, yPos + (height - 8) / 2, color);
	}

	@Override
	public boolean mousePressed(final Minecraft mc, final int mouseX, final int mouseY) {
		final int xPos = position.modX(mc.currentScreen.width, xPosition),
			yPos = position.modY(mc.currentScreen.height, yPosition);
		return mouseX > xPos && mouseY > yPos && mouseX < xPos + width && mouseY < yPos + height;
	}
}