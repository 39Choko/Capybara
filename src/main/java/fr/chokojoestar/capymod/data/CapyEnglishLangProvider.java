package fr.chokojoestar.capymod.data;

import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.item.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class CapyEnglishLangProvider extends FabricLanguageProvider {

   public CapyEnglishLangProvider(FabricDataOutput dataOutput) {
      super(dataOutput);
   }

   @Override
   public void generateTranslations(TranslationBuilder translationBuilder) {
      translationBuilder.add(CapyItems.STAFF, "Staff");
      translationBuilder.add(CapyItems.CAPYBARA_SPAWN_EGG, "Capybara Spawn Egg");
      translationBuilder.add(CapyEntities.CAPYBARA, "Capybara");
   }

}
