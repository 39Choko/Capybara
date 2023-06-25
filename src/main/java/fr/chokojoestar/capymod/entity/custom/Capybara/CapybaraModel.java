package fr.chokojoestar.capymod.entity.custom.Capybara;

import fr.chokojoestar.capymod.Register;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CapybaraModel extends GeoModel<CapybaraEntity> {

  @Override
  public Identifier getModelResource(CapybaraEntity animatable) {
    return Register.registerLocation("geo", "capybara.geo.json");
  }

  @Override
  public Identifier getTextureResource(CapybaraEntity animatable) {
    return Register.registerLocation("textures/entity", "capybara.png");
  }

  @Override
  public Identifier getAnimationResource(CapybaraEntity animatable) {
    return Register.registerLocation("animations", "capybara.animation.json");
  }
}
