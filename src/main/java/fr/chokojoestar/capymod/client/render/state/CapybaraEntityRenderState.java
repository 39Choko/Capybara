package fr.chokojoestar.capymod.client.render.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class CapybaraEntityRenderState extends LivingEntityRenderState {
  public final AnimationState idlingAnimationState = new AnimationState();
  public final AnimationState sittingAnimationState = new AnimationState();
  public ItemStack saddleStack;

  public CapybaraEntityRenderState() {
    this.saddleStack = ItemStack.EMPTY;
  }

}
