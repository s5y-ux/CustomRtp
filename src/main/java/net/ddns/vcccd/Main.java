package net.ddns.vcccd;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	FileConfiguration config = this.getConfig();
	
	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.GREEN + "Test Plugin Enabled");
		this.getCommand("rtp").setExecutor(new RandomTeleport(this));
		this.config.addDefault("Distance", 100);
		this.config.addDefault("SoundEffect", "enderman");
		this.config.addDefault("CustomMessage", "&6Teleporting...");
		this.saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "Test Plugin Disabled");
	}

}
