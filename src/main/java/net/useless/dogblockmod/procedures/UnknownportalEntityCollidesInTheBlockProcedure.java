package net.useless.dogblockmod.procedures;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class UnknownportalEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency world for procedure UnknownportalEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency x for procedure UnknownportalEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency y for procedure UnknownportalEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DogblockmodMod.LOGGER.warn("Failed to load dependency z for procedure UnknownportalEntityCollidesInTheBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double randomseedid = 0;
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
			randomseedid = (MathHelper.nextInt(new Random(), 1, 14));
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						{
							Entity _ent = entityiterator;
							_ent.setPositionAndUpdate(x, y, z);
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
						if ((entityiterator.world.getDimensionKey()) == (World.OVERWORLD)) {
							if (entityiterator.isNonBoss()) {
								if (randomseedid == 1) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floorz_3"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 2) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:flooraa"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 3) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floora_1"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 4) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floora_2"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 5) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floora_2alt"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 6) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floorr_1"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 7) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:dogtrap"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 8) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floorpc"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 9) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floorra"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 10) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:dogtrap_2"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 11) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:brownspace"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 12) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:purplezone"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 13) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:bluezone"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (randomseedid == 14) {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("dogblockmod:floor_01dim"));
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								}
							}
						} else {
							if (entityiterator.isNonBoss()) {
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = World.OVERWORLD;
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						}
					}
				}
			}
			world.destroyBlock(new BlockPos(x, y, z), false);
		}
	}
}
