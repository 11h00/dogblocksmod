package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.block.Exdog1reverseBlock;
import net.useless.dogblockmod.block.Exdog1Block;
import net.useless.dogblockmod.DogblockmodMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class Exdog1BlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure Exdog1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure Exdog1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure Exdog1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure Exdog1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency entity for procedure Exdog1BlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getDisplayName().getString()).equals("mathias777")) {
			if (Math.random() < 0.2) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.death")),
							SoundCategory.BLOCKS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.death")),
							SoundCategory.BLOCKS, (float) 1, (float) 1, false);
				}
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Blocks.AIR.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Exdog1reverseBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1Block.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 2);
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1reverseBlock.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 4);
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1Block.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 6);
			}
		} else {
			if (Math.random() < 0.6) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.death")),
							SoundCategory.BLOCKS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.death")),
							SoundCategory.BLOCKS, (float) 1, (float) 1, false);
				}
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Blocks.AIR.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Exdog1reverseBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1Block.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 2);
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1reverseBlock.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 4);
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
						{
							BlockPos _bp = new BlockPos(x, y, z);
							BlockState _bs = Exdog1Block.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 6);
			}
		}
	}
}
