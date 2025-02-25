package fr.chokojoestar.capymod.items;

import fr.chokojoestar.capymod.Capybara;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CapyItemGroup {
   public static final RegistryKey<ItemGroup> CAPY_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
         Identifier.of(Capybara.MOD_ID, "capybara"));
         
   public static final ItemGroup CAPY_ITEM_GROUP = FabricItemGroup.builder()
         .icon(() -> new ItemStack(CapyItems.STAFF))
         .displayName(Text.translatable("itemGroup.capymod"))
         .build();

   public static void initialize() {
      Registry.register(Registries.ITEM_GROUP, CAPY_ITEM_GROUP_KEY, CAPY_ITEM_GROUP);
      ItemGroupEvents.modifyEntriesEvent(CAPY_ITEM_GROUP_KEY).register(
         itemGroup -> {
            itemGroup.add(CapyItems.STAFF);
            itemGroup.add(CapyItems.CAPYBARA_SPAWN_EGG);
         }
      );
      Capybara.LOGGER.info("Starting to initialize item group for " + Capybara.MOD_ID);
   }


}
