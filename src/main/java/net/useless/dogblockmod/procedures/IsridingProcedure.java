package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class IsridingProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Isriding!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isPassenger()) {
			return true;
		}
		return false;
	}
}
