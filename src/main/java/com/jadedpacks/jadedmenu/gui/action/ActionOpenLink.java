package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomConfirmOpenLink;
import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;

public class ActionOpenLink implements IAction {
	private String link;

	public ActionOpenLink(String link) {
		this.link = link;
	}

	@Override
	public void run(GuiCustomMainMenu menu) {
		GuiCustomConfirmOpenLink guiconfirmopenlink = new GuiCustomConfirmOpenLink(menu, link);
		menu.mc.displayGuiScreen(guiconfirmopenlink);
	}
}