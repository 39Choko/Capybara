package fr.chokojoestar.capymod.entity.custom.Capybara;

import com.google.common.collect.Sets;
import fr.chokojoestar.capymod.entity.CapyEntities;
import fr.chokojoestar.capymod.item.CapyItems;
import java.util.Set;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
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
import net.minecraft.world.EntityView;
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

public class CapybaraEntity extends TameableEntity implements GeoEntity {

  private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.MELON_SLICE, Items.CARROT);
  private static final Set<Item> SITS = Sets.newHashSet(Items.STICK, Items.BAMBOO, CapyItems.STAFF);
  private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

  public CapybaraEntity(EntityType<? extends TameableEntity> entityType, World world) {
    super(entityType, world);
  }

  public static DefaultAttributeContainer.Builder createCapybaraAttributes() {
    return TameableEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(0, new SitGoal(this));
    this.goalSelector.add(1, new EscapeDangerGoal(this, 1.5));
    this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
    this.goalSelector.add(3, new TemptGoal(this, 1.1, BREEDING_INGREDIENT, false));
    this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
    this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
    this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
    this.goalSelector.add(7, new LookAroundGoal(this));
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    ItemStack itemStack = player.getStackInHand(hand);
    Item item = itemStack.getItem();

    /* TAMING SYSTEM */
    if (!this.isTamed() && isBreedingItem(itemStack)) {
      decrementItem(player, itemStack, 1);
      if (!this.getWorld().isClient()) {
        if (this.random.nextInt(10) == 0) {
          this.setOwner(player);
          this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        } else {
          this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
        }
      }
      return ActionResult.SUCCESS;
    }

    if (this.isTamed() && this.isOwner(player)) {
      /* REGEN SYSTEM */
      if (isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
        decrementItem(player, itemStack, 1);
        this.heal(item.getFoodComponent().getHunger());
        return ActionResult.SUCCESS;
      }

      /* RIDING SYSTEM */
      if (!SITS.contains(item) && !isBreedingItem(itemStack)) {
        if (!this.getWorld().isClient())
          player.startRiding(this);
        return ActionResult.SUCCESS;
      }

      /* SITTING SYSTEM */
      if (!isBreedingItem(itemStack) && SITS.contains(item)) {
        if (item == Items.STICK || item == Items.BAMBOO)
          decrementItem(player, itemStack, 1);

        if (!this.getWorld().isClient()) {
          this.setSitting(!this.isSitting());
        }
        return ActionResult.SUCCESS;
      }
    }

    return super.interactMob(player, hand);
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return BREEDING_INGREDIENT.test(stack);
  }

  public void decrementItem(PlayerEntity player, ItemStack itemStack, int amount) {
    if (!player.getAbilities().creativeMode) {
      itemStack.decrement(amount);
    }
  }

  @Override
  public void registerControllers(ControllerRegistrar controllerRegistrar) {
    controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
  }

  private PlayState predicate(AnimationState<?> state) {
    if (state.isMoving()) {
      state.getController().setAnimation(RawAnimation.begin().then("animation.capybara.walk", Animation.LoopType.LOOP));
      return PlayState.CONTINUE;
    }

    if (this.isInSittingPose()) {
      state.getController()
          .setAnimation(RawAnimation.begin().then("animation.capybara.seat", Animation.LoopType.HOLD_ON_LAST_FRAME));
      return PlayState.CONTINUE;
    }

    state.getController().setAnimation(RawAnimation.begin().then("animation.capybara.idle", Animation.LoopType.LOOP));
    return PlayState.CONTINUE;
  }

  @Override
  public EntityView method_48926() {
    return this.getWorld();
  }

  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return CapyEntities.CAPYBARA.create(world);
  }

  @Override
  public AnimatableInstanceCache getAnimatableInstanceCache() {
    return cache;
  }
}
