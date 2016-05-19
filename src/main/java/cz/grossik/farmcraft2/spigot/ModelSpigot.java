package cz.grossik.farmcraft2.spigot;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpigot extends ModelBase
{
    ModelRenderer pipa;
    ModelRenderer pipa1;
    ModelRenderer pipa2;
    ModelRenderer pipa3;
    ModelRenderer pipa4;
    ModelRenderer pipa5;
    ModelRenderer pipa6;
    ModelRenderer pipa7;
    ModelRenderer pipa8;
    ModelRenderer pipa9;
    ModelRenderer pipa10;
  
  public ModelSpigot()
  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      pipa = new ModelRenderer(this, 34, 24);
	      pipa.addBox(0F, 0F, 0F, 7, 1, 7);
	      pipa.setRotationPoint(-3.5F, 23F, -7F);
	      pipa.setTextureSize(64, 32);
	      pipa.mirror = true;
	      setRotation(pipa, 0F, 0F, 0F);
	      pipa1 = new ModelRenderer(this, 0, 0);
	      pipa1.addBox(0F, 0F, 0F, 9, 17, 8);
	      pipa1.setRotationPoint(-4.5F, 7F, 0F);
	      pipa1.setTextureSize(64, 32);
	      pipa1.mirror = true;
	      setRotation(pipa1, 0F, 0F, 0F);
	      pipa2 = new ModelRenderer(this, 34, 0);
	      pipa2.addBox(0F, 0F, 0F, 1, 1, 3);
	      pipa2.setRotationPoint(-0.5F, 10F, -3F);
	      pipa2.setTextureSize(64, 32);
	      pipa2.mirror = true;
	      setRotation(pipa2, 0F, 0F, 0F);
	      pipa3 = new ModelRenderer(this, 34, 4);
	      pipa3.addBox(0F, 0F, 0F, 1, 1, 3);
	      pipa3.setRotationPoint(0.5F, 11F, -3F);
	      pipa3.setTextureSize(64, 32);
	      pipa3.mirror = true;
	      setRotation(pipa3, 0F, 0F, 0F);
	      pipa4 = new ModelRenderer(this, 34, 8);
	      pipa4.addBox(0F, 0F, 0F, 1, 1, 3);
	      pipa4.setRotationPoint(-1.5F, 11F, -3F);
	      pipa4.setTextureSize(64, 32);
	      pipa4.mirror = true;
	      setRotation(pipa4, 0F, 0F, 0F);
	      pipa5 = new ModelRenderer(this, 34, 12);
	      pipa5.addBox(0F, 0F, 0F, 1, 1, 3);
	      pipa5.setRotationPoint(-0.5F, 12F, -3F);
	      pipa5.setTextureSize(64, 32);
	      pipa5.mirror = true;
	      setRotation(pipa5, 0F, 0F, 0F);
	      pipa6 = new ModelRenderer(this, 42, 0);
	      pipa6.addBox(0F, 0F, 0F, 1, 5, 1);
	      pipa6.setRotationPoint(-0.5F, 10F, -5F);
	      pipa6.setTextureSize(64, 32);
	      pipa6.mirror = true;
	      setRotation(pipa6, 0F, 0F, 0F);
	      pipa7 = new ModelRenderer(this, 42, 6);
	      pipa7.addBox(0F, 0F, 0F, 1, 5, 1);
	      pipa7.setRotationPoint(0.5F, 10F, -4F);
	      pipa7.setTextureSize(64, 32);
	      pipa7.mirror = true;
	      setRotation(pipa7, 0F, 0F, 0F);
	      pipa8 = new ModelRenderer(this, 42, 12);
	      pipa8.addBox(0F, 0F, 0F, 1, 5, 1);
	      pipa8.setRotationPoint(-1.5F, 10F, -4F);
	      pipa8.setTextureSize(64, 32);
	      pipa8.mirror = true;
	      setRotation(pipa8, 0F, 0F, 0F);
	      pipa9 = new ModelRenderer(this, 34, 16);
	      pipa9.addBox(0F, 0F, 0F, 1, 3, 1);
	      pipa9.setRotationPoint(-0.5F, 7F, -4F);
	      pipa9.setTextureSize(64, 32);
	      pipa9.mirror = true;
	      setRotation(pipa9, 0F, 0F, 0F);
	      pipa10 = new ModelRenderer(this, 34, 20);
	      pipa10.addBox(0F, 0F, 0F, 1, 3, 1);
	      pipa10.setRotationPoint(0F, 12F, -3F);
	      pipa10.setTextureSize(64, 32);
	      pipa10.mirror = true;
	      setRotation(pipa10, 0F, 0F, 0F);
  }
  
  public void render()
  {
	float f5 = 0.0625F;
    pipa.render(f5);
    pipa1.render(f5);
    pipa2.render(f5);
    pipa3.render(f5);
    pipa4.render(f5);
    pipa5.render(f5);
    pipa6.render(f5);
    pipa7.render(f5);
    pipa8.render(f5);
    pipa9.render(f5);
    pipa10.render(f5);

  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}