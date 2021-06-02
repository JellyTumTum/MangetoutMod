package com.jellytumtum.mangetoutmod.registry;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.Heightmap;

public class MangetoutStalkSpawnFeature extends Feature<DefaultFeatureConfig> {
    public MangetoutStalkSpawnFeature(Codec<DefaultFeatureConfig> config) {
      super(config);
    }
   
    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos,
        DefaultFeatureConfig config) {
      BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
   
      for (int x = 0; x <= 5; x++) {
        int randomChance = random.nextInt() % 4; // decides cardinal direction.
        switch (randomChance) {
          case 0:
            world.setBlockState(topPos.north(random.nextInt() % 3), ModBlocks.MANGETOUT_STALK.getDefaultState(), 3);
          case 1:
            world.setBlockState(topPos.east(random.nextInt() % 3), ModBlocks.MANGETOUT_STALK.getDefaultState(), 3);
          case 2:
            world.setBlockState(topPos.south(random.nextInt() % 3), ModBlocks.MANGETOUT_STALK.getDefaultState(), 3);
          case 3:
            world.setBlockState(topPos.west(random.nextInt() % 3), ModBlocks.MANGETOUT_STALK.getDefaultState(), 3);
        }
      }
   
      return true;
    }
  }