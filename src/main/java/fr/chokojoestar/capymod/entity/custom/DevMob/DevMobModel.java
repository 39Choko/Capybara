package fr.chokojoestar.capymod.entity.custom.DevMob;

import fr.chokojoestar.capymod.Register;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DevMobModel extends GeoModel<DevMobEntity> {

  @Override
  public Identifier getModelResource(DevMobEntity animatable) {
    return Register.registerLocation("geo", "dev_mob.geo.json");
  }

  @Override
  public Identifier getTextureResource(DevMobEntity animatable) {
    return Register.registerLocation("textures/entity", "dev_mob.png");
  }

  @Override
  public Identifier getAnimationResource(DevMobEntity animatable) {
    return Register.registerLocation("animations", "dev_mob.animation.json");
  }

  @Override
  public void setCustomAnimations(
      DevMobEntity animatable,
      long instanceId,
      AnimationState<DevMobEntity> animationState) {
    CoreGeoBone head = getAnimationProcessor().getBone("head");

    if (head != null) {
      EntityModelData entityModelData = animationState.getData(
          DataTickets.ENTITY_MODEL_DATA);
      head.setRotX(entityModelData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
      head.setRotX(
          entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
    }
  }
}
