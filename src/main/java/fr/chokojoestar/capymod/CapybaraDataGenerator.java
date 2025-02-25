package fr.chokojoestar.capymod;

import fr.chokojoestar.capymod.data.CapyEnglishLangProvider;
import fr.chokojoestar.capymod.data.CapyModelProvider;
import fr.chokojoestar.capymod.data.CapyRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CapybaraDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(CapyEnglishLangProvider::new);
		pack.addProvider(CapyRecipeProvider::new);
		pack.addProvider(CapyModelProvider::new);	
	}

}