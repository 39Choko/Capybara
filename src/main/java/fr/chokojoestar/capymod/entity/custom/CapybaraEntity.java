package fr.chokojoestar.capymod.entity.custom;

import java.util.Set;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;

import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.items.CapyItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemSteerable;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CapybaraEntity extends TameableEntity implements ItemSteerable {
  public final AnimationState idlingAnimationState = new AnimationState();
  public final AnimationState sittingAnimationState = new AnimationState();
  private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(CapybaraEntity.class,
      TrackedDataHandlerRegistry.INTEGER);
  private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.MELON_SLICE, Items.CARROT);
  private static final Set<Item> SITS_ITEMS = Sets.newHashSet(Items.STICK, Items.BAMBOO, CapyItems.STAFF);
  private final SaddledComponent saddledComponent;
  private int idleAnimationTimeout = 0;

  public CapybaraEntity(EntityType<? extends TameableEntity> entityType, World world) {
    super(entityType, world);
    this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME);
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
  public LivingEntity getControllingPassenger() {
    if (this.hasSaddleEquipped()) {
      Entity entity = this.getFirstPassenger();
      if (entity instanceof PlayerEntity playerEntity) {
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
  protected void initDataTracker(Builder builder) {
    super.initDataTracker(builder);
    builder.add(BOOST_TIME, 0);
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    ItemStack itemStack = player.getStackInHand(hand);

    if (!this.isTamed() && isBreedingItem(itemStack) && !this.getWorld().isClient) {
      itemStack.decrementUnlessCreative(1, player);
      startTaming(player);
      return ActionResult.SUCCESS_SERVER;
    } else if (this.isTamed()) {
      tryHealWithFood(player, hand, itemStack);

      if (this.isTamed() && this.isOwner(player)) {
        setSaddle(player, itemStack);
        startRidding(player, hand, itemStack);
        setSitting(itemStack);
        return ActionResult.SUCCESS;
      }

      return ActionResult.SUCCESS;
    } else {
      return super.interactMob(player, hand);
    }
  }

  private void setSitting(ItemStack itemStack) {
    if (SITS_ITEMS.contains(itemStack.getItem())) {
      this.setSitting(!this.isSitting());
    }
  }

  private void setSaddle(PlayerEntity player, ItemStack itemStack) {
    if (itemStack.isOf(Items.SADDLE)) {
      this.equipStack(EquipmentSlot.SADDLE, itemStack);
      itemStack.useOnEntity(player, this, preferredHand);
    }
  }

  private void startRidding(PlayerEntity player, Hand hand, ItemStack itemStack) {
    if (canBeRiding(itemStack.getItem(), itemStack, player, hand)
        && !this.getWorld().isClient) {
      player.startRiding(this);
    }
  }

  private boolean tryHealWithFood(PlayerEntity player, Hand hand, ItemStack itemStack) {
    if (isBreedingItem(itemStack) && getHealth() < getMaxHealth()) {
      eat(player, hand, itemStack);
      FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
      float nutrition = foodComponent != null ? (float) foodComponent.nutrition() : 1.0F;
      heal(2.0F * nutrition);
      return true;
    }
    return false;
  }

  private void startTaming(PlayerEntity player) {
    if (this.random.nextInt(3) == 0) {
      this.setTamedBy(player);
      this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
    } else {
      this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
    }
  }

  private boolean canBeRiding(Item item, ItemStack itemStack, PlayerEntity player, Hand hand) {
    return !(SITS_ITEMS.contains(item))
        && !(isBreedingItem(itemStack))
        && player.getMainHandStack().isEmpty()
        && this.hasSaddleEquipped()
        && !this.hasPassengers()
        && !player.shouldCancelInteraction();
  }

  @Override
  public void equipStack(EquipmentSlot slot, ItemStack stack) {
    super.equipStack(slot, stack);
  }

  @Override
  public boolean canUseSlot(EquipmentSlot slot) {
    if (slot == EquipmentSlot.SADDLE) {
      return this.isAlive() && !this.isBaby();
    }
    return super.canUseSlot(slot);
  }

  @Override
  protected boolean canDispenserEquipSlot(EquipmentSlot slot) {
    return slot == EquipmentSlot.SADDLE || super.canDispenserEquipSlot(slot);
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
    if (this.hasSaddleEquipped()) {
      this.dropItem(world, Items.SADDLE);
    }
  }

  public Vec3d updatePassengerForDismount(LivingEntity passenger) {
    Direction direction = this.getMovementDirection();
    if (direction.getAxis() == Axis.Y) {
      return super.updatePassengerForDismount(passenger);
    } else {
      int[][] is = Dismounting.getDismountOffsets(direction);
      BlockPos blockPos = this.getBlockPos();
      BlockPos.Mutable mutable = new BlockPos.Mutable();
      UnmodifiableIterator var6 = passenger.getPoses().iterator();

      while (var6.hasNext()) {
        EntityPose entityPose = (EntityPose) var6.next();
        Box box = passenger.getBoundingBox(entityPose);
        int[][] var9 = is;
        int var10 = is.length;

        for (int var11 = 0; var11 < var10; ++var11) {
          int[] js = var9[var11];
          mutable.set(blockPos.getX() + js[0], blockPos.getY(), blockPos.getZ() + js[1]);
          double d = this.getWorld().getDismountHeight(mutable);
          if (Dismounting.canDismountInBlock(d)) {
            Vec3d vec3d = Vec3d.ofCenter(mutable, d);
            if (Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) {
              passenger.setPose(entityPose);
              return vec3d;
            }
          }
        }
      }

      return super.updatePassengerForDismount(passenger);
    }
  }

  @Override
  protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
    this.setRotation(controllingPlayer.getYaw(), controllingPlayer.getPitch() * 0.5f);
    this.lastYaw = this.bodyYaw = this.headYaw = this.getYaw();
    this.saddledComponent.tickBoost();
    super.tickControlled(controllingPlayer, movementInput);

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

  @Override
  public boolean consumeOnAStickItem() {
    return this.saddledComponent.boost(this.getRandom());
  }
}