package de.darcade.minecraftlottery;

import de.darcade.minecraftlottery.CommandExecutorClass;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onDisable() {
		System.out
				.println("[MinecraftLottery] MinecraftLottery plugin disabled!");
	}

	@Override
	public void onEnable() {
		getCommand("lottery").setExecutor(
				new CommandExecutorClass(this));
	}
}
