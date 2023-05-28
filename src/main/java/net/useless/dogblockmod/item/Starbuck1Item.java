
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

@DogblockmodModElements.ModElement.Tag
public class Starbuck1Item extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:starbuck_1")
	public static final Item block = null;

	public Starbuck1Item(DogblockmodModElements instance) {
		super(instance, 1371);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.2f).setAlwaysEdible().build()));
			setRegistryName("starbuck_1");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 20;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
