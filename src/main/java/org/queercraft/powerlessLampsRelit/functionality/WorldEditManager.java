package org.queercraft.powerlessLampsRelit.functionality;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class WorldEditManager {
    public static void onSelection(Player player, String param) {
        BukkitPlayer wePlayer = BukkitAdapter.adapt(player);
        LocalSession session = WorldEdit.getInstance().getSessionManager().get(wePlayer);

        Region region;
        try {
            region = session.getSelection(wePlayer.getWorld());
        } catch (Exception e) {
            player.sendMessage("§cYou must make a WorldEdit selection first.");
            return;
        }

        org.bukkit.World bukkitWorld = BukkitAdapter.adapt(wePlayer.getWorld());

        for (BlockVector3 vec : region) {
            Location loc = new Location(bukkitWorld, vec.x(), vec.y(), vec.z());
            Block block = bukkitWorld.getBlockAt(loc);
            LampManager.action(block, param);
        }

        player.sendMessage("§aToggled all lamps in selection.");
    }
}
