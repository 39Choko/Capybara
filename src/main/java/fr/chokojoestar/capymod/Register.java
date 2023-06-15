package fr.chokojoestar.capymod;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Register {

   public static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, new Identifier(CapyMod.MOD_ID, name), item);
   }
}
