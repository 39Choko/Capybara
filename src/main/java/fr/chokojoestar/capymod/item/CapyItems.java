package fr.chokojoestar.capymod.item;

import fr.chokojoestar.capymod.CapyMod;
import fr.chokojoestar.capymod.Register;
import fr.chokojoestar.capymod.entity.CapyEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class CapyItems {
      public static final Item DEV_ITEM = Register.registerItem("dev_item", new Item(new FabricItemSettings()));
      public static final Item STAFF = Register.registerItem("staff", new Item(
                  new FabricItemSettings().maxCount(1).maxDamage(64).maxDamageIfAbsent(64).rarity(Rarity.RARE)));
      public static final Item DEV_MOB_SPAWN_EGG = Register.registerSpawnEggItem("dev_mob_spawn_egg",
                  CapyEntities.DEV_MOB, 0xFFFFFF, 0x000000);
      public static final Item CAPYBARA_SPAWN_EGG = Register.registerSpawnEggItem("capybara_spawn_egg",
                  CapyEntities.CAPYBARA, 0x2f1a00, 0xce9969);

      public static void registerItems() {
            CapyMod.LOGGER.debug("Registering Mod Items for " + CapyMod.MOD_ID);
      }
}
