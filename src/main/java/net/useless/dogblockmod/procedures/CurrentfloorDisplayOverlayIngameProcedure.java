package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;

import java.util.Map;

public class CurrentfloorDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure CurrentfloorDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("dogblockmod:whitespace"))) == (entity.world.getDimensionKey())) {
			return true;
		} else if ((RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("dogblockmod:floor_1"))) == (entity.world
				.getDimensionKey())) {
			return true;
		}
		return false;
	}
}
