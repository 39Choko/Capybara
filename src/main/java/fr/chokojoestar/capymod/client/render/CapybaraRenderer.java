package fr.chokojoestar.capymod.client.render;

import fr.chokojoestar.capymod.Capybara;
import fr.chokojoestar.capymod.client.render.model.CapybaraModel;
import fr.chokojoestar.capymod.client.render.state.CapybaraEntityRenderState;
import fr.chokojoestar.capymod.entity.CapyModelLayers;
import fr.chokojoestar.capymod.entity.custom.CapybaraEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings("deprecation")
public class CapybaraRenderer extends AgeableMobEntityRenderer<CapybaraEntity, CapybaraEntityRenderState, CapybaraModel> {
   private static final Identifier TEXTURE = Identifier.of(Capybara.MOD_ID, "textures/entity/capybara/capybara.png");

   public CapybaraRenderer(Context context) {
      super(context, new CapybaraModel(context.getPart(CapyModelLayers.CAPYABRA)), new CapybaraModel(context.getPart(CapyModelLayers.CAPYABRA_BABY)), 0.5f);
   }

   @Override
   public Identifier getTexture(CapybaraEntityRenderState state) {
      return TEXTURE;
   }

   @Override
   public CapybaraEntityRenderState createRenderState() {
      return new CapybaraEntityRenderState();
   }

   @Override
   public void updateRenderState(CapybaraEntity capybaraEntity, CapybaraEntityRenderState capybaraEntityRenderState, float f) {
      super.updateRenderState(capybaraEntity, capybaraEntityRenderState, f);
      capybaraEntityRenderState.saddle = capybaraEntity.isSaddled();
      capybaraEntityRenderState.idlingAnimationState.copyFrom(capybaraEntity.idlingAnimationState);
      capybaraEntityRenderState.sittingAnimationState.copyFrom(capybaraEntity.sittingAnimationState);
   }

   @Override
   public void render(CapybaraEntityRenderState entity, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {

      if (entity.baby) {
         matrixStack.scale(0.5F, 0.5F, 0.5F);
      } else {
         matrixStack.scale(1.0F, 1.0F, 1.0F);
      }

      super.render(entity, matrixStack, vertexConsumerProvider, i);
   }

}
