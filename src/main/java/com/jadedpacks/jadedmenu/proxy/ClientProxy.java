package com.jadedpacks.jadedmenu.proxy;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jadedpacks.jadedmenu.JadedMenu;
import com.jadedpacks.jadedmenu.gui.GuiCustomMainMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import java.io.InputStreamReader;
import java.net.URL;

public class ClientProxy extends CommonProxy {
	public static GuiCustomMainMenu menu;

	public void preInit() {
		menu = new GuiCustomMainMenu();
		MinecraftForge.EVENT_BUS.register(this);
		try {
			ServerList list = new ServerList(Minecraft.getMinecraft());
			String url = "https://raw.githubusercontent.com/JadedPacks/" + JadedMenu.config.get("general", "issues", "").getString() + "/master/config/jadedservers.json";
			final InputStreamReader reader = new InputStreamReader(new URL(url).openStream());
			final JsonElement root = new JsonParser().parse(reader);
			if(root.isJsonArray()) {
				for(final JsonElement node : root.getAsJsonArray()) {
					final JsonObject obj = node.getAsJsonObject();
					boolean found = false;
					for(int i = 0; i < list.countServers(); i++) {
						ServerData data = list.getServerData(i);
						if(data.serverName.equals(obj.get("name").getAsString()) && data.serverIP.equals(obj.get("ip").getAsString())) {
							found = true;
							break;
						}
					}
					if(!found) {
						list.addServerData(new ServerData(obj.get("name").getAsString(), obj.get("ip").getAsString()));
					}
				}
				list.saveServerList();
			}
		} catch(Exception ignored) {}
	}

	@ForgeSubscribe
	public void onOpenGui(final GuiOpenEvent event) {
		if(event.gui instanceof GuiMainMenu) {
			event.gui = menu;
		}
	}
}