package fr.chokojoestar.capymod.item;

import fr.chokojoestar.capymod.CapyMod;
import fr.chokojoestar.capymod.Register;
import fr.chokojoestar.capymod.entity.CapyEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class CapyItems {
   public static final Item DEV_ITEM = Register.registerItem("dev_item", new Item(new FabricItemSettings()));
   public static final Item DEV_MOB_SPAWN_EGG = Register.registerItem("dev_mob_spawn_egg",
         new SpawnEggItem(CapyEntities.DEV_MOB, 0xFFFFFF, 0x000000, new FabricItemSettings()));

   public static void registerItems() {
      CapyMod.LOGGER.debug("Registering Mod Items for " + CapyMod.MOD_ID);
   }
}
