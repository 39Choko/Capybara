package fr.chokojoestar.capymod.items;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Rarity;
import fr.chokojoestar.capymod.Capybara;
import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.registry.Register;

public class CapyItems {

  public static final Item STAFF = Register.registerItem("staff",
      new Item(new Item.Settings()
          .registryKey(Register.getItemRegistryKey("staff"))
          .maxCount(1)
          .rarity(Rarity.RARE)));

  public static final Item CAPYBARA_SPAWN_EGG = Register.registerItem("capybara_spawn_egg",
      new SpawnEggItem(CapyEntities.CAPYBARA,
          new Item.Settings().registryKey(Register.getItemRegistryKey("capybara_spawn_egg"))));

  public static void initialize() {
    Capybara.LOGGER.info("Starting to initialize item for " + Capybara.MOD_ID);
  }
}
