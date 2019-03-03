package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;

class GuiCustomText extends Gui {
	private String text, hoverText;
	private int xPosition, yPosition, color;
	private Position position;

	GuiCustomText(final Position position, final int xPosition, final int yPosition, final int color, String text, String hoverText) {
		this.position = position == null ? Position.TOP_LEFT : position;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.color = color;
		this.text = text;
		this.hoverText = hoverText;
	}

	void drawText(final Minecraft mc, final int mouseX, final int mouseY) {
		final int xPos = position.modX(mc.currentScreen.width, xPosition),
			yPos = position.modY(mc.currentScreen.height, yPosition);
		final FontRenderer renderer = mc.fontRenderer;
		drawString(renderer, I18n.getString(hoverText != null && mouseX > xPos && mouseY > yPos && mouseX < xPos + renderer.getStringWidth(text) && mouseY < yPos + renderer.FONT_HEIGHT ? hoverText : text), xPos, yPos, color);
	}
}