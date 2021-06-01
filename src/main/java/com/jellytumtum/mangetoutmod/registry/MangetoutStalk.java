package com.jellytumtum.mangetoutmod.registry;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


// literally cut paste of SugarCaneBlock code. --> needs to be adjusted to not force placement on water.
public class MangetoutStalk extends Block {
   public static final IntProperty AGE;
   protected static final VoxelShape SHAPE;

   protected MangetoutStalk(AbstractBlock.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }

   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      if (!state.canPlaceAt(world, pos)) {
         world.breakBlock(pos, true);
      }

   }

   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      if (world.isAir(pos.up())) {
         int i;
         for(i = 1; world.getBlockState(pos.down(i)).isOf(this); ++i) {
         }

         if (i < 3) {
            int j = (Integer)state.get(AGE);
            if (j == 15) {
               world.setBlockState(pos.up(), this.getDefaultState());
               world.setBlockState(pos, (BlockState)state.with(AGE, 0), 4);
            } else {
               world.setBlockState(pos, (BlockState)state.with(AGE, j + 1), 4);
            }
         }
      }

   }

   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
      if (!state.canPlaceAt(world, pos)) {
         world.getBlockTickScheduler().schedule(pos, this, 1);
      }

      return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
   }

   public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
      BlockState blockState = world.getBlockState(pos.down());
      if (blockState.getBlock() == this) {
         return true;
      } else {
         if (blockState.isOf(Blocks.GRASS_BLOCK) || blockState.isOf(Blocks.DIRT) || blockState.isOf(Blocks.COARSE_DIRT) || blockState.isOf(Blocks.PODZOL) || blockState.isOf(Blocks.SAND) || blockState.isOf(Blocks.RED_SAND)) {
            Iterator var6 = Direction.Type.HORIZONTAL.iterator();

            while(var6.hasNext()) { // Says all blocks are valid. 
               return true;
            }
         }

         return false;
      }
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(AGE);
   }

   static {
      AGE = Properties.AGE_15;
      SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
   }
}

