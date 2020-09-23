package com.vikingkaare.firstmod.objects.fluids;

import com.vikingkaare.firstmod.events.RegistryEvents;
import com.vikingkaare.firstmod.lists.BlockList;
import com.vikingkaare.firstmod.lists.FluidList;
import com.vikingkaare.firstmod.lists.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

import java.rmi.registry.Registry;

public abstract class FluidOil extends FlowingFluid {
    @Override
    public Fluid getFlowingFluid() {
        return FluidList.flowing_oil;
    }

    @Override
    public Fluid getStillFluid() {
        return FluidList.oil;
    }

    @Override
    protected boolean canSourcesMultiply() {
        return true;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return 4;
    }

    @Override
    public Item getFilledBucket() {
        return ItemList.oil_bucket;
    }

    @Override
    protected boolean canDisplace(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidList.Tags.OIL);
    }

    @Override
    public int getTickRate(IWorldReader p_205569_1_) {
        return 100;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0f;
    }

    @Override
    protected BlockState getBlockState(IFluidState state) {
        return BlockList.oil.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn == FluidList.oil || fluidIn == FluidList.flowing_oil;
    }

    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(RegistryEvents.location("blocks/oil_still"), RegistryEvents.location("blocks/oil_flow"))
                .translationKey("block.firstmod.oil")
                .build(this);
    }

    public static class Flowing extends FluidOil {

        @Override
        protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
            public boolean isSource(IFluidState state) {
                return false;
            }
            @Override
                public int getLevel(IFluidState state) {
                    return state.get(FluidOil.LEVEL_1_8);
                }

            }

    public static class Source extends FluidOil {
            @Override
            public boolean isSource(IFluidState state) {
                return true;
            }
            @Override
            public int getLevel(IFluidState state) {
                return 8;
        }
    }
 }
