package com.crushmero.valerian;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.crushmero.valerian.init.InitCelestialObjects;
import com.crushmero.valerian.init.ValDimensions;
import com.crushmero.valerian.proxy.CommonProxy;
import com.crushmero.valerian.world.BiomeGeneratorBase;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION, dependencies = ExampleMod.DEP)
public class ExampleMod
{
    public static final String MODID = "valerian";
    public static final String NAME = "Valerian";
    public static final String VERSION = "1.0";
    
    public static final String DEP = "required:forge@[4.23.5.2847,);required-after:galacticraftcore@[4.0.2.261,);";

    public static Logger logger;
    
    @SidedProxy(clientSide="com.crushmero.valerian.proxy.ClientProxy", serverSide="com.crushmero.valerian.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    public static List<BiomeGeneratorBase> biomesList = new ArrayList<>();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        
        InitCelestialObjects.initCelestialBodies();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //SchemLoader.schemLoad("a_block.schematic");
        proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		ValDimensions.VAlERIAN_SPACE_STATION = WorldUtil.getDimensionTypeById(Configs.STATION_DIM_ID);
    	proxy.postInit(event);
    	
    }
}
