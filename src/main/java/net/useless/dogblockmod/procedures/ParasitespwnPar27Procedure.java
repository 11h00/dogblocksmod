package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.entity.Par277Entity;
import net.useless.dogblockmod.entity.Par276Entity;
import net.useless.dogblockmod.entity.Par275Entity;
import net.useless.dogblockmod.entity.Par274Entity;
import net.useless.dogblockmod.entity.Par273Entity;
import net.useless.dogblockmod.entity.Par272Entity;
import net.useless.dogblockmod.entity.Par271Entity;
import net.useless.dogblockmod.DogblockmodMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class ParasitespwnPar27Procedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure ParasitespwnPar27Procedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure ParasitespwnPar27Procedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure ParasitespwnPar27Procedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure ParasitespwnPar27Procedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double cx = 0;
		double cy = 0;
		double cz = 0;
		double sel = 0;
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos(x, y, z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		for (int index0 = 0; index0 < (int) (MathHelper.nextInt(new Random(), 6, 30)); index0++) {
			sel = (MathHelper.nextInt(new Random(), 0, 6));
			cx = (MathHelper.nextInt(new Random(), 1, 0) == 0)
					? (x + (MathHelper.nextInt(new Random(), -2, 2)))
					: (x + (MathHelper.nextInt(new Random(), -2, 2)));
			cy = (MathHelper.nextInt(new Random(), 1, 0) == 0)
					? (y + (MathHelper.nextInt(new Random(), 0, 3)))
					: (y + (MathHelper.nextInt(new Random(), 0, 3)));
			cz = (MathHelper.nextInt(new Random(), 1, 0) == 0)
					? (z + (MathHelper.nextInt(new Random(), -2, 2)))
					: (z + (MathHelper.nextInt(new Random(), -2, 2)));
			if (sel == 0) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par271Entity.CustomEntity(Par271Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 1) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par272Entity.CustomEntity(Par272Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 2) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par273Entity.CustomEntity(Par273Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 3) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par274Entity.CustomEntity(Par274Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 4) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par275Entity.CustomEntity(Par275Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 5) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par276Entity.CustomEntity(Par276Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else if (sel == 6) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Par277Entity.CustomEntity(Par277Entity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(cx, cy, cz, (float) (MathHelper.nextInt(new Random(), -60, 120)),
							(float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -60, 120)));
					entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -60, 120)));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
