package com.jadedpacks.jadedmenu;

import com.jadedpacks.jadedmenu.gui.GuiCustomButton;
import com.jadedpacks.jadedmenu.gui.GuiCustomText;
import com.jadedpacks.jadedmenu.utils.Position;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.Arrays;
import java.util.List;

@Mod(modid = "JadedMenu", name = "JadedMenu", version = "@VERSION@")
public class JadedMenu {
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		List<GuiCustomButton> buttons = Arrays.asList(
			new GuiCustomButton(0, -70, 50, 70, 20, "menu.singleplayer", null),
			new GuiCustomButton(1, 0, 50, 70, 20, "menu.singleplayer", null),
			new GuiCustomButton(2, -70, 70, 70, 20, "Extras", null),
			new GuiCustomButton(3, 0, 70, 70, 20, "menu.quit", "Awww, don't leave"),
			new GuiCustomButton(4, 80, -25, 50, 20, "Patreon", null)
		);
		List<GuiCustomText> texts = Arrays.asList(
			new GuiCustomText(0, Position.BOTTOM_CENTER, -70, -40, 10194114, "modpack.name", null),
			new GuiCustomText(1, Position.BOTTOM_CENTER, -70, -30, -1, "modpack.version", null),
			new GuiCustomText(2, Position.BOTTOM_CENTER, -70, -20, 9222338, "By JadedPacks", null),
			new GuiCustomText(3, Position.BOTTOM_CENTER, -70, -10, -1, "forge.version", null)
		);
		// TODO
		// DMF, please do some hacking stuff here ^-^
	}
}