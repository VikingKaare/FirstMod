package com.vikingkaare.firstmod.events;

import com.vikingkaare.firstmod.Main;
import com.vikingkaare.firstmod.lists.BlockList;
import com.vikingkaare.firstmod.lists.FluidList;
import com.vikingkaare.firstmod.lists.ItemList;
import com.vikingkaare.firstmod.objects.fluids.FluidOil;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import java.rmi.registry.Registry;

@Mod.EventBusSubscriber(bus =Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
    public static final Logger LOGGER = Main.LOGGER;
    public static final String MOD_ID = Main.MOD_ID;

     @SubscribeEvent
     public static void registerItems(final RegistryEvent.Register<Item> event)
     {
         event.getRegistry().registerAll
                 (
                         // Items
                         ItemList.first_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_item")),
                         ItemList.second_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("second_item")),

                         // Basic blocks (slabs, stairs, walls etc.)
                         ItemList.first_block = new BlockItem(BlockList.first_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.first_block.getRegistryName()),
                         ItemList.second_block = new BlockItem(BlockList.second_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.second_block.getRegistryName()),
                         ItemList.first_slab = new BlockItem(BlockList.first_slab, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.first_slab.getRegistryName()),
                         ItemList.second_slab = new BlockItem(BlockList.second_slab, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.second_slab.getRegistryName()),
                         ItemList.first_stairs = new BlockItem(BlockList.first_stairs, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.first_stairs.getRegistryName()),
                         ItemList.second_stairs = new BlockItem(BlockList.second_stairs, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.second_stairs.getRegistryName()),
                         ItemList.first_wall = new BlockItem(BlockList.first_wall, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.first_wall.getRegistryName()),
                         ItemList.second_wall = new BlockItem(BlockList.second_wall, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.second_wall.getRegistryName()),

                         ItemList.oil_bucket = new BucketItem(() -> FluidList.oil, new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)).setRegistryName("oil_bucket"),

                         //Tools
                         ItemList.first_sword = new SwordItem(ItemList.ModItemTier.CUSTOM, 7, 5.0f, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_sword")),
                         ItemList.first_pickaxe = new PickaxeItem(ItemList.ModItemTier.CUSTOM, 5, 5.0f, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_pickaxe")),
                         ItemList.first_axe = new AxeItem(ItemList.ModItemTier.CUSTOM, 11, 4.0f, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_axe")),
                         ItemList.first_shovel = new ShovelItem(ItemList.ModItemTier.CUSTOM, 3, 5.0f, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_shovel")),
                         ItemList.first_hoe = new HoeItem(ItemList.ModItemTier.CUSTOM, 7, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("first_hoe"))

                 );
     }


    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll
                (
                        BlockList.first_block = new Block(Block.Properties.create(Material.ICE).harvestLevel(0).hardnessAndResistance(3.0f).lightValue(4).slipperiness(0.6f).sound(SoundType.SLIME)).setRegistryName(location("first_block")),
                        BlockList.second_block = new Block(Block.Properties.create(Material.EARTH).harvestLevel(0).hardnessAndResistance(3.0f).lightValue(6).slipperiness(0.6f).sound(SoundType.METAL)).setRegistryName(location("second_block")),

                        BlockList.first_slab = new SlabBlock(Block.Properties.from(BlockList.first_block)).setRegistryName(location("first_slab")),
                        BlockList.second_slab = new SlabBlock(Block.Properties.from(BlockList.second_block)).setRegistryName(location("second_slab")),

                        BlockList.first_stairs = new StairsBlock(() -> BlockList.first_block.getDefaultState(), Block.Properties.from(BlockList.first_block)).setRegistryName(location("first_stairs")),
                        BlockList.second_stairs = new StairsBlock(() -> BlockList.second_block.getDefaultState(), Block.Properties.from(BlockList.second_block)).setRegistryName(location("second_stairs")),

                        BlockList.first_wall = new WallBlock(Block.Properties.from(BlockList.first_block)).setRegistryName(location("first_wall")),
                        BlockList.second_wall = new WallBlock(Block.Properties.from(BlockList.second_block)).setRegistryName(location("second_wall")),

                        BlockList.oil = new FlowingFluidBlock(() -> FluidList.oil, Block.Properties.create(Material.WATER).doesNotBlockMovement().noDrops()).setRegistryName(location("oil"))
                );
    }
    @SubscribeEvent
    public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
        event.getRegistry().registerAll
                (
                        FluidList.flowing_oil = (FluidOil.Flowing) new FluidOil.Flowing().setRegistryName(location("flowing_oil")),
                        FluidList.oil = (FluidOil.Source) new FluidOil.Source().setRegistryName(location("oil"))
                );

    }
    public static ResourceLocation location (String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }
}
