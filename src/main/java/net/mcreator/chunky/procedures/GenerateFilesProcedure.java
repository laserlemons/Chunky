package net.mcreator.chunky.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.chunky.ChunkyModVariables;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class GenerateFilesProcedure {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			executeProcedure(Collections.emptyMap());
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File chunkydata = new File("");
		File chunkyconfig = new File("");
		chunkyconfig = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.CONFIG_FILE);
		if (!chunkyconfig.exists()) {
			try {
				chunkyconfig.getParentFile().mkdirs();
				chunkyconfig.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainjsonobject.addProperty("player_claim_limit", (-1));
			mainjsonobject.addProperty("default_gamemode", 0);
			mainjsonobject.addProperty("claim_gamemode", 2);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(chunkyconfig);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainjsonobject));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		chunkydata = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.DATA_FILE);
		if (!chunkydata.exists()) {
			try {
				chunkydata.getParentFile().mkdirs();
				chunkydata.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
