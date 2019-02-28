package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

class GuiCustomImage extends Gui {
	private Position position;
	private int xPosition, yPosition, width, height;
	private ResourceLocation image, hoverImage;

	GuiCustomImage(final Position position, final int xPosition, final int yPosition, final int width, final int height, final String image, final String hoverImage) {
		this.position = position;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
		this.image = new ResourceLocation(image);
		this.hoverImage = hoverImage != null ? new ResourceLocation(hoverImage) : null;
	}

	void drawImage(final Minecraft mc, final int mouseX, final int mouseY) {
		mc.getTextureManager().bindTexture(image);
		final int xPos = position.modX(mc.currentScreen.width, xPosition),
			yPos = position.modY(mc.currentScreen.height, yPosition);
		final boolean hovered = mouseX > xPos && mouseY > yPos && mouseX < xPos + width && mouseY < yPos + height;
		if(hovered && hoverImage != null) {
			mc.getTextureManager().bindTexture(hoverImage);
		}
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, 0);
		GL11.glBegin(7);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, height, 0);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, height, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}