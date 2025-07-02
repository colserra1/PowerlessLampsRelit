package org.queercraft.powerlessLampsRelit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.queercraft.powerlessLampsRelit.commands.LampCommand;
import org.queercraft.powerlessLampsRelit.listeners.RightClickListener;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class PowerlessLampsRelit extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger logger = getLogger();
        try {
            BukkitScheduler scheduler = Bukkit.getScheduler();
            this.saveDefaultConfig();
            registerListeners();
            logger.log(Level.INFO, "PowerlessLampsRelit plugin enabled.");
            Objects.requireNonNull(getCommand("lamps")).setExecutor(new LampCommand(this, scheduler, logger));
        } catch (Exception e) {
            logger.severe("An unexpected error occurred while enabling PowerlessLampsRelit:");
            logger.severe("Exception type: " + e.getClass().getName());
            logger.severe("Message: " + e.getMessage());
            Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).forEach(stackTraceLine -> getLogger().severe("    at " + stackTraceLine));
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void registerListeners() {
        new RightClickListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "PowerlessLampsRelit plugin disabled.");
    }
}
