package fr.chokojoestar.capymod.entity;

import fr.chokojoestar.capymod.Capybara;
import fr.chokojoestar.capymod.entity.custom.CapybaraEntity;
import fr.chokojoestar.capymod.registry.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;


public class CapyEntities {

   public static final EntityType<CapybaraEntity> CAPYBARA = Register.registerEntity(
      "capybara", 
      CapybaraEntity::new, 
      SpawnGroup.AMBIENT, 
      0.8F, 0.8F
      );

   public static void initialize() {
      Capybara.LOGGER.info("Starting to initialize entities for " + Capybara.MOD_ID);

   }
}
