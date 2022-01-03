package net.mcreator.chunky.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.chunky.ChunkyModVariables;
import net.mcreator.chunky.ChunkyMod;

import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ChunkClaimCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ChunkyMod.LOGGER.warn("Failed to load dependency world for procedure ChunkClaimCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ChunkyMod.LOGGER.warn("Failed to load dependency x for procedure ChunkClaimCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ChunkyMod.LOGGER.warn("Failed to load dependency y for procedure ChunkClaimCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ChunkyMod.LOGGER.warn("Failed to load dependency z for procedure ChunkClaimCommandExecuted!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ChunkyMod.LOGGER.warn("Failed to load dependency entity for procedure ChunkClaimCommandExecuted!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		String playerName = "";
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		Chunk currentchunk = null;
		File chunkydata = new File("");
		File chunkyconfig = new File("");
		chunkyconfig = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.CONFIG_FILE);
		chunkydata = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.DATA_FILE);
		playerName = (entity.getDisplayName().getString());
		currentchunk = (Chunk) world.getChunk(new BlockPos(x, y, z));
		mainjsonobject.addProperty((playerName + "_claimed_chunk"), (currentchunk.getPos().getXStart() + " , " + currentchunk.getPos().getZStart()));
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(chunkydata);
				fileWriter.write(mainGSONBuilderVariable.toJson(mainjsonobject));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
