package fr.chokojoestar.capymod.entity;

import fr.chokojoestar.capymod.CapyMod;
import fr.chokojoestar.capymod.entity.custom.DevMob.DevMobEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CapyEntities {
      public static final EntityType<DevMobEntity> DEV_MOB = Registry.register(Registries.ENTITY_TYPE,
                  new Identifier(CapyMod.MOD_ID, "dev_mob"),
                  FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DevMobEntity::new)
                              .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());

}
