
package net.mcreator.funmods.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.funmods.itemgroup.FunModsItemGroup;
import net.mcreator.funmods.item.ReddiamondItem;
import net.mcreator.funmods.FunModsModElements;

import java.util.List;
import java.util.Collections;

@FunModsModElements.ModElement.Tag
public class ReddiamondoreBlock extends FunModsModElements.ModElement {
	@ObjectHolder("fun_mods:reddiamondore")
	public static final Block block = null;
	public ReddiamondoreBlock(FunModsModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(FunModsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 10f).setLightLevel(s -> 0));
			setRegistryName("reddiamondore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(ReddiamondItem.block, (int) (1)));
		}
	}
}