package aits.core.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Generation implements IWorldGenerator 
{
	public static void generateNether(Random random, int X, int Z, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
	}

	public static void generateOverworld(Random random, int X, int chunkZ,
			World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
	}

	public static void generateEnd(Random random, int X, int Z, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			Generation.generateNether(rand, chunkX * 16, chunkZ * 16, world,
					chunkGenerator, chunkProvider);
			break;
		case 0:
			Generation.generateOverworld(rand, chunkX * 16, chunkZ * 16, world,
					chunkGenerator, chunkProvider);
			break;
		case 1:
			Generation.generateEnd(rand, chunkX * 16, chunkZ * 16, world,
					chunkGenerator, chunkProvider);
			break;
		}
	}
}
