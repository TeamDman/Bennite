package ca.teamdman.bennite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bennite implements ModInitializer {
	public static final BenniteBlock BENNITE_BLOCK      = new BenniteBlock(
			FabricBlockSettings.of(Material.TNT)
					.breakByHand(true)
					.hardness(1)
					.build()
	);
	public static final String       MODID              = "bennite";
	public static final ItemGroup    BENNITE_GROUP      = FabricItemGroupBuilder.build(
			new Identifier(MODID, MODID),
			() -> new ItemStack(Bennite.BENNITE_BLOCK_ITEM));
	public static final BlockItem    BENNITE_BLOCK_ITEM = new BlockItem(BENNITE_BLOCK,new Item.Settings().group(BENNITE_GROUP));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(MODID, "bennite"), BENNITE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "bennite"), BENNITE_BLOCK_ITEM);
		FuelRegistry.INSTANCE.add(BENNITE_BLOCK_ITEM, FuelRegistry.INSTANCE.get(Items.LAVA_BUCKET)*20);
	}
}
