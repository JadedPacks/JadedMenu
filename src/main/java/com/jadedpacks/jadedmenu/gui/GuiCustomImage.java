package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

class GuiCustomImage {
	private Position position;
	private int xPosition, yPosition;
	private ResourceLocation image, hoverImage;

	GuiCustomImage(final Position position, final int xPosition, final int yPosition, final String image, final String hoverImage) {
		this.position = position;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.image = new ResourceLocation(image);
		this.hoverImage = hoverImage != null ? new ResourceLocation(hoverImage) : null;
	}

	void drawImage(final Minecraft mc, final int mouseX, final int mouseY) {
		mc.getTextureManager().bindTexture(image);
		final double width = GL11.glGetTexLevelParameteri(3553, 0, 4096),
			height = GL11.glGetTexLevelParameteri(3553, 0, 4097);
		final int xPos = position.modX(mc.currentScreen.width, xPosition),
			yPos = position.modY(mc.currentScreen.height, yPosition);
		final boolean hovered = mouseX > xPos && mouseY > yPos && mouseX < xPos + width && mouseY < yPos + height;
		if(hovered && hoverImage != null) {
			mc.getTextureManager().bindTexture(hoverImage);
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float) xPos, (float) yPos, 0.0f);
		GL11.glBegin(7);
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(0.0f, 0.0f, 0.0f);
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f(0.0f, (float) height, 0.0f);
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f((float) width, (float) height, 0.0f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f((float) width, 0.0f, 0.0f);
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}