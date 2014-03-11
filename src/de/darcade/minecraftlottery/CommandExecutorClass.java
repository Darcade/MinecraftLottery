package de.darcade.minecraftlottery;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandExecutorClass implements CommandExecutor {

	private PlayerMessageReplacer replacer;
	private FileConfiguration config;
	
	public CommandExecutorClass(Main main) {
		//this.main = main;
		this.config = main.getConfig();
		replacer = new PlayerMessageReplacer(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandlabel, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("lottery")) {
			if (args.length != 4) {
				this.printHelp(p);
			} else if (args.length == 4) {
				if (this.isInt(args)) {
					if (!this.checknumbers(this.StringtoIntarray(args))) {
						if(!this.checknmumberrange(this.StringtoIntarray(args))){
							p.sendMessage("Your numbers are: " + args[0] + " "
									+ args[1] + " " + args[2] + " " + args[3]);
						} else {
							replacer.printErrorthree(p);
						}
						
						
					} else {
						replacer.printErrorone(p);
						replacer.printExample(p);
					}
				} else {
					replacer.printErrortwo(p);
				}
			}

			// p.sendMessage(String.valueOf(args.length));
			return true;
		}
		return true;
	}

	private boolean isInt(String[] args){
		try {
			for (int i = 0; i <= args.length - 1; i++) {
				Integer.parseInt(args[i]);
			}
		} catch (NumberFormatException e) {
			return false;
		}
	    return true;
	}
	
	private int[] StringtoIntarray(String[] args){
		int numbers[] = new int[args.length];
		for (int i = 0; i <= args.length-1; i++) {
			numbers[i] = Integer.parseInt(args[i]);
		}
		
		return numbers;
	}
	
	//returns wether one of those numbers is too large
	private boolean checknmumberrange(int[] args){
		int min = config.getInt("min"), max = config.getInt("max");
		for(int i = 0; i <= args.length - 1; i++)
		if (args[i] < min || args[i] > max) {
			return true;
		} 
			return false;
		
	}
	
	//Checks wether a number is used more then once
	private boolean checknumbers(int[] args) {
		if (args[0] == args[1] || args[0] == args[2] || args[0] == args[3]
				|| args[1] == args[2] || args[1] == args[3]
				|| args[2] == args[3]) {
			return true;
		} else {
			return false;
		}
	}
	
	private void printHelp(Player p){
		replacer.printHelp(p);
		replacer.printExample(p);
		
	}
}
