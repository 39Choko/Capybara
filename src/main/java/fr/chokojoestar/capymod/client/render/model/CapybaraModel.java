package fr.chokojoestar.capymod.client.render.model;

import java.util.Optional;

import fr.chokojoestar.capymod.client.render.animation.CapybaraAnimations;
import fr.chokojoestar.capymod.client.render.state.CapybaraEntityRenderState;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;

public class CapybaraModel extends EntityModel<CapybaraEntityRenderState> {
	private final ModelPart saddle;

	public CapybaraModel(ModelPart root) {
		super(root);
		this.saddle = root.getChild("saddle");
	}

	@SuppressWarnings("unused")
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData legs = modelPartData.addChild("legs", ModelPartBuilder.create(),ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData leg1 = legs.addChild("leg1",ModelPartBuilder.create().uv(20, 44).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)),ModelTransform.pivot(-3.5F, -6.0F, -6.5F));
		ModelPartData leg2 = legs.addChild("leg2",ModelPartBuilder.create().uv(20, 53).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)),ModelTransform.pivot(3.5F, -6.0F, -6.5F));
		ModelPartData leg3 = legs.addChild("leg3",ModelPartBuilder.create().uv(32, 53).cuboid(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)),ModelTransform.pivot(-3.5F, -3.0F, 6.5F));
		ModelPartData leg4 = legs.addChild("leg4",ModelPartBuilder.create().uv(44, 53).cuboid(-1.5F, -3.0F, -1.375F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)),ModelTransform.pivot(3.5F, -3.0F, 6.375F));
		ModelPartData body = modelPartData.addChild("body",ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -4.5F, -9.0F, 10.0F, 9.0F, 18.0F, new Dilation(0.0F)),ModelTransform.pivot(0.0F, 13.5F, 0.0F));
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(),ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData ear1 = head.addChild("ear1", ModelPartBuilder.create(),ModelTransform.pivot(3.7281F, -19.5239F, -6.4422F));
		ModelPartData ear1_r1 = ear1.addChild("ear1_r1",ModelPartBuilder.create().uv(56, 0).cuboid(-1.25F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)),ModelTransform.of(0.7153F, -0.0745F, 0.0F, 0.0F, 0.0F, 0.3054F));
		ModelPartData ear2 = head.addChild("ear2", ModelPartBuilder.create(),ModelTransform.pivot(-3.7642F, -19.9097F, -6.4422F));
		ModelPartData ear2_r1 = ear2.addChild("ear2_r1",ModelPartBuilder.create().uv(56, 4).cuboid(0.25F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)),ModelTransform.of(-0.7153F, 0.2255F, 0.0F, 0.0F, 0.0F, -0.3054F));
		ModelPartData head1 = head.addChild("head1",ModelPartBuilder.create().uv(0, 27).cuboid(-4.0F, -3.5F, -5.0F, 8.0F, 7.0F, 10.0F, new Dilation(0.0F)),ModelTransform.pivot(0.0F, -16.5F, -10.0F));
		ModelPartData saddle = modelPartData.addChild("saddle",ModelPartBuilder.create().uv(36, 27).cuboid(-5.5F, -2.9167F, -4.0F, 11.0F, 1.0F, 9.0F, new Dilation(0.0F)).uv(36, 37).cuboid(4.5F, -2.1667F, -4.0F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)).uv(0, 44).cuboid(-5.5F, -2.1667F, -4.0F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)),ModelTransform.pivot(0.0F, 11.6667F, 1.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(CapybaraEntityRenderState state) {
		super.setAngles(state);
		this.updateVisibleParts(state);
		this.animateWalking(CapybaraAnimations.WALKING, state.limbFrequency, state.limbAmplitudeMultiplier, 2.0F, 2.5F);
		this.animate(state.sittingAnimationState, CapybaraAnimations.SITTING, state.age, 1.0F);
		this.animate(state.idlingAnimationState, CapybaraAnimations.IDLING, state.age, 1.0F);
	}

	@Override
	public Optional<ModelPart> getPart(String name) {
		return super.getPart(name);
	}

	private void updateVisibleParts(CapybaraEntityRenderState state) {
		boolean isSaddled = state.saddle;
		ModelPart saddles = this.saddle;
		saddles.visible = isSaddled;
	}
}