package com.jadedpacks.jadedmenu;

import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import com.jadedpacks.jadedmenu.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

@Mod(modid = "jadedmenu", name = "JadedMenu", version = "@VERSION@")
public class JadedMenu {
	@SidedProxy(clientSide = "com.jadedpacks.jadedmenu.proxy.ClientProxy", serverSide = "com.jadedpacks.jadedmenu.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static boolean isExtra = false;
	public static Configuration config;

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
	}
}