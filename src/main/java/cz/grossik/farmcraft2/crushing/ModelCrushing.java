package cz.grossik.farmcraft2.crushing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCrushing extends ModelBase
{
	ModelRenderer spodek;
	ModelRenderer stena1;
	ModelRenderer stena2;
	ModelRenderer stena3;
	ModelRenderer stena4;
	ModelRenderer drtic1;
	ModelRenderer drtic2;
	ModelRenderer drtic3;
	ModelRenderer drtic4;
    ModelRenderer drtic5;
    public ModelRenderer Shape1;
  
  public ModelCrushing()
  {
	  this.textureWidth = 128;
	  this.textureHeight = 256;
	    
	  this.spodek = new ModelRenderer(this, 34, 0);
	  this.spodek.addBox(0F, 0F, 0F, 16, 1, 16);
	  this.spodek.setRotationPoint(-8F, 23F, -8F);
	  this.spodek.setTextureSize(128, 256);
	  this.spodek.mirror = true;
	  setRotation(this.spodek, 0F, 0F, 0F);
	  this.stena1 = new ModelRenderer(this, 0, 27);
	  this.stena1.addBox(0F, 0F, 0F, 16, 8, 1);
	  this.stena1.setRotationPoint(-8F, 15F, -8F);
	  this.stena1.setTextureSize(128, 256);
	  this.stena1.mirror = true;
	  setRotation(this.stena1, 0F, 0F, 0F);
	  this.stena2 = new ModelRenderer(this, 0, 39);
	  this.stena2.addBox(0F, 0F, 0F, 1, 8, 16);
	  this.stena2.setRotationPoint(-8F, 15F, -8F);
	  this.stena2.setTextureSize(128, 256);
	  this.stena2.mirror = true;
	  setRotation(this.stena2, 0F, 0F, 0F);
	  this.stena3 = new ModelRenderer(this, 0, 66);
	  this.stena3.addBox(0F, 0F, 0F, 1, 8, 16);
	  this.stena3.setRotationPoint(7F, 15F, -8F);
	  this.stena3.setTextureSize(128, 256);
	  this.stena3.mirror = true;
	  setRotation(this.stena3, 0F, 0F, 0F);
	  this.stena4 = new ModelRenderer(this, 0, 0);
	  this.stena4.addBox(0F, 0F, 0F, 16, 8, 1);
	  this.stena4.setRotationPoint(-8F, 15F, 7F);
	  this.stena4.setTextureSize(128, 256);
	  this.stena4.mirror = true;
	  setRotation(this.stena4, 0F, 0F, 0F);
	  this.drtic1 = new ModelRenderer(this, 0, 93);
	  this.drtic1.addBox(0F, 0F, 0F, 1, 7, 1);
	  this.drtic1.setRotationPoint(-8F, 8F, 7F);
	  this.drtic1.setTextureSize(128, 256);
	  this.drtic1.mirror = true;
	  setRotation(this.drtic1, 0F, 0F, 0F);
	  this.drtic2 = new ModelRenderer(this, 4, 93);
	  this.drtic2.addBox(0F, 0F, 0F, 1, 7, 1);
	  this.drtic2.setRotationPoint(7F, 8F, 7F);
	  this.drtic2.setTextureSize(128, 256);
	  this.drtic2.mirror = true;
	  setRotation(this.drtic2, 0F, 0F, 0F);
	  this.drtic3 = new ModelRenderer(this, 8, 93);
	  this.drtic3.addBox(0F, 0F, 0F, 1, 7, 1);
	  this.drtic3.setRotationPoint(-8F, 8F, -8F);
	  this.drtic3.setTextureSize(128, 256);
	  this.drtic3.mirror = true;
	  setRotation(this.drtic3, 0F, 0F, 0F);
	  this.drtic4 = new ModelRenderer(this, 12, 93);
	  this.drtic4.addBox(0F, 0F, 0F, 1, 7, 1);
	  this.drtic4.setRotationPoint(7F, 8F, -8F);
	  this.drtic4.setTextureSize(128, 256);
	  this.drtic4.mirror = true;
	  setRotation(this.drtic4, 0F, 0F, 0F);
	  this.drtic5 = new ModelRenderer(this, 0, 104);
	  this.drtic5.addBox(0F, 0F, 0F, 16, 4, 16);
	  this.drtic5.setRotationPoint(-8F, 6F, -8F);
	  this.drtic5.setTextureSize(128, 256);
	  this.drtic5.mirror = true;
	  setRotation(this.drtic5, 0F, 0F, 0F);
	  this.Shape1 = new ModelRenderer(this, 0, 126);
	  this.Shape1.addBox(0F, 0F, 0F, 14, 1, 14);
	  this.Shape1.setRotationPoint(-7F, 10F, -7F);
	  this.Shape1.setTextureSize(128, 256);
	  this.Shape1.mirror = true;
	  setRotation(this.Shape1, 0F, 0F, 0F);
  }
  
  public void render(TileEntityCrushing te, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
    this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, te);
	float f5 = 0.0625F;
	this.Shape1.render(f5);
	this.drtic5.render(f5);
	this.drtic4.render(f5);
	this.drtic3.render(f5);
	this.drtic2.render(f5);
	this.drtic1.render(f5);
	this.stena4.render(f5);
	this.stena3.render(f5);
	this.stena2.render(f5);
	this.stena1.render(f5);
	this.spodek.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  private void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, TileEntityCrushing entityIn)
  {	  
	  Shape1.offsetY = (float) Math.toRadians(entityIn.getMeatRotation());	       
  }
}