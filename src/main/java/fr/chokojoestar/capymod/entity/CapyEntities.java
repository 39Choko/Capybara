package fr.chokojoestar.capymod.entity;

import fr.chokojoestar.capymod.Register;
import fr.chokojoestar.capymod.entity.custom.Capybara.CapybaraEntity;
import fr.chokojoestar.capymod.entity.custom.DevMob.DevMobEntity;
import net.minecraft.entity.EntityType;

public class CapyEntities {
      public static final EntityType<DevMobEntity> DEV_MOB = Register.registerEntity("dev_mob", DevMobEntity::new, 0.6f,
                  1.95f);
      public static final EntityType<CapybaraEntity> CAPYBARA = Register.registerEntity("capybara", CapybaraEntity::new,
                  0.8f, 0.9f);

}
