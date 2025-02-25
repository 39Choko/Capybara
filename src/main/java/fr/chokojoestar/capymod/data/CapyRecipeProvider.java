package fr.chokojoestar.capymod.data;

import java.util.concurrent.CompletableFuture;
import fr.chokojoestar.capymod.items.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class CapyRecipeProvider extends FabricRecipeProvider {

   public CapyRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   @Override
   public String getName() {
      return "CapyRecipeProvider";

   }

   @Override
   protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
      return new RecipeGenerator(registryLookup, exporter) {

         @Override
         public void generate() {
            createShaped(RecipeCategory.TOOLS, CapyItems.STAFF, 1)
               .pattern("S  ")
               .pattern(" I ")
               .pattern("  S")
               .input('S', Items.STICK).input('I', Items.IRON_NUGGET)
               .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
               .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
               .offerTo(exporter);

         }

         @Override
         public ShapedRecipeJsonBuilder createShaped(RecipeCategory category, ItemConvertible output) {
            return super.createShaped(category, output);
         }
            
      };
   }
   
}
