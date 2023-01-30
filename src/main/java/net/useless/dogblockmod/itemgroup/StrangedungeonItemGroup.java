
package net.useless.dogblockmod.itemgroup;

import net.useless.dogblockmod.item.RedkeyItem;
import net.useless.dogblockmod.DogblockmodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@DogblockmodModElements.ModElement.Tag
public class StrangedungeonItemGroup extends DogblockmodModElements.ModElement {
	public StrangedungeonItemGroup(DogblockmodModElements instance) {
		super(instance, 878);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabstrangedungeon") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RedkeyItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
