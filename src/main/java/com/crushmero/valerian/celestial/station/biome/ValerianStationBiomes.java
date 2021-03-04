package com.crushmero.valerian.celestial.station.biome;

import com.crushmero.valerian.world.BiomeGeneratorBase;

public class ValerianStationBiomes extends BiomeGeneratorBase {

	public static final BiomeGeneratorStation VALERIAN_STATION = new BiomeGeneratorStation();
	
	ValerianStationBiomes(BiomeProperties properties) {
		super(properties);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
