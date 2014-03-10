package de.darcade.minecraftlottery;

import java.io.File;

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
		this.getCommand("lottery").setExecutor(
				new CommandExecutorClass(this));
		this.checkDataDir();
		this.createConfig();
		
	}
	
	private void createConfig() {
		this.saveDefaultConfig();
		// System.out.println("[MinecraftLottery] Checking config...");
	}
	
	private void checkDataDir(){
		File plugindir = new File(this.getDataFolder().getAbsolutePath());

		if (!plugindir.exists()) {
			if (!plugindir.mkdirs())
				System.out
						.println("[MinecraftLottery] Could not create plugin directory");
		}
	}
}
