package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Enwolf2formathiasbruhEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Enwolf2formathiasbruhEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null) instanceof PlayerEntity
				&& !((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).world.isRemote()) {
			((PlayerEntity) ((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null)).sendStatusMessage(
					new StringTextComponent(("mathias wolf hp: " + ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + "/"
							+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1))),
					(true));
		}
	}
}
