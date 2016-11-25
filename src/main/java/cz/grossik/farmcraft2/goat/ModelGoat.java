package cz.grossik.farmcraft2.goat;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGoat extends ModelBase
{
  //fields
    ModelRenderer Telo;
    ModelRenderer Noha4;
    ModelRenderer Noha1;
    ModelRenderer Noha2;
    ModelRenderer Noha3;
    ModelRenderer Vemeno;
    ModelRenderer Ocas;
    ModelRenderer Krk;
    ModelRenderer hlava;
    ModelRenderer roh1;
    ModelRenderer roh2;
    public int tailMov;

  public ModelGoat()
  {
    textureWidth = 64;
    textureHeight = 64;
    
    Telo = new ModelRenderer(this, 0, 0);
    Telo.addBox(0F, 0F, 0F, 16, 8, 6);
    Telo.setRotationPoint(-8F, 9F, -3F);
    Telo.setTextureSize(64, 64);
    Telo.mirror = true;
    setRotation(Telo, 0F, 0F, 0F);
    Noha4 = new ModelRenderer(this, 24, 14);
    Noha4.addBox(-1F, 0F, -1F, 2, 7, 2);
    Noha4.setRotationPoint(6F, 17F, -2F);
    Noha4.setTextureSize(64, 64);
    Noha4.mirror = true;
    setRotation(Noha4, 0F, 0F, 0F);
    Noha1 = new ModelRenderer(this, 0, 14);
    Noha1.addBox(-1F, 0F, -1F, 2, 7, 2);
    Noha1.setRotationPoint(6F, 17F, 2F);
    Noha1.setTextureSize(64, 64);
    Noha1.mirror = true;
    setRotation(Noha1, 0F, 0F, 0F);
    Noha2 = new ModelRenderer(this, 8, 14);
    Noha2.addBox(-1F, 0F, -1F, 2, 7, 2);
    Noha2.setRotationPoint(-6F, 17F, 2F);
    Noha2.setTextureSize(64, 64);
    Noha2.mirror = true;
    setRotation(Noha2, 0F, 0F, 0F);
    Noha3 = new ModelRenderer(this, 16, 14);
    Noha3.addBox(-1F, 0F, -1F, 2, 7, 2);
    Noha3.setRotationPoint(-6F, 17F, -2F);
    Noha3.setTextureSize(64, 64);
    Noha3.mirror = true;
    setRotation(Noha3, 0F, 0F, 0F);
    Vemeno = new ModelRenderer(this, 0, 23);
    Vemeno.addBox(0F, 0F, 0F, 5, 1, 4);
    Vemeno.setRotationPoint(0F, 17F, -2F);
    Vemeno.setTextureSize(64, 64);
    Vemeno.mirror = true;
    setRotation(Vemeno, 0F, 0F, 0F);
    Ocas = new ModelRenderer(this, 44, 0);
    Ocas.addBox(0F, -3F, -1.5F, 2, 4, 3);
    Ocas.setRotationPoint(7F, 9F, 0F);
    Ocas.setTextureSize(64, 64);
    Ocas.mirror = true;
    setRotation(Ocas, 0F, 0F, 0F);
    Krk = new ModelRenderer(this, 0, 28);
    Krk.addBox(0F, 0F, 0F, 6, 4, 3);
    Krk.setRotationPoint(-12F, 7F, -1.5F);
    Krk.setTextureSize(64, 64);
    Krk.mirror = true;
    setRotation(Krk, 0F, 0F, 0.3141593F);
    hlava = new ModelRenderer(this, 0, 35);
    hlava.addBox(-4F, -3.5F, -3F, 4, 7, 6);
    hlava.setRotationPoint(-11F, 7.5F, 0F);
    hlava.setTextureSize(64, 64);
    hlava.mirror = true;
    setRotation(hlava, 0F, 0F, 0F);
    roh1 = new ModelRenderer(this, 24, 43);
    roh1.addBox(-4F, -7.5F, 2F, 1, 4, 1);
    roh1.setRotationPoint(-11F, 7.5F, 0F);
    roh1.setTextureSize(64, 64);
    roh1.mirror = true;
    setRotation(roh1, 0F, 0F, 0F);
    roh2 = new ModelRenderer(this, 20, 43);
    roh2.addBox(-4F, -7.5F, -3F, 1, 4, 1);
    roh2.setRotationPoint(-11F, 7.5F, 0F);
    roh2.setTextureSize(64, 64);
    roh2.mirror = true;
    setRotation(roh2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Telo.render(f5);
    Noha4.render(f5);
    Noha1.render(f5);
    Noha2.render(f5);
    Noha3.render(f5);
    Vemeno.render(f5);
    Ocas.render(f5);
    Krk.render(f5);
    hlava.render(f5);
    roh1.render(f5);
    roh2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.Noha1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Noha4.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Noha2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Noha3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    
    this.Ocas.rotateAngleZ = f4 / 57.29578f;

    this.hlava.rotateAngleX = f4 * 0.017453292F;
    this.hlava.rotateAngleY = f3 * 0.017453292F;
    this.roh1.rotateAngleX = this.hlava.rotateAngleX;
    this.roh2.rotateAngleX = this.hlava.rotateAngleX;
    this.roh1.rotateAngleY = this.hlava.rotateAngleY;
    this.roh2.rotateAngleY = this.hlava.rotateAngleY;
  }
}