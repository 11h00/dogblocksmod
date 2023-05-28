
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
public class Menu1Item extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:menu_1")
	public static final Item block = null;

	public Menu1Item(DogblockmodModElements instance) {
		super(instance, 1368);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(9).saturation(6f).setAlwaysEdible().build()));
			setRegistryName("menu_1");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 100;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
