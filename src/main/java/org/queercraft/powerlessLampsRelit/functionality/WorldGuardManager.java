package org.queercraft.powerlessLampsRelit.functionality;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.queercraft.powerlessLampsRelit.PowerlessLampsRelit;

public class WorldGuardManager {
    public static boolean isLampAllowed(Player player, Location loc) {
        if (loc.getWorld() == null) return false;

        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(BukkitAdapter.adapt(loc.getWorld()));
        if (regions == null) return false;

        if (player.hasPermission("powerlesslampsrelit.bypass")) {
            return true;
        }

        BlockVector3 blockVec = BlockVector3.at(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        ApplicableRegionSet regionSet = regions.getApplicableRegions(blockVec);

        return regionSet.testState(null, PowerlessLampsRelit.LAMP_FLAG); // `null` means no specific player context
    }

}
