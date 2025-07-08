package org.queercraft.powerlessLampsRelit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.queercraft.powerlessLampsRelit.functionality.WorldEditManager;

import java.util.Objects;
import java.util.logging.Logger;

public class LampCommand extends SafeCommandExecutor {
    private final JavaPlugin plugin;
    private final BukkitScheduler scheduler;

    public LampCommand(JavaPlugin plugin, BukkitScheduler scheduler, Logger logger) {
        super(logger);
        this.plugin = plugin;
        this.scheduler = scheduler;
    }

    protected boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        scheduler.runTask(plugin, () -> command(sender, args));
        return true;
    }

    public void command(CommandSender sender, String[] args) {
        String arg = args.length > 0 ? args[0].toLowerCase() : "";

        switch (arg) {
            case "":
                sender.sendMessage("Usage: /lamp <command>");
                break;
            case "reload":
                handleReloadCommand(sender);
                break;
            case "toggle":
                handleStateChangeCommand(sender, "toggle");
                break;
            case "on":
                handleStateChangeCommand(sender, "on");
                break;
            case "off":
                handleStateChangeCommand(sender, "off");
                break;
            default:
                break;
        }
    }

    public void handleReloadCommand(CommandSender sender){
        if (sender.hasPermission("lamp.reload")) {
            plugin.reloadConfig();
            sender.sendMessage("The config has been reloaded.");
        } else {
            sender.sendMessage("You do not have permission to use this command.");
        }
    }

    public void handleStateChangeCommand(CommandSender sender, String param) {
        if (sender.hasPermission("lamp.worldedit") && Objects.equals(plugin.getConfig().getString("uses-permissions"), "true")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can run this command.");
                return;
            }
            Player player = (Player) sender;
            WorldEditManager.onSelection(player, param);
        }else {
            sender.sendMessage("You do not have permission to use this command.");
        }
    }
}
