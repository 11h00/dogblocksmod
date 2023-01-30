package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.Map;

public class BlockdestroyerBlockAddedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure BlockdestroyerBlockAdded!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure BlockdestroyerBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure BlockdestroyerBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure BlockdestroyerBlockAdded!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency itemstack for procedure BlockdestroyerBlockAdded!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (-3);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)), (World) world, new BlockPos(x, y, z));
				world.destroyBlock(new BlockPos(x + sx, y + sy, z + sz), false);
			}
			sy = (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + sx, y + sy, z + sz), false);
				}
				sz = (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if (world instanceof World) {
						Block.spawnDrops(world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)), (World) world, new BlockPos(x, y, z));
						world.destroyBlock(new BlockPos(x + sx, y + sy, z + sz), false);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		world.destroyBlock(new BlockPos(x, y, z), false);
		{
			ItemStack _ist = itemstack;
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
