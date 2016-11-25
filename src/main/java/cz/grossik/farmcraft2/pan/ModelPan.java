package cz.grossik.farmcraft2.pan;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPan extends ModelBase
{
    private ModelRenderer pancakes;

    public ModelPan()
    {
        textureWidth = 128;
        textureHeight = 32;

        pancakes = new ModelRenderer(this, "pancakes");

        setTextureOffset("pancakes.jedna", 0, 0);     
        setTextureOffset("pancakes.dva", 32, 0);
        setTextureOffset("pancakes.tri", 0, 18);
        setTextureOffset("pancakes.ctyri", 0, 13);     
        setTextureOffset("pancakes.pet", 56, 0);
        setTextureOffset("pancakes.sest", 18, 18);
        setTextureOffset("pancakes.sedum", 10, 13);

        pancakes.addBox("jedna", 6, -3, -6, 4, 1, 12);   
        
        pancakes.addBox("dva",   4, -3, -5, 2, 1, 10);
        pancakes.addBox("tri",   3, -3, -4, 1, 1,  8);
        pancakes.addBox("ctyri", 2, -3, -2, 1, 1,  4);      
        
        pancakes.addBox("pet",   10, -3, -5, 2, 1, 10);
        pancakes.addBox("sest",  12, -3, -4, 1, 1,  8);
        
        pancakes.addBox("sedum", 13, -3, -2, 1, 1,  4);
    }

    public void render()
    {
        pancakes.render(1f / 16f);
    }
}