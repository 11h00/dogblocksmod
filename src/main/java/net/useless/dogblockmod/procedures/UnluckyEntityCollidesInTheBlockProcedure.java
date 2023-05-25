package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

public class UnluckyEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure UnluckyEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure UnluckyEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure UnluckyEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure UnluckyEntityCollidesInTheBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double pouri = 0;
		pouri = (MathHelper.nextInt(new Random(), 1, 3));
		world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos(x, y, z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dogblockmod:unlucky")),
					SoundCategory.BLOCKS, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dogblockmod:unlucky")),
					SoundCategory.BLOCKS, (float) 1, (float) 1, false);
		}
		if (pouri == 1) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("dogblockmod", "trap1"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos(x - 3, y - 1, z - 1),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		} else if (pouri == 2) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("dogblockmod", "trap2"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos(x - 5, y - 1, z - 5),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		} else if (pouri == 3) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("dogblockmod", "trap3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos(x - 3, y - 1, z - 1),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
	}
}
