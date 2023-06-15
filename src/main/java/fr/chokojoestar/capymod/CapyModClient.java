package fr.chokojoestar.capymod;

import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.entity.custom.DevMob.DevMobRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CapyModClient implements ClientModInitializer{

   @Override
   public void onInitializeClient() {
      EntityRendererRegistry.register(CapyEntities.DEV_MOB, DevMobRenderer::new);
   }
   
}
