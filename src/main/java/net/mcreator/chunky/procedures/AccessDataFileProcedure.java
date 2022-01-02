package net.mcreator.chunky.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.mcreator.chunky.ChunkyModVariables;

import java.util.Map;

import java.io.File;

public class AccessDataFileProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		File chunkydata = new File("");
		chunkydata = (File) new File((FMLPaths.GAMEDIR.get().toString() + "" + ChunkyModVariables.FILE_FOLDER),
				File.separator + ChunkyModVariables.DATA_FILE);
	}
}
