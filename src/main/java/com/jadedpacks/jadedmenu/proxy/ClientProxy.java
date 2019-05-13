package com.jadedpacks.jadedmenu.proxy;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientProxy extends CommonProxy {
	public static GuiCustomMainMenu menu;

	public void preInit() {
		menu = new GuiCustomMainMenu();
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onOpenGui(final GuiOpenEvent event) {
		if(event.gui instanceof GuiMainMenu) {
			event.gui = menu;
		}
	}
}