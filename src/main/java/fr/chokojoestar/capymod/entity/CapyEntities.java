package fr.chokojoestar.capymod.entity;

import fr.chokojoestar.capymod.Register;
import fr.chokojoestar.capymod.entity.custom.Capybara.CapybaraEntity;
import net.minecraft.entity.EntityType;

public class CapyEntities {

  public static final EntityType<CapybaraEntity> CAPYBARA = Register.registerEntity("capybara", CapybaraEntity::new,
      0.8f, 0.9f);
}
