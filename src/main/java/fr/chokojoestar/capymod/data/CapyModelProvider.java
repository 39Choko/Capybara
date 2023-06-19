package fr.chokojoestar.capymod.data;

import fr.chokojoestar.capymod.Register;
import fr.chokojoestar.capymod.item.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CapyModelProvider extends FabricModelProvider {

   public CapyModelProvider(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator BSModelGen) {
      Register.registerSpawnEggData(BSModelGen, CapyItems.DEV_MOB_SPAWN_EGG);
      Register.registerSpawnEggData(BSModelGen, CapyItems.CAPYBARA_SPAWN_EGG);
   }

   @Override
   public void generateItemModels(ItemModelGenerator IModelGen) {
      Register.registerItemData(IModelGen, CapyItems.DEV_ITEM, Models.GENERATED);
   }

}
