package fr.chokojoestar.capymod.entity.custom.DevMob;

import fr.chokojoestar.capymod.Register;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DevMobRenderer extends GeoEntityRenderer<DevMobEntity> {

   public DevMobRenderer(Context renderManager) {
      super(renderManager, new DevMobModel());
   }

   @Override
   public Identifier getTextureLocation(DevMobEntity animatable) {
      return Register.registerLocation("dev_mob", "dev_mob.png");
   }

   @Override
   public void render(DevMobEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
         VertexConsumerProvider bufferSource, int packedLight) {

      if (entity.isBaby()) {
         poseStack.scale(0.4f, 0.4f, 0.4f);
      }

      super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
   }

}
