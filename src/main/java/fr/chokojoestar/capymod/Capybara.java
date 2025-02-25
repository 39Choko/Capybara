package fr.chokojoestar.capymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.entity.custom.CapybaraEntity;
import fr.chokojoestar.capymod.items.CapyItemGroup;
import fr.chokojoestar.capymod.items.CapyItems;
import fr.chokojoestar.capymod.world.gen.CapyWorldGen;


public class Capybara implements ModInitializer {
	public static final String MOD_ID = "capymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CapyItems.initialize();
		CapyItemGroup.initialize();
		CapyWorldGen.initialize();
		CapyEntities.initialize();

		FabricDefaultAttributeRegistry.register(CapyEntities.CAPYBARA, CapybaraEntity.createCapybaraAttributes());
	}

}