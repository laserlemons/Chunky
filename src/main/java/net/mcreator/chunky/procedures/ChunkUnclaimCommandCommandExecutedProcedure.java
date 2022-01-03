package net.mcreator.chunky.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.chunky.ChunkyModVariables;
import net.mcreator.chunky.ChunkyMod;

import java.util.Map;

import java.io.File;

public class ChunkUnclaimCommandCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ChunkyMod.LOGGER.warn("Failed to load dependency world for procedure ChunkUnclaimCommandCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ChunkyMod.LOGGER.warn("Failed to load dependency x for procedure ChunkUnclaimCommandCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ChunkyMod.LOGGER.warn("Failed to load dependency y for procedure ChunkUnclaimCommandCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ChunkyMod.LOGGER.warn("Failed to load dependency z for procedure ChunkUnclaimCommandCommandExecuted!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ChunkyMod.LOGGER.warn("Failed to load dependency entity for procedure ChunkUnclaimCommandCommandExecuted!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		File chunkyconfig = new File("");
		File chunkydata = new File("");
		String playername = "";
		Chunk currentchunk = null;
		chunkyconfig = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.CONFIG_FILE);
		chunkydata = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.DATA_FILE);
		playername = (entity.getDisplayName().getString());
		currentchunk = (Chunk) world.getChunk(new BlockPos(x, y, z));
	}
}
