package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.gui.action.ActionOpenGui;
import com.jadedpacks.jadedmenu.gui.action.ActionOpenLink;
import com.jadedpacks.jadedmenu.gui.action.ActionQuit;
import com.jadedpacks.jadedmenu.utils.Position;
import com.jadedpacks.jadedmenu.utils.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;
import java.util.List;

public class GuiCustomMainMenu extends GuiMainMenu {
	private List<GuiCustomButton> buttons = Arrays.asList(
		new GuiCustomButton(0, Position.CENTER, -70, 50, 70, 20, "menu.singleplayer", null, ActionOpenGui.SINGLEPLAYER),
		new GuiCustomButton(1, Position.CENTER, 0, 50, 70, 20, "menu.multiplayer", null, ActionOpenGui.MULTIPLAYER),
		new GuiCustomButton(2, Position.CENTER, -70, 70, 70, 20, "Extras", null, null), // TODO: Open custom gui
		new GuiCustomButton(3, Position.CENTER, 0, 70, 70, 20, "menu.quit", "Awww, don't leave", new ActionQuit()),
		new GuiCustomButton(4, Position.CENTER, 80, -25, 50, 20, "Patreon", null, new ActionOpenLink("http://google.com")) // TODO: Get a patreon link?
	);
	private List<GuiCustomText> texts = Arrays.asList(
		new GuiCustomText(0, Position.BOTTOM_CENTER, -70, -40, 10194114, "modpack.name", null),
		new GuiCustomText(1, Position.BOTTOM_CENTER, -70, -30, -1, "modpack.version", null),
		new GuiCustomText(2, Position.BOTTOM_CENTER, -70, -20, 9222338, "By JadedPacks", null),
		new GuiCustomText(3, Position.BOTTOM_CENTER, -70, -10, -1, "forge.version", null)
	);
	private List<GuiCustomImage> images = Arrays.asList(
		new GuiCustomImage(Position.TOP_CENTER, 0, 0, "textures/gui/title/minecraft.png", null)
	);
	private String splashText = null;

	public void initGui() {
	}

	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		drawBackground();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		for(final GuiCustomImage image : images) {
			image.drawImage(mc, mouseX, mouseY);
		}
		GL11.glDisable(3042);
		if(splashText != null) {
			Tessellator tessellator = Tessellator.instance;
			tessellator.setColorOpaque_I(-1);
			GL11.glPushMatrix();
			// TODO:                    modX                modY
			GL11.glTranslatef((float) (width / 2 + 90), 70.0f, 0.0f);
			GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
			float f1 = 1.8F - MathHelper.abs(MathHelper.sin((float) (Minecraft.getSystemTime() % 1000L) / 1000.0f * 3.1415927f * 2.0f) * 0.1f);
			f1 = f1 * 100.0f / (float) (fontRenderer.getStringWidth(splashText) + 32);
			GL11.glScalef(f1, f1, f1);
			// TODO:                        2                    color
			drawCenteredString(fontRenderer, splashText, 0, -8, 16776960);
			GL11.glPopMatrix();
		}
		for(final GuiCustomText text : texts) {
			text.drawText(mc, mouseX, mouseY);
		}
		for(final GuiCustomButton button : buttons) {
			button.drawButton(mc, mouseX, mouseY);
		}
	}

	protected void actionPerformed(GuiButton button) {
		if(button instanceof GuiCustomButton) {
			GuiCustomButton butt = (GuiCustomButton) button;
			if(butt.action != null) {
				butt.action.run(this);
			}
		}
	}

	private void drawBackground() {
		mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/title/background/panorama_0.png"));
		final int imageWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096),
			imageHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097);
		final float factorWidth = width / imageWidth,
			factorHeight = height / imageHeight,
			factor = factorWidth > factorHeight ? factorWidth : factorHeight;
		final int drawWidth = (int) (imageWidth * factorWidth),
			drawHeight = (int) (imageWidth * factor);
		Render.drawPartialImage(0, 0, 0, 0, drawWidth, drawHeight, imageWidth, imageHeight);
	}
}