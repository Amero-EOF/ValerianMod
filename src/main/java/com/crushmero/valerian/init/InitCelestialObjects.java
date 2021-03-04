package com.crushmero.valerian.init;



import com.crushmero.valerian.world.gen.WorldProviderValerian;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeSpaceStation;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import net.minecraft.util.ResourceLocation;

public class InitCelestialObjects {

	public static SolarSystem valerian = new SolarSystem("valerian","milky_way").setMapPosition(new Vector3(1.0,-1.0,0.0));;
	public static Star b245 = (Star) new Star("b245").setParentSolarSystem(valerian).setTierRequired(-1);
	public static Planet station = (Planet) new Planet("valerian_station");
	
	
	
	public InitCelestialObjects() {
		
		this.initStars();
		this.initSolarSystems();
		this.initStations();
		this.registerSolarSystems();
		
	}
	
	private void initStars() {
		b245.setBodyIcon(new ResourceLocation("valerian:celestialbodies/stars/red_giant.png"));
		b245.setRelativeSize(10F);
		
	}
	
	private void initStations() {
		// possible custom station don't mind this :)
		station.setBiomeInfo(BiomeOrbit.space);
		station.setParentSolarSystem(valerian);
		station.setRelativeSize(2F);
		station.setRelativeOrbitTime(10.0F);
		station.setRelativeDistanceFromCenter(new ScalableDistance(1.7F,1.7F));
		station.setDimensionInfo(-700, WorldProviderValerian.class).setTierRequired(1);
		station.setAtmosphere(new AtmosphereInfo(false, false, false, 0.0F, 0.1F, 0.02F));
		station.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX,"textures/gui/celestialbodies/space_station.png"));
		return;
	}
	
	private void initSolarSystems() {
		
		
		valerian.setMainStar(b245);
		return;
	}
	
	private void registerSolarSystems() {
		
		GalaxyRegistry.registerSolarSystem(valerian);
		
		this.registerPlanets();
	}
	
	private void registerPlanets() {
		GalacticraftRegistry.registerTeleportType(WorldProviderValerian.class, new TeleportTypeOrbit());
		GalaxyRegistry.registerPlanet(station);
	}
	
}
