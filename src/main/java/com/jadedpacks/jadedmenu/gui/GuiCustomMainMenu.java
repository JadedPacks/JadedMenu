package com.jadedpacks.jadedmenu.gui;

import com.jadedpacks.jadedmenu.JadedMenu;
import com.jadedpacks.jadedmenu.gui.action.ActionFunction;
import com.jadedpacks.jadedmenu.gui.action.ActionOpenGui;
import com.jadedpacks.jadedmenu.gui.action.ActionOpenLink;
import com.jadedpacks.jadedmenu.gui.action.ActionQuit;
import com.jadedpacks.jadedmenu.proxy.ClientProxy;
import com.jadedpacks.jadedmenu.utils.Position;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeVersion;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;
import java.util.List;

public class GuiCustomMainMenu extends GuiMainMenu implements GuiYesNoCallback {
	private List<GuiCustomButton> buttons;
	private final List<GuiCustomText> texts;
	private final List<GuiCustomImage> images = Arrays.asList(
		new GuiCustomImage(Position.TOP_CENTER, -100, -40, 200, 1100, "jadedmenu:textures/gui/glass.png", null),
		new GuiCustomImage(Position.TOP_CENTER, -40, 20, 80, 80, "jadedmenu:textures/gui/icon1.png", null)
	);
	private final ResourceLocation resourceBackground = new ResourceLocation("jadedmenu:textures/gui/background.png");
	private final String issuesURL;

	public GuiCustomMainMenu() {
		texts = Arrays.asList(
			new GuiCustomText(Position.BOTTOM_LEFT, 2, -40, 10194114, JadedMenu.config.get("general", "modpack", "MODPACK.NAME").getString(), null),
			new GuiCustomText(Position.BOTTOM_LEFT, 2, -30, 10194114, JadedMenu.config.get("general", "version", "Development").getString(), null),
			new GuiCustomText(Position.BOTTOM_LEFT, 2, -20, 10194114, "By JadedPacks", null),
			new GuiCustomText(Position.BOTTOM_LEFT, 2, -10, 9222338, ForgeVersion.getVersion(), null)
		);
		issuesURL = JadedMenu.config.get("general", "issues", "").getString();
	}

	public void initGui() {
		if(!JadedMenu.isExtra) {
			buttons = Arrays.asList(
				new GuiCustomButton(6000, Position.CENTER, -70, 50, 70, 20, "menu.singleplayer", null, null, ActionOpenGui.SINGLEPLAYER),
				new GuiCustomButton(6001, Position.CENTER, 1, 50, 70, 20, "menu.multiplayer", null, null, ActionOpenGui.MULTIPLAYER),
				new GuiCustomButton(6002, Position.CENTER, -70, 71, 70, 20, "Extras", null, null, new ActionFunction(new Runnable() {
					@Override
					public void run() {
						JadedMenu.isExtra = true;
						mc.displayGuiScreen(ClientProxy.menu);
					}
				})),
				new GuiCustomButton(6003, Position.CENTER, 1, 71, 70, 20, "menu.quit", "Awww :(", "jadedmenu:textures/gui/buttonexit.png", new ActionQuit())
			);
		} else {
			buttons = Arrays.asList(
				new GuiCustomButton(6005, Position.CENTER, -70, 50, 70, 20, "Mods", null, null, ActionOpenGui.MODS),
				new GuiCustomButton(6006, Position.CENTER, 1, 50, 70, 20, "menu.options", null, null, ActionOpenGui.OPTIONS),
				new GuiCustomButton(6007, Position.CENTER, -70, 71, 70, 20, "Language", null, null, ActionOpenGui.LANGUAGES),
				new GuiCustomButton(6008, Position.CENTER, 1, 71, 70, 20, "Bug Reports", null, null, new ActionOpenLink("https://github.com/JadedPacks/" + issuesURL + "/issues")),
				new GuiCustomButton(6009, Position.CENTER, -70, 92, 70, 20, "Discord", null, null, new ActionOpenLink("https://discord.gg/bkyMbv2")),
				new GuiCustomButton(6010, Position.CENTER, 1, 92, 70, 20, "Go Back", null, null, new ActionFunction(new Runnable() {
					@Override
					public void run() {
						JadedMenu.isExtra = false;
						mc.displayGuiScreen(ClientProxy.menu);
					}
				}))
			);
		}
	}

	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(resourceBackground);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(width, height, 0, 1, 1);
		tessellator.addVertexWithUV(width, 0, 0, 1, 0);
		tessellator.addVertexWithUV(0, 0, 0, 0, 0);
		tessellator.addVertexWithUV(0, height, 0, 0, 1);
		tessellator.draw();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		for(final GuiCustomImage image : images) {
			image.drawImage(mc, mouseX, mouseY);
		}
		GL11.glDisable(3042);
		for(final GuiCustomText text : texts) {
			text.drawText(mc, mouseX, mouseY);
		}
		for(final GuiCustomButton button : buttons) {
			button.drawButton(mc, mouseX, mouseY);
		}
	}
	@Override
	protected void mouseClicked(final int x, final int y, final int button) {
		if(button == 0) {
			for(final GuiCustomButton guibutton : buttons) {
				if(guibutton.mousePressed(mc, x, y)) {
					mc.getSoundHandler().playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("gui.button.press"), 1));
					if(guibutton.action != null) {
						guibutton.action.run(this);
					}
					break;
				}
			}
		}
	}
}