package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;

public class ActionQuit implements IAction {
	@Override
	public void run(final GuiCustomMainMenu menu) {
		menu.mc.shutdown();
	}
}