package fr.chokojoestar.capymod.world.gen;

import fr.chokojoestar.capymod.entity.CapyEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.SpawnRestriction.Location;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.biome.BiomeKeys;

public class CapyEntityGen {
   public static void addSpawn() {
      BiomeModifications.addSpawn(
         BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.SPARSE_JUNGLE),
         SpawnGroup.CREATURE, 
         CapyEntities.CAPYBARA, 
         50, 
         3, 
         6
      );

      SpawnRestriction.register(
         CapyEntities.CAPYBARA, 
         Location.ON_GROUND, 
         Type.MOTION_BLOCKING_NO_LEAVES, 
         AnimalEntity::isValidNaturalSpawn
      );
   }
}
