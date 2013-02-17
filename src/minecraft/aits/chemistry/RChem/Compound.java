package requimrar.Minecraft.RChem;

import static requimrar.Minecraft.RChem.EnumClassificationList.*;

public class Compound
{
	public EnumCompoundList Compound;
	public int Count;
	public EnumClassificationList Charge;

	public Compound(EnumCompoundList c, int amount)
	{
		this.Count = amount;
		this.Compound = c;
		this.Charge = Unknown;
	}

	public Compound(EnumCompoundList c)
	{
		this.Count = 1;
		this.Compound = c;
		this.Charge = Unknown;
	}

	public Compound(EnumCompoundList e, EnumClassificationList Charge)
	{
		this.Count = 1;
		this.Compound = e;
		this.Charge = Charge;
	}

	public Compound(EnumCompoundList e, int amount, EnumClassificationList Charge)
	{
		this.Count = amount;
		this.Compound = e;
		this.Charge = Charge;
	}
}
