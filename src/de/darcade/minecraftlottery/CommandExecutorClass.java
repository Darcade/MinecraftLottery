package de.darcade.minecraftlottery;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutorClass implements CommandExecutor {

	private PlayerMessageReplacer replacer;
	
	public CommandExecutorClass(Main main) {
		//this.main = main;
		//this.config = main.getConfig();
		replacer = new PlayerMessageReplacer(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,
			String[] args) {
		Player p =  (Player) sender;
		if(cmd.getName().equalsIgnoreCase("lottery")){
			if(args.length != 4) {
				this.printHelp(p);
			} else if (args.length == 4 && this.checknumbers(args)){
				replacer.printErrorone(p);
				replacer.printExample(p);
			} else if (args.length == 4) {
				p.sendMessage("Your numbers are: " + args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
			}
			
			//p.sendMessage(String.valueOf(args.length));
			return true;
		}
		return false;
	}

	//Checks wether a number is used more then once
	private boolean checknumbers(String[] args){
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
