package fr.chokojoestar.capymod.world.gen;

import fr.chokojoestar.capymod.Capybara;

public class CapyWorldGen {

  public static void initialize() {
    CapyEntityGen.addSpawn();
    Capybara.LOGGER.info("Starting to initialize world gen for " + Capybara.MOD_ID);

  }
}
