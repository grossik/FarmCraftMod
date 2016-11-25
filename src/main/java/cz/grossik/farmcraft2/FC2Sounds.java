package cz.grossik.farmcraft2;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FC2Sounds {

	public static SoundEvent kombajn;
	public static SoundEvent goat_ambient;
	public static SoundEvent tractor;
	
	public FC2Sounds(){
		init();
		register();
	}
	
	private void init(){
		kombajn = new SoundEvent(new ResourceLocation(Main.MODID, "kombajn")).setRegistryName(new ResourceLocation(Main.MODID, "kombajn"));
		goat_ambient = new SoundEvent(new ResourceLocation(Main.MODID, "goat_ambient")).setRegistryName(new ResourceLocation(Main.MODID, "goat_ambient"));
		tractor = new SoundEvent(new ResourceLocation(Main.MODID, "tractor")).setRegistryName(new ResourceLocation(Main.MODID, "tractor"));
	}
	
	private void register(){
		registerSounds(kombajn);
		registerSounds(goat_ambient);
		registerSounds(tractor);
	}
	
	private void registerSounds(SoundEvent event){
		GameRegistry.register(event);
	}
}
