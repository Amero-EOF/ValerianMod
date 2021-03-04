package com.crushmero.valerian.init;

import com.crushmero.valerian.Configs;
import com.crushmero.valerian.celestial.station.WorldProviderValerian;

import net.minecraft.world.DimensionType;

public class ValDimensions {
	
	public static DimensionType VAlERIAN_SPACE_STATION = DimensionType.register("valerian_station", "Valerian Station", Configs.STATION_DIM_ID, WorldProviderValerian.class, false);

}
