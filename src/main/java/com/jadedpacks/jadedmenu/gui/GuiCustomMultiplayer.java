package com.jadedpacks.jadedmenu.gui;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jadedpacks.jadedmenu.JadedMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;

import java.io.InputStreamReader;
import java.net.URL;

public class GuiCustomMultiplayer extends GuiMultiplayer {
	public GuiCustomMultiplayer(GuiScreen parent) {
		super(parent);
		try {
			String url = "https://raw.githubusercontent.com/JadedPacks/" + JadedMenu.config.get("general", "issues", "").getString() + "/master/config/jadedservers.json";
			final InputStreamReader reader = new InputStreamReader(new URL(url).openStream());
			final JsonElement root = new JsonParser().parse(reader);
			if(root.isJsonArray()) {
				for(final JsonElement node : root.getAsJsonArray()) {
					final JsonObject obj = node.getAsJsonObject();
					savedServerList.addServerData(new ServerData(obj.get("name").getAsString(), obj.get("ip").getAsString()));
				}
			}
		} catch(Exception ignored){}
	}
}