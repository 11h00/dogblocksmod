
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@DogblockmodModElements.ModElement.Tag
public class IphoneItem extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:iphone")
	public static final Item block = null;

	public IphoneItem(DogblockmodModElements instance) {
		super(instance, 1384);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("iphone");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
