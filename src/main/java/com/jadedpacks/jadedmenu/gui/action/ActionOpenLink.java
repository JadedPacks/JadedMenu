package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import net.minecraft.client.gui.GuiConfirmOpenLink;

public class ActionOpenLink implements IAction {
	private String link;

	public ActionOpenLink(String link) {
		this.link = link;
	}

	@Override
	public void run(GuiCustomMainMenu menu) {
		GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(menu, link, -1, true);
		guiconfirmopenlink.func_92026_h();
		menu.mc.displayGuiScreen(guiconfirmopenlink);
	}
}