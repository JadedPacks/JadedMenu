package com.jadedpacks.jadedmenu;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

@Mod(modid = "jadedmenu", name = "JadedMenu", version = "${mcversion}")
public class JadedMenu {
	@SideOnly(Side.CLIENT)
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onOpenGui(GuiOpenEvent event) {
		if(event.gui instanceof GuiMainMenu) {
			event.gui = new GuiCustomMainMenu();
		}
	}
}