package fr.chokojoestar.capymod.entity.custom.DevMob;

import fr.chokojoestar.capymod.entity.CapyEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DevMobEntity extends AnimalEntity implements GeoEntity {

   private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

   public DevMobEntity(EntityType<? extends AnimalEntity> entityType, World world) {
      super(entityType, world);
   }

   public static DefaultAttributeContainer.Builder setAttributes() {
      return AnimalEntity
            .createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4f)
            .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4f)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f);
   }

   @Override
   protected void initGoals() {
      this.goalSelector.add(1, new SwimGoal(this));
      this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
      this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
      this.goalSelector.add(4, new LookAroundGoal(this));

      this.targetSelector.add(2, new ActiveTargetGoal<>(this, CowEntity.class, true));
   }

   @Nullable
   @Override
   public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
      return CapyEntities.DEV_MOB.create(world);
   }

   @Override
   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return cache;
   }

   @Override
   public void registerControllers(ControllerRegistrar controllerRegistrar) {
      controllerRegistrar.add(
            new AnimationController<>(this, "controller", 0, this::predicate));
   }

   private PlayState predicate(AnimationState<?> tAnimationState) {
      if (tAnimationState.isMoving()) {
         tAnimationState.getController()
               .setAnimation(RawAnimation.begin().then("animation.dev_mob.walk", Animation.LoopType.LOOP));
         return PlayState.CONTINUE;
      }

      tAnimationState.getController()
            .setAnimation(RawAnimation.begin().then("animation.dev_mob.idle", Animation.LoopType.LOOP));
      return PlayState.CONTINUE;
   }
}
