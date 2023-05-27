
package net.useless.dogblockmod.itemgroup;

import net.useless.dogblockmod.block.Unknown4Block;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@DogblockmodModElements.ModElement.Tag
public class DungeonportalItemGroup extends DogblockmodModElements.ModElement {
	public DungeonportalItemGroup(DogblockmodModElements instance) {
		super(instance, 1275);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdungeonportal") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Unknown4Block.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
