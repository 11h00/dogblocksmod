package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Disabledguarddog2PlayerCollidesWithThisEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Disabledguarddog2PlayerCollidesWithThisEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((entity.getDisplayName().getString()).equals("mathias777")) {
			if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false) == false) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.HEART, x, y, z, (int) 10, 2, 2, 2, 1);
				}
				if ((entity instanceof TameableEntity) && (sourceentity instanceof PlayerEntity)) {
					((TameableEntity) entity).setTamed(true);
					((TameableEntity) entity).setTamedBy((PlayerEntity) sourceentity);
				}
			}
		} else if ((entity.getDisplayName().getString()).equals("Dev")) {
			if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false) == false) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.HEART, x, y, z, (int) 10, 2, 2, 2, 1);
				}
				if ((entity instanceof TameableEntity) && (sourceentity instanceof PlayerEntity)) {
					((TameableEntity) entity).setTamed(true);
					((TameableEntity) entity).setTamedBy((PlayerEntity) sourceentity);
				}
			}
		}
	}
}
