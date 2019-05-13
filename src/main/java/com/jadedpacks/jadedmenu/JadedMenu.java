package com.jadedpacks.jadedmenu;

import com.jadedpacks.jadedmenu.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = "jadedmenu", name = "JadedMenu", version = "@VERSION@")
public class JadedMenu {
	@SidedProxy(clientSide = "com.jadedpacks.jadedmenu.proxy.ClientProxy", serverSide = "com.jadedpacks.jadedmenu.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static boolean isExtra = false;
	public static Configuration config;

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		proxy.preInit();
	}
}