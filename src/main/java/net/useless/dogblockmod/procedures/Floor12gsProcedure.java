package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

public class Floor12gsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure Floor12gs!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Floor12gs!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("dogblockmod", "floor12"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos(95, 95, 95),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(97, 96, 97);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(97, 96, 97, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 4);
	}
}
