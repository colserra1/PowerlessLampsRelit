package org.queercraft.powerlessLampsRelit;

import org.bukkit.plugin.java.JavaPlugin;
import org.queercraft.powerlessLampsRelit.listeners.RightClickListener;

import java.util.Arrays;
import java.util.logging.Level;

public final class PowerlessLampsRelit extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            this.saveDefaultConfig();
            registerListeners();
            getLogger().log(Level.INFO, "PowerlessLampsRedux plugin enabled.");
        } catch (Exception e) {
            getLogger().severe("An unexpected error occurred while enabling PowerlessLampsRelit:");
            getLogger().severe("Exception type: " + e.getClass().getName());
            getLogger().severe("Message: " + e.getMessage());
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
        getLogger().log(Level.INFO, "PowerlessLampsRedux plugin disabled.");
    }
}
