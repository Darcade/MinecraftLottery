package de.darcade.minecraftlottery;

import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PlayerMessageReplacer {
	private FileConfiguration config;

	public PlayerMessageReplacer(Main main) {
		this.config = main.getConfig();
	}

	public void printHelp(Player p) {
		String min = String.valueOf(config.getInt("min")), max = String
				.valueOf(config.getInt("max"));

		String message = config.getString("Message.help")
				.replaceAll("%MINIMUM%", min).replaceAll("%MAXIMUM%", max);
		p.sendMessage(message);
	}

	public void printExample(Player p) {
		int max = config.getInt("max"), min = config.getInt("min");
		int one = new Random().nextInt(max - min) + min, 
				two = new Random().nextInt(max - min) + min, 
				three = new Random().nextInt(max - min)+ min, 
				four = new Random().nextInt(max - min) + min;

		while (one == two || one == three || one == four || two == three
				|| two == four || three == four) {
			if (one == two || one == three || one == four)
				one = new Random().nextInt(max - min) + min;

			if (two == three || two == four)
				two = new Random().nextInt(max - min) + min;

			if (three == four)
				four = new Random().nextInt(max - min) + min;
		}
		String commandexample = "/lottery " + String.valueOf(one) + " "
				+ String.valueOf(two) + " " + String.valueOf(three) + " "
				+ String.valueOf(four);
		String message = config.getString("Message.example").replaceAll(
				"%COMMANDEXAMPLE%", commandexample);

		p.sendMessage(message);
	}
}