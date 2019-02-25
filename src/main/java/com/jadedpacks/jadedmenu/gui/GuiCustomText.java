package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;

public class GuiCustomText extends Gui {
	private String text, hoverText;
	private int textID, xPosition, yPosition, color;
	private Position position;

	GuiCustomText(final int textID, final Position position, final int xPosition, final int yPosition, final int color, String text, String hoverText) {
		this.textID = textID;
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
		final boolean hovered = mouseX > xPos && mouseY > yPos && mouseX < xPos + renderer.getStringWidth(text) && mouseY < yPos + renderer.FONT_HEIGHT;
		drawString(renderer, I18n.getString(hovered && hoverText != null ? hoverText : text), xPosition, yPosition, color);
	}
}