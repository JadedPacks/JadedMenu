package com.jadedpacks.jadedmenu.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.resources.I18n;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;

public class GuiCustomConfirmOpenLink extends GuiYesNo {
	private GuiCustomMainMenu parent;
	private String link;

	public GuiCustomConfirmOpenLink(GuiCustomMainMenu parent, String link) {
		super(parent, I18n.format("chat.link.confirm"), link, -1);
		this.parent = parent;
		this.link = link;
	}

	public void initGui() {
		buttonList.addAll(Arrays.asList(
			new GuiButton(0, width / 3 - 83, height / 6 + 96, 100, 20, I18n.format("gui.yes")),
			new GuiButton(2, width / 3 - 83 + 105, height / 6 + 96, 100, 20, I18n.format("chat.copy")),
			new GuiButton(1, width / 3 - 83 + 210, height / 6 + 96, 100, 20, I18n.format("gui.no"))
		));
	}

	protected void actionPerformed(GuiButton button) {
		if(button.id == 0) {
			try {
				Desktop.getDesktop().browse(new URI(link));
			} catch(Throwable t) {
				t.printStackTrace();
			}
		} else if(button.id == 2) {
			copyLinkToClipboard();
		}
		mc.displayGuiScreen(parent);
	}

	private void copyLinkToClipboard() {
		setClipboardString(link);
	}
}