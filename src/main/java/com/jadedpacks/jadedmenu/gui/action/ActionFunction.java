package com.jadedpacks.jadedmenu.gui.action;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;

public class ActionFunction implements IAction {
	private Runnable func;

	public ActionFunction(Runnable func) {
		this.func = func;
	}

	@Override
	public void run(GuiCustomMainMenu menu) {
		func.run();
	}
}