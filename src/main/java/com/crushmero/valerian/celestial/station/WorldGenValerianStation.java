package com.crushmero.valerian.celestial.station;

import java.util.Random;

import com.crushmero.valerian.ExampleMod;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class WorldGenValerianStation extends WorldGenerator
{
	private Template schematic;
	public WorldGenValerianStation(Template schem) {
		schematic = schem;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		PlacementSettings settings = new PlacementSettings();
		
		schematic.addBlocksToWorld(worldIn, position, settings);
		
//		for (int x=0; x< schemSize.getX(); x++) {
//			for (int y=0; y<schemSize.getY(); y++) {
//				for (int z=0; z<schemSize.getZ(); z++) {
//					
//				}
//			}
//		}
		ExampleMod.logger.info("THIS IS RUNNING AT ALL TIMES");
		return true;
	}

}
