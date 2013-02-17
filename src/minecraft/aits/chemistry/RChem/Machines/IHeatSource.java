package requimrar.Minecraft.RChem.Machines;

public interface IHeatSource extends ILabEquipment
{

	// Returns the maximum heat, in C, that this heating element can reach.
	public abstract int GetMaxHeat();

	// Returns the amount of time in ticks it takes for this to reach maximum heat.
	public abstract int GetWarmUpTime();

	// Returns the type of fuel it uses
	public abstract EnumHeatSourceFuels GetFuelSource();


}
