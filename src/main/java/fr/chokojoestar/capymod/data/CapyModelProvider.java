package fr.chokojoestar.capymod.data;

import fr.chokojoestar.capymod.items.CapyItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class CapyModelProvider extends FabricModelProvider {

   public CapyModelProvider(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
      itemModelGenerator.register(CapyItems.STAFF);
      itemModelGenerator.registerSpawnEgg(CapyItems.CAPYBARA_SPAWN_EGG, 0x44311E, 0x2A2117);
   }

}
