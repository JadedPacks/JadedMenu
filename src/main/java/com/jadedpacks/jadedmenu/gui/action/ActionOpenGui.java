package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import cpw.mods.fml.client.GuiModList;
import net.minecraft.client.gui.*;

public enum ActionOpenGui implements IAction {
	MODS,
	SINGLEPLAYER,
	CREATE_WORLD,
	MULTIPLAYER,
	OPTIONS,
	LANGUAGES;

	@Override
	public void run(GuiCustomMainMenu menu) {
		switch(this) {
			case MODS: {
				menu.mc.displayGuiScreen(new GuiModList(menu));
			}
			case SINGLEPLAYER: {
				menu.mc.displayGuiScreen(new GuiSelectWorld(menu));
			}
			case CREATE_WORLD: {
				menu.mc.displayGuiScreen(new GuiCreateWorld(menu));
			}
			case MULTIPLAYER: {
				menu.mc.displayGuiScreen(new GuiMultiplayer(menu));
			}
			case OPTIONS: {
				menu.mc.displayGuiScreen(new GuiOptions(menu, menu.mc.gameSettings));
			}
			case LANGUAGES: {
				menu.mc.displayGuiScreen(new GuiLanguage(menu, menu.mc.gameSettings, menu.mc.getLanguageManager()));
			}
		}
	}
}