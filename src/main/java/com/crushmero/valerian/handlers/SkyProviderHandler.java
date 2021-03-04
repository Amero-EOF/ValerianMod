package com.crushmero.valerian.handlers;

import com.crushmero.valerian.ExampleMod;
import com.crushmero.valerian.world.AbstractWorldProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, value = Side.CLIENT)
public class SkyProviderHandler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final WorldClient world = minecraft.world;
		final EntityPlayerSP player = minecraft.player;
		
		if (event.phase == Phase.START && player != null && world != null) {
			if (world.provider instanceof AbstractWorldProvider) {
				if (world.provider.getSkyRenderer() == null) {
					((AbstractWorldProvider) world.provider).createSkyProvider();
				}
			}
		}
	}
}
