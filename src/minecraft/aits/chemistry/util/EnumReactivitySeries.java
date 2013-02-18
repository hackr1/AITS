package aits.chemistry.util;

import static aits.chemistry.util.EnumCompoundList.*;

public enum EnumReactivitySeries
{

	// ** REACT WITH WATER & ACIDS ** \\
	// 2Li + 2H2O   --->   2LiOH + H2
	// 2Na + 2HCl   --->   2NaCl + H2

	Caesium			("Cs", Cs),
	Rubidium		("Rb", Rb),
	Potassium		("K",  K),
	Sodium			("Na", Na),
	Lithium			("Li", Li),
	Barium			("Ba", Ba),
	Strontium		("Sr", Sr),
	Calcium			("Ca", Ca),


	// ** REACT WITH ACIDS ** \\
	// Mg + 2HCl   --->   MgCl2 + H2

	Magnesium		("Mg", Mg),
	Aluminium		("Al", Al),

	// ** REACT WITH CONCENTRATED MINERAL ACIDS (HCl, H2SO4, HNO3 etc) ** \\
	// 2Ti + 6HCl   --->   2TiCl3 + 3H2

	Titanium		("Ti", Ti3, Ti4),


	// ** REACT WITH ACIDS ** \\
	// Zn + 2HCl   --->   ZnCl2 + H2

	Manganese		("Mn", Mn2, Mn5, Mn7),
	Zinc			("Zn", Zn),
	Chromium		("Cr", Cr2, Cr3, Cr6),
	Iron			("Fe", Fe2, Fe3),
	Cadmium			("Cd", Cd),
	Cobalt			("Co", Co2, Co3),
	Nickel			("Ni", Ni),
	Tin				("Sn", Sn2, Sn4),
	Lead			("Pb", Pb),


	// ** REACTIVE ONLY WITH CONCENTRATED H2SO4 ** \\
	// Cu + H2SO4(conc)   --->   CuSO4 + H2

	Hydrogen		("H",  H),
	Antimony		("Sb", Sb3, Sb5),
	Bismuth			("Bi", Bi),
	Copper			("Cu", Cu1, Cu2),
	Mercury			("Hg", Hg1, Hg2),
	Silver			("Ag", Ag),
	Gold			("Au", Au1, Au3),
	Platinum		("Pt", Pt2, Pt4);


	private final String ChemName;
	private final boolean DoesReact;

	private EnumReactivitySeries(String ChemName, EnumCompoundList... C)
	{
		this.ChemName = ChemName;
		this.DoesReact = false;
	}
}
