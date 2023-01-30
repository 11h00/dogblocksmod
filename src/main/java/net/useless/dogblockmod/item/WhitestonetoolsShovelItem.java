
package net.useless.dogblockmod.item;

import net.useless.dogblockmod.block.WhitestoneBlock;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@DogblockmodModElements.ModElement.Tag
public class WhitestonetoolsShovelItem extends DogblockmodModElements.ModElement {
	@ObjectHolder("dogblockmod:whitestonetools_shovel")
	public static final Item block = null;

	public WhitestonetoolsShovelItem(DogblockmodModElements instance) {
		super(instance, 205);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("whitestonetools_shovel"));
	}
}
