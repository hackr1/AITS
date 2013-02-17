package aits.core.items;

import net.minecraft.item.Item;
import aits.core.AITS;
import aits.core.common.CommonProxy;

public class AITSItemBase extends Item {

	public AITSItemBase(int par1) {
		super(par1);
		this.setCreativeTab(AITS.tabAITS);

	}

	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}
