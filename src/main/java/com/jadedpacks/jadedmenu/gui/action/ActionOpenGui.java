package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import com.jadedpacks.jadedmenu.gui.GuiCustomMultiplayer;
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
			case MODS:
				menu.mc.displayGuiScreen(new GuiModList(menu));
				break;
			case SINGLEPLAYER:
				menu.mc.displayGuiScreen(new GuiSelectWorld(menu));
				break;
			case CREATE_WORLD:
				menu.mc.displayGuiScreen(new GuiCreateWorld(menu));
				break;
			case MULTIPLAYER:
				menu.mc.displayGuiScreen(new GuiCustomMultiplayer(menu));
				break;
			case OPTIONS:
				menu.mc.displayGuiScreen(new GuiOptions(menu, menu.mc.gameSettings));
				break;
			case LANGUAGES:
				menu.mc.displayGuiScreen(new GuiLanguage(menu, menu.mc.gameSettings, menu.mc.getLanguageManager()));
				break;
		}
	}
}