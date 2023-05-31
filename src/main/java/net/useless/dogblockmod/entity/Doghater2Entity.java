
package net.useless.dogblockmod.entity;

import net.useless.dogblockmod.entity.renderer.Doghater2Renderer;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.Blocks;

@DogblockmodModElements.ModElement.Tag
public class Doghater2Entity extends DogblockmodModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("doghater_2").setRegistryName("doghater_2");
	public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
			.size(0.5f, 0.5f)).build("projectile_doghater_2").setRegistryName("projectile_doghater_2");

	public Doghater2Entity(DogblockmodModElements instance) {
		super(instance, 1404);
		FMLJavaModLoadingContext.get().getModEventBus().register(new Doghater2Renderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.entities.add(() -> arrow);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("doghater_2_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 5);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 35);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 13);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("phax31"));
			setCustomNameVisible(true);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
				@Override
				protected double getAttackReachSqr(LivingEntity entity) {
					return (double) (4.0 + entity.getWidth() * entity.getWidth());
				}
			});
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Bigdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Friendlycorrupteddog18Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Friendlycorrupteddog17Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, AbandonedlabbossdogfriendEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Endog35friendlyEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Endog36friendlyEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Friendlycorrupteddog7Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Corrupteddog15Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, Bossdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, Bossdog2Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, Bossdog2childEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, Bossdog3Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, Finalbossdog11lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Finalbossdog10lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Finalbossdog9lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, Finalbossdog8lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, Finalbossdog7lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Finalbossdog6lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Finalbossdog5lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Finalbossdog4lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Finalbossdog3lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Finalbossdog2lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Finalbossdog1lifeEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, FinalbossdogEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Dog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Verybigdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, FinalbossdogEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, Veryverybigdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, Engiantdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Giantdog1Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, Giantdog6Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, Verybigdog6Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, Veryverybigdog6Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, Bigdog6Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, Endog6Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, Dog6tinyEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, Afraidendog26Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(39, new NearestAttackableTargetGoal(this, AbandonedlabbossdogEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(40, new NearestAttackableTargetGoal(this, AbandonedlabbossdogfriendEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(41, new NearestAttackableTargetGoal(this, Endog10type5Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(42, new NearestAttackableTargetGoal(this, Endog10type4Entity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(43, new NearestAttackableTargetGoal(this, Endog10type3Entity.CustomEntity.class, false, true));
			this.goalSelector.addGoal(44, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(45, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(46, new SwimGoal(this));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.IRON_INGOT));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, this, this.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - this.getPosX();
			double d3 = target.getPosZ() - this.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			world.addEntity(entityarrow);
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	private static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void arrowHit(LivingEntity livingEntity) {
			super.arrowHit(livingEntity);
			livingEntity.setArrowCountInEntity(livingEntity.getArrowCountInEntity() - 1);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(Blocks.STONE);
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(Blocks.STONE);
		}
	}
}
