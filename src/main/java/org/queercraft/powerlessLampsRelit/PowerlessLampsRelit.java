package org.queercraft.powerlessLampsRelit;

import org.bukkit.plugin.java.JavaPlugin;
import org.queercraft.powerlessLampsRelit.listeners.RightClickListener;

import java.util.logging.Level;

public final class PowerlessLampsRelit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        registerListeners();
        getLogger().log(Level.INFO, "PowerlessLampsRedux plugin enabled.");
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
