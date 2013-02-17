package aits.chemistry.machines;

import net.minecraft.item.ItemStack;
import aits.chemistry.util.Compound;

public interface ILabEquipment
{
	// Must define IChemical ContainingChemical.


	// Returns the chemical inside this item
	public abstract Compound GetChemicalInside(ItemStack itemstack);

	// The following functions define which sides it can connect on.
	// Connection assumes flow.
	public abstract boolean CanConnectOnLeft();
	public abstract boolean CanConnectOnTop();
	public abstract boolean CanConnectOnRight();
	public abstract boolean CanConnectOnBottom();

	// Returns the temperature that this might add/substract from the chemical inside it.
	// Condensers use this.
	public abstract int GetTemperatureDifference();

	// Returns true if the equipment can collect chemicals (ie. as a container)
	public abstract boolean CanCollectChemicals();
}
