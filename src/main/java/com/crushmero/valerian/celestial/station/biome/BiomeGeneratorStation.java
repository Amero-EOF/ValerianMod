package com.crushmero.valerian.celestial.station.biome;

import com.crushmero.valerian.ExampleMod;

public class BiomeGeneratorStation extends ValerianStationBiomes {

	public BiomeGeneratorStation() {
		super(new BiomeProperties("Valerian Station").setRainfall(0.0F).setRainDisabled());
		this.setRegistryName("valerian_station");
		ExampleMod.biomesList.add(this);
	}
}
