package fr.chokojoestar.capymod;

import fr.chokojoestar.capymod.client.render.CapybaraRenderer;
import fr.chokojoestar.capymod.client.render.model.CapybaraModel;
import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.entity.CapyModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CapybaraClient implements ClientModInitializer{

   @Override
   public void onInitializeClient() {
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYABRA, CapybaraModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYABRA_BABY, CapybaraModel::getTexturedModelData);
      EntityRendererRegistry.register(CapyEntities.CAPYBARA, CapybaraRenderer::new);
   
   }
   
}
