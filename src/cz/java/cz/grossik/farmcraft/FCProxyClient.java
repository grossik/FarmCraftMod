package cz.grossik.farmcraft;

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.ResourceLocation;

public class FCProxyClient extends FCProxyCommon {

    @Override
    public void initSounds() {

    }

    @Override
    public void initRenderers() {

    }

    @Override
    public void registerRenderer() {
        VillagerRegistry.instance().registerVillagerSkin(69699, new ResourceLocation("minecraft", "textures/mob/fcvillager.png"));

    }

}
