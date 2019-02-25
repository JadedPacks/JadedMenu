package com.jadedpacks.jadedmenu.utils;

import org.lwjgl.opengl.GL11;

public class Render {
	public static void drawPartialImage(final int posX, final int posY, final int imageX, final int imageY, final int width, final int height, final int imagePartWidth, final int imagePartHeight) {
		final double einsTeilerWidth = 1.0 / GL11.glGetTexLevelParameteri(3553, 0, 4096),
			uvWidth = einsTeilerWidth * imagePartWidth,
			uvX = einsTeilerWidth * imageX,
			einsTeilerHeight = 1.0 / GL11.glGetTexLevelParameteri(3553, 0, 4097),
			uvHeight = einsTeilerHeight * imagePartHeight,
			uvY = einsTeilerHeight * imageY;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) posX, (float) posY, 0.0f);
		GL11.glBegin(7);
		GL11.glTexCoord2d(uvX, uvY);
		GL11.glVertex3f(0.0f, 0.0f, 0.0f);
		GL11.glTexCoord2d(uvX, uvY + uvHeight);
		GL11.glVertex3f(0.0f, (float) height, 0.0f);
		GL11.glTexCoord2d(uvX + uvWidth, uvY + uvHeight);
		GL11.glVertex3f((float) width, (float) height, 0.0f);
		GL11.glTexCoord2d(uvX + uvWidth, uvY);
		GL11.glVertex3f((float) width, 0.0f, 0.0f);
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}