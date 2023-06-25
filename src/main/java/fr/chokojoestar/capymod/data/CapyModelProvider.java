package fr.chokojoestar.capymod.data;

import fr.chokojoestar.capymod.item.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;

public class CapyModelProvider extends FabricModelProvider {

   public CapyModelProvider(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator BSModelGen) {
      BSModelGen.registerParentedItemModel(CapyItems.CAPYBARA_SPAWN_EGG,
            ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
   }

   @Override
   public void generateItemModels(ItemModelGenerator IModelGen) {
   }

}
