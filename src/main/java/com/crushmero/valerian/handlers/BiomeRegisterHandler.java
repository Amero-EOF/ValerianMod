package com.crushmero.valerian.handlers;

import com.crushmero.valerian.ExampleMod;
import com.crushmero.valerian.world.BiomeGeneratorBase;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class BiomeRegisterHandler {

	@SubscribeEvent
	public static void registerBiomesEvent(RegistryEvent.Register<Biome> event) {
		for (BiomeGeneratorBase biome : ExampleMod.biomesList) {
			event.getRegistry().register(biome);
		}
	}
}
