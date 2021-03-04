package com.crushmero.valerian.celestial.station;

import com.crushmero.valerian.celestial.station.biome.ValerianStationBiomes;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeProviderSpace;
import net.minecraft.world.biome.Biome;

public class BiomeProviderStation extends BiomeProviderSpace {
	
	@Override
	public Biome getBiome() {
		return ValerianStationBiomes.VALERIAN_STATION;
	}
}
