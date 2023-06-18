package fr.chokojoestar.capymod.item;

import fr.chokojoestar.capymod.CapyMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CapyItemsGroup {
   public static ItemGroup CAPYBARA = Registry.register(Registries.ITEM_GROUP,
         new Identifier(CapyMod.MOD_ID, "capybara"),
         FabricItemGroup.builder()
               .icon(() -> new ItemStack(CapyItems.DEV_ITEM))
               .displayName(Text.literal("Capybara Mod")).entries((displayContext, entries) -> {
                  entries.add(CapyItems.DEV_ITEM);
                  entries.add(CapyItems.CAPYBARA_SPAWN_EGG);
                  entries.add(CapyItems.DEV_MOB_SPAWN_EGG);
               }).build());

   public static void registerItemsGroup() {
      CapyMod.LOGGER.debug("Registering Mod Items Groups for " + CapyMod.MOD_ID);
   }
}
