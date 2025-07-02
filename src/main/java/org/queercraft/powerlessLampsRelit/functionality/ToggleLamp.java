package org.queercraft.powerlessLampsRelit.functionality;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ToggleLamp {
    public static void toggle (Block block) {
        // Convert Bukkit world and block to Mojang-mapped equivalents
        ServerLevel nmsWorld = ((CraftWorld) block.getWorld()).getHandle();
        BlockPos pos = ((CraftBlock) block).getPosition();
        BlockState currentState = nmsWorld.getBlockState(pos);

        // Check if block is lightable
        if (currentState.hasProperty(BlockStateProperties.LIT)) {
            boolean lit = currentState.getValue(BlockStateProperties.LIT);
            BlockState newState = currentState.setValue(BlockStateProperties.LIT, !lit);

            // Don't notify neighbors
            nmsWorld.setBlock(pos, newState, 2);
        }
    }
}
