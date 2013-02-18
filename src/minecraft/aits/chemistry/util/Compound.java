package aits.chemistry.util;

import static aits.chemistry.util.EnumClassificationList.UnknownCharge;

public class Compound
{
	public EnumCompoundList			Compound;
	public int						Count;
	public EnumClassificationList	Charge;

	public Compound(EnumCompoundList ChemicalEnum, int amount)
	{
		this.Count = amount;
		this.Compound = ChemicalEnum;
		this.Charge = UnknownCharge;
	}

	public Compound(EnumCompoundList c)
	{
		this.Count = 1;
		this.Compound = c;
		this.Charge = UnknownCharge;
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

		// ASDFASDJF
	}
}
