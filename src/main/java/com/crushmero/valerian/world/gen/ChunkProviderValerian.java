package com.crushmero.valerian.world.gen;

import java.util.List;
import java.util.Random;

import com.crushmero.valerian.utils.SchemLoader;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.world.ChunkProviderBase;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.template.Template;

public class ChunkProviderValerian extends ChunkProviderBase{

	
    private final Random rand;

    private final World world;

    public ChunkProviderValerian(World par1World, long par2, boolean par4)
    {
        this.rand = new Random(par2);
        this.world = par1World;
    }
	
	@Override
	public Chunk generateChunk(int x, int z) {
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		
		final Chunk newChunk = new Chunk(this.world, chunkPrimer, x, z);
		
		final byte biomeId = (byte) Biome.getIdForBiome( BiomeAdaptive.biomeDefault );
		final byte[] biomeArray = newChunk.getBiomeArray();
		
		
		for (int i = 0; i < biomeArray.length; ++i)
        {
            biomeArray[i] = biomeId;
        }

		newChunk.generateSkylightMap();
		// TODO Auto-generated method stub
		return newChunk;
	}

	@Override
	public void populate(int x, int z) {
		// TODO Auto-generated method stub
		
		BlockFalling.fallInstantly = true;
        final int k = x * 16;
        final int l = z * 16;
        this.rand.setSeed(this.world.getSeed());
        final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(x * i1 + z * j1 ^ this.world.getSeed());
        if (k == 0 && l == 0) {
        	
        	Template station = SchemLoader.schemLoad("a_block.schematic");
        	new WorldGenValerianStation(station).generate(this.world, this.rand, new BlockPos(k - 10, 62, l - 3));
        }
		
		
		BlockFalling.fallInstantly = false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		
	}

}
