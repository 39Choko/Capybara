package fr.chokojoestar.capymod;

import fr.chokojoestar.capymod.client.render.CapybaraEntityRenderer;
import fr.chokojoestar.capymod.client.render.model.CapybaraEntityModel;
import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.entity.CapyModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CapybaraClient implements ClientModInitializer{

   @Override
   public void onInitializeClient() {
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYABRA, CapybaraEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYABRA_BABY, CapybaraEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYBARA_SADDLE, CapybaraEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(CapyModelLayers.CAPYBARA_BABY_SADDLE, CapybaraEntityModel::getTexturedModelData);

      EntityRendererRegistry.register(CapyEntities.CAPYBARA, CapybaraEntityRenderer::new);
   
   }
   
}
