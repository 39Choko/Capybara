package fr.chokojoestar.capymod.client.render.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.SaddleableRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class CapybaraEntityRenderState extends LivingEntityRenderState implements SaddleableRenderState{
   public boolean saddle;
   public final AnimationState idlingAnimationState = new AnimationState();
   public final AnimationState sittingAnimationState = new AnimationState();

   public CapybaraEntityRenderState(){}

   @Override
   public boolean isSaddled() {
      return this.saddle;
   }
}
