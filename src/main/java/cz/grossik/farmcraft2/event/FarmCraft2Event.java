package cz.grossik.farmcraft2.event;

import java.util.Random;

import cz.grossik.farmcraft2.goat.EntityGoat;
import cz.grossik.farmcraft2.handler.ItemHandler;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FarmCraft2Event {
		
    public Random r = new Random();
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) 
	{		
		if (event.getEntityLiving() instanceof EntityPig)
		{
			event.getEntityLiving().dropItem(ItemHandler.Ham, r.nextInt(2));
		}
		
		if (event.getEntityLiving() instanceof EntityCow)
		{
			event.getEntityLiving().dropItem(ItemHandler.Ham, r.nextInt(2));
		}
	}
}
