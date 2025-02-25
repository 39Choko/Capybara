package fr.chokojoestar.capymod.data;

import java.util.concurrent.CompletableFuture;

import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.items.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class CapyEnglishLangProvider extends FabricLanguageProvider {

   public CapyEnglishLangProvider(FabricDataOutput dataOutput,
         CompletableFuture<WrapperLookup> registryLookup) {
      super(dataOutput, "en_us", registryLookup);
   }

   @Override
   public void generateTranslations(WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
      translationBuilder.add(CapyItems.STAFF, "Staff");
      translationBuilder.add(CapyItems.CAPYBARA_SPAWN_EGG, "Capybara Spawn Egg");
      translationBuilder.add(CapyEntities.CAPYBARA, "Capybara");
      translationBuilder.add("itemGroup.capymod", "Capymod");

   }
}
