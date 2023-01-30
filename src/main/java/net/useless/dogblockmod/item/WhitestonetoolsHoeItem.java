
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.block.WhitestoneBlock;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@DogblockmodModElements.ModElement.Tag
public class WhitestonetoolsHoeItem extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:whitestonetools_hoe")
	public static final Item block = null;

	public WhitestonetoolsHoeItem(DogblockmodModElements instance) {
		super(instance, 206);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(WhitestoneBlock.block));
			}
		}, 0, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("whitestonetools_hoe"));
	}
}
