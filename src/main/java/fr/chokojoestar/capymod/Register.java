package fr.chokojoestar.capymod;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Register {

   public static Identifier registerLocation(String mobName, String file) {
      return new Identifier(CapyMod.MOD_ID, "gekolib/" + mobName + "/" + file);
   }

   public static void registerSpawnEgg(BlockStateModelGenerator BSModelGenerator, Item egg) {
      BSModelGenerator.registerParentedItemModel(egg, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
   }

   public static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, new Identifier(CapyMod.MOD_ID, name), item);
   }
}
