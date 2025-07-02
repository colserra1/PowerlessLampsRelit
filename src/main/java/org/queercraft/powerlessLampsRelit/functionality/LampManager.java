package org.queercraft.powerlessLampsRelit.functionality;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class LampManager {
    public static void action (Block block, String param) {
        // Convert Bukkit world and block to Mojang-mapped equivalents
        ServerLevel nmsWorld = ((CraftWorld) block.getWorld()).getHandle();
        BlockPos pos = ((CraftBlock) block).getPosition();
        BlockState currentState = nmsWorld.getBlockState(pos);

        // Check if block is lightable and set new state without notifying neighbors
        if (currentState.hasProperty(BlockStateProperties.LIT)) {
            BlockState newState;
            switch (param) {
                case "toggle":
                    boolean lit = currentState.getValue(BlockStateProperties.LIT);
                    newState = currentState.setValue(BlockStateProperties.LIT, !lit);
                    nmsWorld.setBlock(pos, newState, 2);
                    break;
                case "on":
                    newState = currentState.setValue(BlockStateProperties.LIT, true);
                    nmsWorld.setBlock(pos, newState, 2);
                    break;
                case "off":
                    newState = currentState.setValue(BlockStateProperties.LIT, false);
                    nmsWorld.setBlock(pos, newState, 2);
                    break;
            }
        }
    }
}
