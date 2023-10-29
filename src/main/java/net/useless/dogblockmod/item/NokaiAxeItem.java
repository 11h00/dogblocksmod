
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@DogblockmodModElements.ModElement.Tag
public class NokaiAxeItem extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:nokai_axe")
	public static final Item block = null;

	public NokaiAxeItem(DogblockmodModElements instance) {
		super(instance, 1504);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 120;
			}

			public float getEfficiency() {
				return 19f;
			}

			public float getAttackDamage() {
				return 57f;
			}

			public int getHarvestLevel() {
				return 13;
			}

			public int getEnchantability() {
				return 92;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NokaiIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("nokai_axe"));
	}
}
