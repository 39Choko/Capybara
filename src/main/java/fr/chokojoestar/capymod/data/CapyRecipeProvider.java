package fr.chokojoestar.capymod.data;

import java.util.function.Consumer;

import fr.chokojoestar.capymod.item.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class CapyRecipeProvider extends FabricRecipeProvider {

   public CapyRecipeProvider(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generate(Consumer<RecipeJsonProvider> exporter) {
      ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, CapyItems.STAFF)
            /* PATTERN */
            .pattern("S  ").pattern(" I ").pattern("  S")
            /* INPUT */
            .input('S', Items.STICK).input('I', Items.IRON_NUGGET)
            /* OUTPUT */
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                  FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .criterion(FabricRecipeProvider.hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK))
            .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(CapyItems.STAFF)));

   }

}
