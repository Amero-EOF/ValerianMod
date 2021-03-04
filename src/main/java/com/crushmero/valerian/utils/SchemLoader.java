package com.crushmero.valerian.utils;


import java.io.IOException;
import java.io.InputStream;

import com.crushmero.valerian.ExampleMod;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.template.Template;

public class SchemLoader {
	
	
	
	
	
	public static Template schemLoad(String FileName) {
		try {
			InputStream fStream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("valerian:schematics/"+FileName)).getInputStream();
			ExampleMod.logger.error("died here");
			NBTTagCompound nbtFile = CompressedStreamTools.readCompressed(fStream);
			final Template template = new Template();
			template.read(nbtFile);
			return template;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
