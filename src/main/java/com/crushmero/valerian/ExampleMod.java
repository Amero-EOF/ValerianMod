package com.crushmero.valerian;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.crushmero.valerian.init.InitCelestialObjects;
import com.crushmero.valerian.init.ValDimensions;
import com.crushmero.valerian.proxy.CommonProxy;
import com.crushmero.valerian.utils.SchemLoader;
import com.crushmero.valerian.world.gen.WorldProviderValerian;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION, dependencies = "required-after:galacticraftcore")
public class ExampleMod
{
    public static final String MODID = "valerian";
    public static final String NAME = "Valerian";
    public static final String VERSION = "1.0";

    public static Logger logger;
    
    @SidedProxy(clientSide="com.crushmero.valerian.proxy.ClientProxy", serverSide="com.crushmero.valerian.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        
		new InitCelestialObjects();
		
        
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ValDimensions.VAlERIAN_SPACE_STATION = GalacticraftRegistry.registerDimension("Valerian Space Station","_val_stat",-700,WorldProviderValerian.class,true);
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        //SchemLoader.schemLoad("a_block.schematic");
        proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	//DimensionType.register("Valerian Space Station", "_valerian_orbit", -40,WorldProviderValerian.class, true);
    	proxy.postInit(event);
    	
    }
}
