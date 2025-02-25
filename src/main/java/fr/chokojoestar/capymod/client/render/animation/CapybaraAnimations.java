package fr.chokojoestar.capymod.client.render.animation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.client.render.entity.animation.Animation.Builder;

@Environment(EnvType.CLIENT)
public class CapybaraAnimations {
      public static final Animation WALKING;
      public static final Animation SITTING;
      public static final Animation IDLING;

      public CapybaraAnimations() {
      }

      static {
            WALKING = Builder.create(2f).looping()
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg4",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f,
                                                            AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("body",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.5f,
                                                            AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f, AnimationHelper.createRotationalVector(0f, 0f, 5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(0f, 0f, 5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, -5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f, AnimationHelper.createRotationalVector(0f, 0f, -5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(0f, 0f, -5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("saddle",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.25f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.75f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.25f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.5f,
                                                            AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f,
                                                            AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .build();

            SITTING = Builder.create(1.5f)
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, -4f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createRotationalVector(-25f, 0f, 75f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, -4f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createRotationalVector(-25f, 0f, -75f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(-3f, -2f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.2f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 77.5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.9f,
                                                            AnimationHelper.createRotationalVector(20f, 0f, 77.5f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg4",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(3f, -1.75f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg4",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.2f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, -77.5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.9f,
                                                            AnimationHelper.createRotationalVector(20f, 0f, -77.5f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("body",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, -5f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("head",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, -5f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("saddle",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.5f,
                                                            AnimationHelper.createTranslationalVector(0f, -5f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0.2f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 30f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0.1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, -30f),
                                                            Transformation.Interpolations.LINEAR)))
                        .build();

            IDLING = Builder.create(3f)
                        .addBoneAnimation("head2",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("head2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("head2",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg1",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg2",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("leg3",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("body",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("body",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("body",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("head",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("head",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.70833f,
                                                            AnimationHelper.createRotationalVector(-0.11f, 10f, -1.01f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f,
                                                            AnimationHelper.createRotationalVector(0f, -2.61f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear1",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear1",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0.125f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.41667f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 27.5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.625f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.0417f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.4583f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 20f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2.375f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(2.6667f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 37.5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear1",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear2",
                                    new Transformation(Transformation.Targets.TRANSLATE,
                                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear2",
                                    new Transformation(Transformation.Targets.ROTATE,
                                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.29167f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, -27.5f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(0.625f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.125f,
                                                            AnimationHelper.createRotationalVector(0f, 0f, 20f),
                                                            Transformation.Interpolations.LINEAR),
                                                new Keyframe(1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                                            Transformation.Interpolations.LINEAR)))
                        .addBoneAnimation("ear2",
                                    new Transformation(Transformation.Targets.SCALE,
                                                new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                                            Transformation.Interpolations.LINEAR)))
                        .build();
      }

}
