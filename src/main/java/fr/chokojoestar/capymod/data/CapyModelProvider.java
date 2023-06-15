package fr.chokojoestar.capymod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class CapyModelProvider extends FabricModelProvider {

   public CapyModelProvider(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator BSModelGenerator) {
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
   }
   


}
