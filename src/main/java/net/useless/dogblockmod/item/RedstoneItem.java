
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.itemgroup.StrangedungeonItemGroup;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@DogblockmodModElements.ModElement.Tag
public class RedstoneItem extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:redstone")
	public static final Item block = null;

	public RedstoneItem(DogblockmodModElements instance) {
		super(instance, 1224);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(StrangedungeonItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("redstone");
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
