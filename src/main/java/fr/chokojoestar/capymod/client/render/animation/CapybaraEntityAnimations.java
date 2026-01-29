package fr.chokojoestar.capymod.client.render.animation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

@Environment(EnvType.CLIENT)
public class CapybaraEntityAnimations {

  public CapybaraEntityAnimations() {
  }

  public static final AnimationDefinition WALKING = AnimationDefinition.Builder.create(1.5833F).looping()
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg4", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .build();

  public static final AnimationDefinition SITTING = AnimationDefinition.Builder.create(1.1667F)
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 77.5F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -77.5F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 77.5F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-3.0F, -2.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg4", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -77.5F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg4", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(3.0F, -1.75F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("saddle", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .build();

  public static final AnimationDefinition IDLING = AnimationDefinition.Builder.create(3.0F)
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg1", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg2", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("leg3", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-0.1113F, 2.5001F, -1.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, -2.609F, -0.0024F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear1", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 27.5F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 20.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(2.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 37.5F),
              Transformation.Interpolations.LINEAR),
          new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear1", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear2", new Transformation(Transformation.Targets.ROTATE,
          new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear2", new Transformation(Transformation.Targets.MOVE_ORIGIN,
          new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F),
              Transformation.Interpolations.LINEAR)))
      .addBoneAnimation("ear2", new Transformation(Transformation.Targets.SCALE,
          new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F),
              Transformation.Interpolations.LINEAR)))
      .build();
}
