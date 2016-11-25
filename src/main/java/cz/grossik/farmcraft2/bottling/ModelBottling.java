package cz.grossik.farmcraft2.bottling;

import cz.grossik.farmcraft2.crushing.TileEntityCrushing;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBottling extends ModelBase
{
  //fields
    ModelRenderer dole;
    ModelRenderer j1;
    ModelRenderer j2;
    ModelRenderer j3;
    ModelRenderer j4;
    ModelRenderer nahore;
    ModelRenderer staceni;
    ModelRenderer staceni2;
    ModelRenderer staceni3;
    ModelRenderer staceni4;
  
  public ModelBottling()
  {
    textureWidth = 256;
    textureHeight = 256;
    
    dole = new ModelRenderer(this, 0, 77);
    dole.addBox(0F, 0F, 0F, 32, 1, 32);
    dole.setRotationPoint(-16F, 23F, -16F);
    dole.setTextureSize(256, 256);
    dole.mirror = true;
    setRotation(dole, 0F, 0F, 0F);
    j1 = new ModelRenderer(this, 0, 44);
    j1.addBox(0F, 0F, 0F, 2, 30, 2);
    j1.setRotationPoint(14F, -7F, 14F);
    j1.setTextureSize(256, 256);
    j1.mirror = true;
    setRotation(j1, 0F, 0F, 0F);
    j2 = new ModelRenderer(this, 9, 44);
    j2.addBox(0F, 0F, 0F, 2, 30, 2);
    j2.setRotationPoint(14F, -7F, -16F);
    j2.setTextureSize(256, 256);
    j2.mirror = true;
    setRotation(j2, 0F, 0F, 0F);
    j3 = new ModelRenderer(this, 18, 44);
    j3.addBox(0F, 0F, 0F, 2, 30, 2);
    j3.setRotationPoint(-16F, -7F, 14F);
    j3.setTextureSize(256, 256);
    j3.mirror = true;
    setRotation(j3, 0F, 0F, 0F);
    j4 = new ModelRenderer(this, 28, 43);
    j4.addBox(0F, 0F, 0F, 2, 30, 2);
    j4.setRotationPoint(-16F, -7F, -16F);
    j4.setTextureSize(256, 256);
    j4.mirror = true;
    setRotation(j4, 0F, 0F, 0F);
    nahore = new ModelRenderer(this, 0, 0);
    nahore.addBox(0F, 0F, 0F, 32, 12, 32);
    nahore.setRotationPoint(-16F, -8F, -16F);
    nahore.setTextureSize(256, 256);
    nahore.mirror = true;
    setRotation(nahore, 0F, 0F, 0F);
    staceni = new ModelRenderer(this, 0, 111);
    staceni.addBox(0F, 0F, 0F, 1, 4, 1);
    staceni.setRotationPoint(0F, 4F, 1F);
    staceni.setTextureSize(256, 256);
    staceni.mirror = true;
    setRotation(staceni, 0F, 0F, 0F);
    staceni2 = new ModelRenderer(this, 5, 111);
    staceni2.addBox(0F, 0F, 0F, 1, 4, 1);
    staceni2.setRotationPoint(0F, 4F, -1F);
    staceni2.setTextureSize(256, 256);
    staceni2.mirror = true;
    setRotation(staceni2, 0F, 0F, 0F);
    staceni3 = new ModelRenderer(this, 11, 111);
    staceni3.addBox(0F, 0F, 0F, 1, 4, 1);
    staceni3.setRotationPoint(1F, 4F, 0F);
    staceni3.setTextureSize(256, 256);
    staceni3.mirror = true;
    setRotation(staceni3, 0F, 0F, 0F);
    staceni4 = new ModelRenderer(this, 18, 111);
    staceni4.addBox(0F, 0F, 0F, 1, 4, 1);
    staceni4.setRotationPoint(-1F, 4F, 0F);
    staceni4.setTextureSize(256, 256);
    staceni4.mirror = true;
    setRotation(staceni4, 0F, 0F, 0F);
  }
  
  public void render(TileEntityBottling te, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
	this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, te);
	float f5 = 0.0625F;
    dole.render(f5);
    j1.render(f5);
    j2.render(f5);
    j3.render(f5);
    j4.render(f5);
    nahore.render(f5);
    staceni.render(f5);
    staceni2.render(f5);
    staceni3.render(f5);
    staceni4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  private double angle;
  private int state;
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, TileEntityBottling entityIn)
  {
  }
}
