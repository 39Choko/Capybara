package fr.chokojoestar.capymod.registry;

import fr.chokojoestar.capymod.Capybara;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Register {
   public static Identifier getId(String name) { 
      return Identifier.of(Capybara.MOD_ID, name);
   }

   public static RegistryKey<Item> getItemRegistryKey(String name) {
      return RegistryKey.of(RegistryKeys.ITEM, getId(name));
   }

   public static RegistryKey<EntityType<?>> getEntityRegistryKey(String name) {
      return RegistryKey.of(RegistryKeys.ENTITY_TYPE, getId(name));
   }

   public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, getItemRegistryKey(name).getValue(), item);
	}

   public static <T extends AnimalEntity> EntityType<T> registerEntity(String name, EntityType.EntityFactory<T> entity, SpawnGroup group, float width, float height) {
      return Registry.register(
         Registries.ENTITY_TYPE, 
         Register.getEntityRegistryKey(name).getValue(),
         EntityType.Builder
         .create(entity, group)
         .dimensions(width, height)
         .build(Register.getEntityRegistryKey("name"))
      );
   }
}
