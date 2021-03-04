package com.crushmero.valerian.celestial.station;

import com.crushmero.valerian.celestial.station.biome.BiomeDecoratorStation;
import com.crushmero.valerian.celestial.station.biome.ValerianStationBiomes;
import com.crushmero.valerian.world.BiomeDecoratorBase;
import com.crushmero.valerian.world.ChunkProviderEmpty;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

@SuppressWarnings("deprecation")
public class ChunkProviderValerianStation extends ChunkProviderEmpty {
	
	private final BiomeDecoratorStation biomeDecorator = new BiomeDecoratorStation();

	public ChunkProviderValerianStation(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorBase getBiomeGenerator() {
		return this.biomeDecorator;
	}

	@Override
	protected Biome[] getBiomesForGeneration() {
		return new Biome[] { ValerianStationBiomes.VALERIAN_STATION };
	}

	@Override
	protected int getSeaLevel() {
		return 64;
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(Blocks.AIR, (byte) 1);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(Blocks.AIR, (byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(Blocks.AIR, (byte) 1);
	}

	@Override
	public double getHeightModifier() {
		return 12;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 26;
	}

	@Override
	public double getMountainHeightModifier() {
		return 95;
	}

	@Override
	public double getValleyHeightModifier() {
		return 50;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		
	}

}
