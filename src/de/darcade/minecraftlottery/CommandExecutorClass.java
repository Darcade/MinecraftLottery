package de.darcade.minecraftlottery;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandExecutorClass implements CommandExecutor {

	private Main main;
	private FileConfiguration config;
	private PlayerMessageReplacer replacer;
	
	public CommandExecutorClass(Main main) {
		this.main = main;
		this.config = main.getConfig();
		replacer = new PlayerMessageReplacer(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,
			String[] args) {
		Player p =  (Player) sender;
		if(cmd.getName().equalsIgnoreCase("lottery")){
			if(args.length == 0) {
				this.printHelp(p);
			}
			
			//p.sendMessage(String.valueOf(args.length));
			return true;
		}
		return false;
	}

	private void printHelp(Player p){
		replacer.printHelp(p);
		replacer.printExample(p);
		
	}
}
