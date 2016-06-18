package cz.grossik.farmcraft2.crushing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

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
    ModelRenderer Shape1;
  
  public ModelCrushing()
  {
	  textureWidth = 128;
	    textureHeight = 256;
	    
	      spodek = new ModelRenderer(this, 34, 0);
	      spodek.addBox(0F, 0F, 0F, 16, 1, 16);
	      spodek.setRotationPoint(-8F, 23F, -8F);
	      spodek.setTextureSize(128, 256);
	      spodek.mirror = true;
	      setRotation(spodek, 0F, 0F, 0F);
	      stena1 = new ModelRenderer(this, 0, 27);
	      stena1.addBox(0F, 0F, 0F, 16, 8, 1);
	      stena1.setRotationPoint(-8F, 15F, -8F);
	      stena1.setTextureSize(128, 256);
	      stena1.mirror = true;
	      setRotation(stena1, 0F, 0F, 0F);
	      stena2 = new ModelRenderer(this, 0, 39);
	      stena2.addBox(0F, 0F, 0F, 1, 8, 16);
	      stena2.setRotationPoint(-8F, 15F, -8F);
	      stena2.setTextureSize(128, 256);
	      stena2.mirror = true;
	      setRotation(stena2, 0F, 0F, 0F);
	      stena3 = new ModelRenderer(this, 0, 66);
	      stena3.addBox(0F, 0F, 0F, 1, 8, 16);
	      stena3.setRotationPoint(7F, 15F, -8F);
	      stena3.setTextureSize(128, 256);
	      stena3.mirror = true;
	      setRotation(stena3, 0F, 0F, 0F);
	      stena4 = new ModelRenderer(this, 0, 0);
	      stena4.addBox(0F, 0F, 0F, 16, 8, 1);
	      stena4.setRotationPoint(-8F, 15F, 7F);
	      stena4.setTextureSize(128, 256);
	      stena4.mirror = true;
	      setRotation(stena4, 0F, 0F, 0F);
	      drtic1 = new ModelRenderer(this, 0, 93);
	      drtic1.addBox(0F, 0F, 0F, 1, 7, 1);
	      drtic1.setRotationPoint(-8F, 8F, 7F);
	      drtic1.setTextureSize(128, 256);
	      drtic1.mirror = true;
	      setRotation(drtic1, 0F, 0F, 0F);
	      drtic2 = new ModelRenderer(this, 4, 93);
	      drtic2.addBox(0F, 0F, 0F, 1, 7, 1);
	      drtic2.setRotationPoint(7F, 8F, 7F);
	      drtic2.setTextureSize(128, 256);
	      drtic2.mirror = true;
	      setRotation(drtic2, 0F, 0F, 0F);
	      drtic3 = new ModelRenderer(this, 8, 93);
	      drtic3.addBox(0F, 0F, 0F, 1, 7, 1);
	      drtic3.setRotationPoint(-8F, 8F, -8F);
	      drtic3.setTextureSize(128, 256);
	      drtic3.mirror = true;
	      setRotation(drtic3, 0F, 0F, 0F);
	      drtic4 = new ModelRenderer(this, 12, 93);
	      drtic4.addBox(0F, 0F, 0F, 1, 7, 1);
	      drtic4.setRotationPoint(7F, 8F, -8F);
	      drtic4.setTextureSize(128, 256);
	      drtic4.mirror = true;
	      setRotation(drtic4, 0F, 0F, 0F);
	      drtic5 = new ModelRenderer(this, 0, 104);
	      drtic5.addBox(0F, 0F, 0F, 16, 4, 16);
	      drtic5.setRotationPoint(-8F, 6F, -8F);
	      drtic5.setTextureSize(128, 256);
	      drtic5.mirror = true;
	      setRotation(drtic5, 0F, 0F, 0F);
	      Shape1 = new ModelRenderer(this, 0, 126);
	      Shape1.addBox(0F, 0F, 0F, 14, 1, 14);
	      Shape1.setRotationPoint(-7F, 10F, -7F);
	      Shape1.setTextureSize(128, 256);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render()
  {
	float f5 = 0.0625F;
    Shape1.render(f5);
    drtic5.render(f5);
    drtic4.render(f5);
    drtic3.render(f5);
    drtic2.render(f5);
    drtic1.render(f5);
    stena4.render(f5);
    stena3.render(f5);
    stena2.render(f5);
    stena1.render(f5);
    spodek.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}