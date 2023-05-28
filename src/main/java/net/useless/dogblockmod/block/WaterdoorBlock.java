
package net.useless.dogblockmod.block;

import net.useless.dogblockmod.itemgroup.StrangedungeonItemGroup;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@DogblockmodModElements.ModElement.Tag
public class WaterdoorBlock extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:waterdoor")
	public static final Block block = null;

	public WaterdoorBlock(DogblockmodModElements instance) {
		super(instance, 1349);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(StrangedungeonItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends DoorBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK)
					.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("ambient.underwater.enter")),
							() -> new SoundEvent(new ResourceLocation("block.water.ambient")),
							() -> new SoundEvent(new ResourceLocation("ambient.underwater.enter")),
							() -> new SoundEvent(new ResourceLocation("block.water.ambient")),
							() -> new SoundEvent(new ResourceLocation("ambient.underwater.exit"))))
					.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 15));
			setRegistryName("waterdoor");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			if (state.get(BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER)
				return Collections.emptyList();
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
