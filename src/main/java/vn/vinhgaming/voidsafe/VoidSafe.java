package vn.vinhgaming.voidsafe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidSafe extends JavaPlugin {
    private static VoidSafe instance;

    public static VoidSafe getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        ConfigManager.init();
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("voidsafe.admin")) return true;
        if (args.length >= 1 && args[0].equalsIgnoreCase("reload")) {
            reloadConfig();
            ConfigManager.init();
            sender.sendMessage(ChatColor.GREEN + "Configuration reloaded.");
            return true;
        }
        sender.sendMessage("Available command: /vsafe reload - reload config");
        return true;
    }
}
