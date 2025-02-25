package fr.chokojoestar.capymod.entity.custom;

import java.util.Set;
import com.google.common.collect.Sets;
import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.items.CapyItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.SaddledComponent;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker.Builder;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CapybaraEntity extends TameableEntity implements Saddleable {
   public final AnimationState idlingAnimationState = new AnimationState();
   public final AnimationState sittingAnimationState = new AnimationState();
   private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(CapybaraEntity.class,
         TrackedDataHandlerRegistry.BOOLEAN);
   private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(CapybaraEntity.class,
         TrackedDataHandlerRegistry.INTEGER);
   private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.MELON_SLICE, Items.CARROT);
   private static final Set<Item> SITS_ITEMS = Sets.newHashSet(Items.STICK, Items.BAMBOO, CapyItems.STAFF);
   private final SaddledComponent saddledComponent;
   private int idleAnimationTimeout = 0;

   public CapybaraEntity(EntityType<? extends TameableEntity> entityType, World world) {
      super(entityType, world);
      this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
   }

   @Override
   public void writeCustomDataToNbt(NbtCompound nbt) {
      super.writeCustomDataToNbt(nbt);
      this.saddledComponent.writeNbt(nbt);
   }

   @Override
   public void readCustomDataFromNbt(NbtCompound nbt) {
      super.readCustomDataFromNbt(nbt);
      this.saddledComponent.readNbt(nbt);
   }

   @Override
   protected void initGoals() {
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(1, new SitGoal(this));
      this.goalSelector.add(2, new EscapeDangerGoal(this, 1.25));
      this.goalSelector.add(3, new AnimalMateGoal(this, 1.0));
      this.goalSelector.add(4, new TemptGoal(this, 1.25, BREEDING_INGREDIENT, false));
      this.goalSelector.add(5, new FollowParentGoal(this, 1.1));
      this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
      this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.add(8, new LookAroundGoal(this));
   }

   public static DefaultAttributeContainer.Builder createCapybaraAttributes() {
      return AnimalEntity.createAnimalAttributes()
            .add(EntityAttributes.MAX_HEALTH, 10.0)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.25);
   }

   @Override
   public ActionResult interactMob(PlayerEntity player, Hand hand) {
      ItemStack itemStack = player.getStackInHand(hand);
      Item item = itemStack.getItem();
      ActionResult actionResult = super.interactMob(player, hand);

      /* TAMING SYSTEM */
      if (!this.isTamed() && isBreedingItem(itemStack)) {
         startTaming(player, itemStack);
         return ActionResult.SUCCESS;
      }

      if (this.isTamed() && this.isOwner(player)) {
         /* REGEN SYSTEM */
         if (isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
            this.eat(player, hand, itemStack);
            FoodComponent foodComponent = (FoodComponent) itemStack.get(DataComponentTypes.FOOD);
            float f = foodComponent != null ? (float) foodComponent.nutrition() : 1.0F;
            this.heal(2.0F * f);
            return ActionResult.SUCCESS;
         }

         /* SADDLE SYSTEM */
         if (actionResult.isAccepted() && !(itemStack.isOf(Items.SADDLE))) {
            itemStack.useOnEntity(player, this, hand);
            return ActionResult.SUCCESS;
         }

         /* RIDING SYSTEM */
         if (canBeRiding(item, itemStack, player, hand)) {
            if (!this.getWorld().isClient())
               player.startRiding(this);
            return ActionResult.SUCCESS;
         }

         /* SITTING SYSTEM */
         if (SITS_ITEMS.contains(item) && !actionResult.isAccepted()) {
            this.setSitting(!this.isSitting());
            return ActionResult.SUCCESS;
         }
      }
      return actionResult;
   }

   @Override
   protected void initDataTracker(Builder builder) {
      super.initDataTracker(builder);
      builder.add(SADDLED, false);
      builder.add(BOOST_TIME, 0);
   }

   private void updateAnimations() {
      if (this.idleAnimationTimeout <= 0) {
         this.idleAnimationTimeout = 40;
         this.idlingAnimationState.start(this.age);
      } else {
         --this.idleAnimationTimeout;
      }

      if (this.isSitting()) {
         this.sittingAnimationState.startIfNotRunning(this.age);
      } else {
         this.sittingAnimationState.stop();
      }

   }

   private boolean canBeRiding(Item item, ItemStack itemStack, PlayerEntity player, Hand hand) {
      boolean emptyHand = !(SITS_ITEMS.contains(item)) && !(isBreedingItem(itemStack))
            && player.getStackInHand(hand).isEmpty();
      return emptyHand && !this.isSitting() && this.isSaddled() && !this.hasPassengers()
            && !player.shouldCancelInteraction();
   }

   private void startTaming(PlayerEntity player, ItemStack itemStack) {
      decrementItem(player, itemStack, 1);
      if (!this.getWorld().isClient()) {
         if (this.random.nextInt(10) == 0) {
            this.setOwner(player);
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
         } else {
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
         }
      }
   }

   @Override
   public void tick() {
      super.tick();

      if (this.getWorld().isClient()) {
         this.updateAnimations();
      }

      if (this.isSitting() && this.isTouchingWater()) {
         this.setStanding();
      }
   }

   @Override
   public LivingEntity getControllingPassenger() {
      if (this.isSaddled()) {
         Entity entity = this.getFirstPassenger();
         if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) entity;
            if (playerEntity.isHolding(CapyItems.STAFF)) {
               return playerEntity;
            }
         }
      }

      return super.getControllingPassenger();
   }

   public void onTrackedDataSet(TrackedData<?> data) {
      if (BOOST_TIME.equals(data) && this.getWorld().isClient) {
         this.saddledComponent.boost();
      }
      super.onTrackedDataSet(data);
   }

   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return BREEDING_INGREDIENT.test(stack);
   }

   @Override
   public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
      return CapyEntities.CAPYBARA.create(world, SpawnReason.BREEDING);
   }

   @Override
   protected void dropInventory(ServerWorld world) {
      super.dropInventory(world);
      if (this.isSaddled()) {
         this.dropItem(world, Items.SADDLE);
      }
   }

   @Override
   public void saddle(ItemStack stack, SoundCategory soundCategory) {
      this.saddledComponent.setSaddled(true);
      if (soundCategory != null) {
         this.getWorld().playSoundFromEntity((PlayerEntity) null, this, SoundEvents.ENTITY_PIG_SADDLE, soundCategory,
               0.5F, 1.0F);
      }
   }

   @Override
   public boolean canBeSaddled() {
      return this.isAlive() && !this.isBaby();
   }

   @Override
   public boolean isSaddled() {
      return this.saddledComponent.isSaddled();
   }

   private void decrementItem(PlayerEntity player, ItemStack itemStack, int amount) {
      if (!player.getAbilities().creativeMode) {
         itemStack.decrement(amount);
      }
   }

   @Override
   public Vec3d updatePassengerForDismount(LivingEntity passenger) {
      Direction direction = this.getMovementDirection();
      if (direction.getAxis() == Direction.Axis.Y) {
         return super.updatePassengerForDismount(passenger);
      }
      int[][] is = Dismounting.getDismountOffsets(direction);
      BlockPos blockPos = this.getBlockPos();
      BlockPos.Mutable mutable = new BlockPos.Mutable();
      for (EntityPose entityPose : passenger.getPoses()) {
         Box box = passenger.getBoundingBox(entityPose);
         for (int[] js : is) {
            mutable.set(blockPos.getX() + js[0], blockPos.getY(), blockPos.getZ() + js[1]);
            double d = this.getWorld().getDismountHeight(mutable);
            if (!Dismounting.canDismountInBlock(d))
               continue;
            Vec3d vec3d = Vec3d.ofCenter(mutable, d);
            if (!Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d)))
               continue;
            passenger.setPose(entityPose);
            return vec3d;
         }
      }
      return super.updatePassengerForDismount(passenger);
   }

   @Override
   protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
      super.tickControlled(controllingPlayer, movementInput);
      this.setRotation(controllingPlayer.getYaw(), controllingPlayer.getPitch() * 0.5f);
      this.bodyYaw = this.headYaw = this.getYaw();
      this.prevYaw = this.headYaw;
      this.saddledComponent.tickBoost();
   }

   @Override
   protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
      return new Vec3d(0.0, 0.0, 1.0);
   }

   @Override
   protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
      return (float) (this.getAttributeValue(EntityAttributes.MOVEMENT_SPEED) * 0.5
            * (double) this.saddledComponent.getMovementSpeedMultiplier());
   }

   @Override
   public Vec3d getLeashOffset() {
      return new Vec3d(0.0, 0.6f * this.getStandingEyeHeight(), this.getWidth() * 0.4f);
   }

   @Override
   protected void applyDamage(ServerWorld world, DamageSource source, float amount) {
      this.setStanding();
      super.applyDamage(world, source, amount);
   }

   private void setStanding() {
      this.setPose(EntityPose.STANDING);
      this.emitGameEvent(GameEvent.ENTITY_ACTION);
   }

}