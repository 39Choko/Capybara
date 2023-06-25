package fr.chokojoestar.capymod.entity.custom.Capybara;

import fr.chokojoestar.capymod.Register;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CapybaraRenderer extends GeoEntityRenderer<CapybaraEntity> {

   public CapybaraRenderer(Context renderManager) {
      super(renderManager, new CapybaraModel());
   }

   @Override
   public Identifier getTextureLocation(CapybaraEntity animatable) {
      return Register.registerLocation("textures/entity", "capybara.png");
   }

   @Override
   public void render(CapybaraEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
         VertexConsumerProvider bufferSource, int packedLight) {
      if (entity.isBaby()) {
         poseStack.scale(0.4f, 0.4f, 0.4f);
      }

      super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
   }

}
