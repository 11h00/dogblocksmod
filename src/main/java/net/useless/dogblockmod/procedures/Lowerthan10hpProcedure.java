package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Lowerthan10hpProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Lowerthan10hp!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 10) {
			return false;
		}
		return true;
	}
}
