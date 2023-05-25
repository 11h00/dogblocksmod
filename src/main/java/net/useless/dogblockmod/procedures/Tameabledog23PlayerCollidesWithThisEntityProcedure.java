package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Tameabledog23PlayerCollidesWithThisEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Tameabledog23PlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Tameabledog23PlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((sourceentity instanceof TameableEntity) ? ((TameableEntity) sourceentity).isTamed() : false) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Im so afraid... please take me with you"), (false));
			}
			if ((sourceentity instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
				((TameableEntity) sourceentity).setTamed(true);
				((TameableEntity) sourceentity).setTamedBy((PlayerEntity) entity);
			}
		}
	}
}
