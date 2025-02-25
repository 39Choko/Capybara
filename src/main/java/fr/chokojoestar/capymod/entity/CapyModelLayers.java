package fr.chokojoestar.capymod.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import fr.chokojoestar.capymod.registry.Register;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class CapyModelLayers {
   private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
	public static final EntityModelLayer CAPYABRA = registerMain("capybara");
	public static final EntityModelLayer CAPYABRA_BABY = registerMain("capybara_baby");
   public static final EntityModelLayer CAPYBARA_SADDLE = register("capybara", "saddle");
   public static final EntityModelLayer CAPYBARA_BABY_SADDLE = register("capybara_baby", "saddle");


   private static EntityModelLayer create(String name, String layer) {
      return new EntityModelLayer(Register.getEntityRegistryKey(name).getValue(), layer);
   }

   private static EntityModelLayer register(String name, String layer) { 
      EntityModelLayer entityModelLayer = create(name, layer);
      if(!LAYERS.add(entityModelLayer)){
         throw new IllegalStateException("Duplicate registration for " + String.valueOf(entityModelLayer));
      } else {
         return entityModelLayer;
      }
   }

   private static EntityModelLayer registerMain(String name) {
      return register(name, "main");
   }
}
