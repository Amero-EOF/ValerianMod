package com.crushmero.valerian.init;



import com.crushmero.valerian.Configs;
import com.crushmero.valerian.celestial.CelestialObjects;
import com.crushmero.valerian.celestial.station.WorldProviderValerian;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.dimension.TeleportTypeOrbit;
import net.minecraft.util.ResourceLocation;

public class InitCelestialObjects {

	public static void initCelestialBodies() {
		initSolarSystems();
		initStations();
	}

	private static void initSolarSystems() {
		CelestialObjects.VALERIAN.setMapPosition(new Vector3(1.0,-1.0,0.0));
		Star b245 = new Star("b245").setParentSolarSystem(CelestialObjects.VALERIAN);
		b245.setTierRequired(-1).setBodyIcon(new ResourceLocation("valerian:celestialbodies/stars/red_giant.png")).setRelativeSize(10F);
		CelestialObjects.VALERIAN.setMainStar(b245);
		
		registerSolarSystem(CelestialObjects.VALERIAN);
	}
	
	private static void initStations() {
		// possible custom station don't mind this :)
		CelestialObjects.STATION.setParentSolarSystem(CelestialObjects.VALERIAN);
		CelestialObjects.STATION.setTierRequired(1);
		CelestialObjects.STATION.setPhaseShift((float) (Math.PI / 5.8748F));
		CelestialObjects.STATION.setRelativeSize(2F);
		CelestialObjects.STATION.setRelativeOrbitTime(10.0F);
		CelestialObjects.STATION.setRelativeDistanceFromCenter(new ScalableDistance(1.7F,1.7F));
		CelestialObjects.STATION.setDimensionInfo(Configs.STATION_DIM_ID, WorldProviderValerian.class);
		CelestialObjects.STATION.setAtmosphere(new AtmosphereInfo(false, false, false, 0.0F, 0.1F, 0.02F));
		CelestialObjects.STATION.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX,"textures/gui/celestialbodies/space_station.png"));
		
		registerPlanet(CelestialObjects.STATION, new TeleportTypeOrbit());
	}
	
	private static void registerSolarSystem(SolarSystem system) {
		GalaxyRegistry.registerSolarSystem(system);
	}
	
	private static void registerPlanet(Planet planet, ITeleportType teleportType) {
		GalaxyRegistry.registerPlanet(planet);
		GalacticraftRegistry.registerTeleportType(planet.getWorldProvider(), teleportType);
	}

}
