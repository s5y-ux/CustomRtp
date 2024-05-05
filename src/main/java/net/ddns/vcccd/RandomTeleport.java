package net.ddns.vcccd;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Random;

public class RandomTeleport implements CommandExecutor {
	
	private static Main main;
	private HashMap<String, Sound> soundMap = new HashMap<String,Sound>();
	
	private void constructSoundmap(HashMap<String, Sound> soundMap) {
		String[] soundStrings = {"enderman", "levelup", "explode", "anvil"};
		Sound[] sounds = {Sound.ENTITY_ENDERMAN_TELEPORT, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_GENERIC_EXPLODE, Sound.BLOCK_ANVIL_LAND};
		
		for (int i = 0; i < sounds.length; i++) {
			soundMap.put(soundStrings[i], sounds[i]);
		}
	}
	
	public RandomTeleport(Main main) {
		this.main = main;
	}
	
	private Location randomCoordinate(World world, Location playerLocal) {
		int localStandard = this.main.getConfig().getInt("Distance");
		Random number = new Random();
		
		double RandomX = number.nextInt(localStandard);
		double RandomY = number.nextInt(localStandard);
		
		if(new Random().nextInt(2) == 1) {
			RandomX = RandomX - (2 * RandomX); 
		}
		
		if(new Random().nextInt(2) == 1) {
			RandomY = RandomY - (2 * RandomY);
		}
		
		double[] coords = {playerLocal.getX(), playerLocal.getY(), playerLocal.getZ()};
		int X = (int) (coords[0] + RandomX);
		int Y = (int) (coords[0] + RandomY);
		Location newLocal = new Location(world, X, world.getHighestBlockYAt(X, Y) + 2, Y);
		return(newLocal);
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			FileConfiguration config = this.main.getConfig();
			
			constructSoundmap(this.soundMap);
			
			Player player = (Player) arg0;
			Location playerLocal = player.getLocation();
			
			player.teleport(randomCoordinate(player.getWorld(), playerLocal));
			
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("CustomMessage")));
			player.playSound(player, this.soundMap.get(config.getString("SoundEffect")), 100, 1);
			
		} else {
			arg0.sendMessage(ChatColor.RED + "Only players can execute this command...");
		}
		return true;
	}

}
