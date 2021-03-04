package com.crushmero.valerian.world;

import com.crushmero.valerian.celestial.station.sky.ValerianSpinManager;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbstractWorldProvider extends WorldProviderSpace {

	private ValerianSpinManager spinManager = new ValerianSpinManager(this);

	public ValerianSpinManager getValerianSpinManager() {
		return spinManager;
	}
	
    @Override
    protected void init()
    {
        super.init();
        this.getValerianSpinManager().registerServerSide();
    }
    
    @Override
    public void updateWeather()
    {
        super.updateWeather();
        spinManager.updateSpin();
    }
    
	@SideOnly(Side.CLIENT)
	public abstract void setSpinDeltaPerTick(float angle);
	
    @SideOnly(Side.CLIENT)
    public abstract float getSkyRotation();

    @SideOnly(Side.CLIENT)
	public abstract void createSkyProvider();
}
