
package net.useless.dogblockmod.block;

import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

@DogblockmodModElements.ModElement.Tag
public class Fidk1Block extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:fidk_1")
	public static final Block block = null;

	public Fidk1Block(DogblockmodModElements instance) {
		super(instance, 1420);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FallingBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK)
					.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("entity.shulker.death")),
							() -> new SoundEvent(new ResourceLocation("entity.shulker.hurt_closed")), () -> new SoundEvent(new ResourceLocation("")),
							() -> new SoundEvent(new ResourceLocation("entity.shulker.hurt")),
							() -> new SoundEvent(new ResourceLocation("entity.player.big_fall"))))
					.hardnessAndResistance(4f, 25f).setLightLevel(s -> 0).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("fidk_1");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}
	}
}
