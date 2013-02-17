package aits.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import aits.core.AITS;
import aits.core.common.CommonProxy;

public class AITSBlockBase extends Block {

	public AITSBlockBase(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		this.setCreativeTab(AITS.tabAITS);
		//TEST
	}

	public String getTextureFile() {
		return CommonProxy.BLOCK_PNG;
	}
}