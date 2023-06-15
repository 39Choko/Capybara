package fr.chokojoestar.capymod.item;

import fr.chokojoestar.capymod.CapyMod;
import fr.chokojoestar.capymod.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class CapyItems {
   public static final Item DEV_ITEM = Register.registerItem("dev_item", new Item(new FabricItemSettings()));


   public static void registerItems() {
      CapyMod.LOGGER.debug("Registering Mod Items for " + CapyMod.MOD_ID);
   }
}
