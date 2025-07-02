package org.queercraft.powerlessLampsRelit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.queercraft.powerlessLampsRelit.PowerlessLampsRelit;
import org.queercraft.powerlessLampsRelit.functionality.ToggleLamp;

import java.util.Objects;

public class RightClickListener implements Listener {
    private final boolean usesPermissions;
    PowerlessLampsRelit plugin;

    public RightClickListener(PowerlessLampsRelit plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
        usesPermissions = Objects.equals(plugin.getConfig().getString("uses-permissions"), "true");
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        boolean isBlock = event.getAction().equals(Action.RIGHT_CLICK_BLOCK);


        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        if (!isBlock || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            return;
        }
        if (event.getClickedBlock() == null) {
            return;
        }
        if (!p.hasPermission("lamp.toggle") && usesPermissions) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            return;
        }
        if (    event.getClickedBlock().getBlockData().getMaterial() != Material.REDSTONE_LAMP &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.EXPOSED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.OXIDIZED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.WEATHERED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.WAXED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.WAXED_EXPOSED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.WAXED_OXIDIZED_COPPER_BULB &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.WAXED_WEATHERED_COPPER_BULB) {
            return;
        }

        ToggleLamp.toggle(event.getClickedBlock());

    }
}