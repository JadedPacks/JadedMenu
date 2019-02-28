package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.gui.action.ActionOpenGui;
import com.jadedpacks.jadedmenu.gui.action.ActionOpenLink;
import com.jadedpacks.jadedmenu.gui.action.ActionQuit;
import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;
import java.util.List;

public class GuiCustomMainMenu extends GuiMainMenu {
	private List<GuiCustomText> texts = Arrays.asList(
		new GuiCustomText(Position.BOTTOM_CENTER, -70, -40, 10194114, "modpack.name", null),
		new GuiCustomText(Position.BOTTOM_CENTER, -70, -30, -1, "modpack.version", null),
		new GuiCustomText(Position.BOTTOM_CENTER, -70, -20, 9222338, "By JadedPacks", null),
		new GuiCustomText(Position.BOTTOM_CENTER, -70, -10, -1, "forge.version", null)
	);
	private List<GuiCustomImage> images = Arrays.asList(
		new GuiCustomImage(Position.TOP_CENTER, -100, -40, 200, 1100, "jadedmenu:textures/gui/glass.png", null),
		new GuiCustomImage(Position.TOP_CENTER, -40, 20, 80, 80, "jadedmenu:textures/gui/icon1.png", null)
	);
	private final ResourceLocation resourceBackground = new ResourceLocation("jadedmenu:textures/gui/background.png");
	private String splashText = null;

	public void initGui() {
		buttonList.addAll(Arrays.asList(
			new GuiCustomButton(6000, Position.CENTER, -70, 50, 70, 20, "menu.singleplayer", null, null, ActionOpenGui.SINGLEPLAYER),
			new GuiCustomButton(6001, Position.CENTER, 1, 50, 70, 20, "menu.multiplayer", null, null, ActionOpenGui.MULTIPLAYER),
			new GuiCustomButton(6002, Position.CENTER, -70, 71, 70, 20, "Extras", null, null, null), // TODO: Open custom gui
			new GuiCustomButton(6003, Position.CENTER, 1, 71, 70, 20, "menu.quit", "Awww, don't leave", "jadedmenu:textures/gui/buttonexit.png", new ActionQuit()),
			new GuiCustomButton(6004, Position.BOTTOM_CENTER, -25, -25, 50, 20, "Patreon", null, null, new ActionOpenLink("http://google.com")) // TODO: Get a patreon link?
		));
	}

	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.getTextureManager().bindTexture(resourceBackground);
		drawTexturedModalRect(0, 0, 0, 0, width, height);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		for(final GuiCustomImage image : images) {
			image.drawImage(mc, mouseX, mouseY);
		}
		GL11.glDisable(3042);
		// TODO: SplashText
		if(splashText != null) {
			drawCenteredString(fontRenderer, splashText, 0, -8, 16776960 /* color */);
		}
		// TODO: Text's are not drawing
		for(final GuiCustomText text : texts) {
			text.drawText(mc, mouseX, mouseY);
		}
		for(final GuiButton button : (List<GuiButton>) buttonList) {
			button.drawButton(mc, mouseX, mouseY);
		}
	}

	@Override
	protected void actionPerformed(final GuiButton button) {
		if(button instanceof GuiCustomButton) {
			final GuiCustomButton butt = (GuiCustomButton) button;
			if(butt.action != null) {
				butt.action.run(this);
			}
		}
	}
}