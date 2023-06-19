package fr.chokojoestar.capymod;

import java.util.function.Consumer;

import fr.chokojoestar.capymod.item.CapyItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Register {

   public static Identifier registerLocation(String dir, String file) {
      return new Identifier(CapyMod.MOD_ID, dir + "/" + file);
   }

   public static void registerSpawnEggData(BlockStateModelGenerator BSModelGen, Item egg) {
      BSModelGen.registerParentedItemModel(egg, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
   }

   public static void registerItemData(ItemModelGenerator IModelGen, Item item, Model models) {
      IModelGen.register(item, models);
   }

   public static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, new Identifier(CapyMod.MOD_ID, name), item);
   }

   public static Item registerSpawnEggItem(String name, EntityType<? extends MobEntity> entity, int primaryColor,
         int secondaryColor) {
      return Register.registerItem(name,
            new SpawnEggItem(entity, primaryColor, secondaryColor, new FabricItemSettings()));
   }

   public static <T extends Entity> EntityType<T> registerEntity(String name, EntityType.EntityFactory<T> factory,
         float width, float height) {
      Identifier id = new Identifier(CapyMod.MOD_ID, name);
      return Registry.register(Registries.ENTITY_TYPE, id, FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, factory)
            .dimensions(EntityDimensions.fixed(width, height)).build());
   }
   }
