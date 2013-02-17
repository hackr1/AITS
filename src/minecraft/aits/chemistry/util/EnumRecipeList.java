package aits.chemistry.util;

import static aits.chemistry.util.EnumCompoundList.*;

import java.util.ArrayList;
import java.util.List;


public enum EnumRecipeList
{
	// Neutralisation Recipes

	// With Lithium Hydroxide (LiOH)
	LiOH_HCl		(new Compound[]{ new Compound(LiOH), new Compound(HCl)		}, new Compound[]{ new Compound(LiCl),		new Compound(H2O) }),
	LiOH_HNO3		(new Compound[]{ new Compound(LiOH), new Compound(HNO3)		}, new Compound[]{ new Compound(LiNO3),		new Compound(H2O) }),
	LiOH_H2SO4		(new Compound[]{ new Compound(LiOH, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Li2SO4),		new Compound(H2O, 2) }),
	LiOH_HBr		(new Compound[]{ new Compound(LiOH), new Compound(HBr)		}, new Compound[]{ new Compound(LiBr),		new Compound(H2O) }),
	LiOH_HI			(new Compound[]{ new Compound(LiOH), new Compound(HI)		}, new Compound[]{ new Compound(LiI),			new Compound(H2O) }),
	LiOH_HClO4		(new Compound[]{ new Compound(LiOH), new Compound(HClO4)		}, new Compound[]{ new Compound(LiClO4),		new Compound(H2O) }),

	// With Sodium Hydroxide (NaOH)
	NaOH_HCl		(new Compound[]{ new Compound(NaOH), new Compound(HClO4)		}, new Compound[]{ new Compound(NaCl),		new Compound(H2O) }),
	NaOH_HNO3		(new Compound[]{ new Compound(NaOH), new Compound(HNO3)		}, new Compound[]{ new Compound(NaNO3),		new Compound(H2O) }),
	NaOH_H2SO4		(new Compound[]{ new Compound(NaOH, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Na2SO4),		new Compound(H2O, 2) }),
	NaOH_HBr		(new Compound[]{ new Compound(NaOH), new Compound(HBr)		}, new Compound[]{ new Compound(NaBr),		new Compound(H2O) }),
	NaOH_HI			(new Compound[]{ new Compound(NaOH), new Compound(HI)		}, new Compound[]{ new Compound(NaI),			new Compound(H2O) }),
	NaOH_HClO4		(new Compound[]{ new Compound(NaOH), new Compound(HClO4)		}, new Compound[]{ new Compound(NaClO4),		new Compound(H2O) }),

	// With Potassium Hydroxide (KOH)
	KOH_HClO4		(new Compound[]{ new Compound(KOH), new Compound(HClO4)		}, new Compound[]{ new Compound(KCl),			new Compound(H2O) }),
	KOH_HNO3		(new Compound[]{ new Compound(KOH), new Compound(HNO3)		}, new Compound[]{ new Compound(KNO3),		new Compound(H2O) }),
	KOH_H2SO4		(new Compound[]{ new Compound(KOH, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(K2SO4),		new Compound(H2O, 2) }),
	KOH_HBr			(new Compound[]{ new Compound(KOH), new Compound(HBr)		}, new Compound[]{ new Compound(KBr),			new Compound(H2O) }),
	KOH_HI			(new Compound[]{ new Compound(KOH), new Compound(HI)			}, new Compound[]{ new Compound(KI),			new Compound(H2O) }),
	KOH_HClO4O4		(new Compound[]{ new Compound(KOH), new Compound(HClO4)		}, new Compound[]{ new Compound(KClO4),		new Compound(H2O) }),

	// With Rubidium Hydroxide (RbOH)
	RbOH_HCl		(new Compound[]{ new Compound(RbOH), new Compound(HClO4)		}, new Compound[]{ new Compound(RbCl),		new Compound(H2O) }),
	RbOH_HNO3		(new Compound[]{ new Compound(RbOH), new Compound(HNO3)		}, new Compound[]{ new Compound(RbNO3),		new Compound(H2O) }),
	RbOH_H2SO4		(new Compound[]{ new Compound(RbOH, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Rb2SO4),		new Compound(H2O, 2) }),
	RbOH_HBr		(new Compound[]{ new Compound(RbOH), new Compound(HBr)		}, new Compound[]{ new Compound(RbBr),		new Compound(H2O) }),
	RbOH_HI			(new Compound[]{ new Compound(RbOH), new Compound(HI)		}, new Compound[]{ new Compound(RbI),			new Compound(H2O) }),
	RbOH_HClO4		(new Compound[]{ new Compound(RbOH), new Compound(HClO4)		}, new Compound[]{ new Compound(RbClO4),		new Compound(H2O) }),

	// With Caesium Hydroxide (CsOH)
	CsOH_HCl		(new Compound[]{ new Compound(CsOH), new Compound(HClO4)		}, new Compound[]{ new Compound(CsCl),		new Compound(H2O) }),
	CsOH_HNO3		(new Compound[]{ new Compound(CsOH), new Compound(HNO3)		}, new Compound[]{ new Compound(CsNO3),		new Compound(H2O) }),
	CsOH_H2SO4		(new Compound[]{ new Compound(CsOH, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Cs2SO4),		new Compound(H2O, 2) }),
	CsOH_HBr		(new Compound[]{ new Compound(CsOH), new Compound(HBr)		}, new Compound[]{ new Compound(CsBr),		new Compound(H2O) }),
	CsOH_HI			(new Compound[]{ new Compound(CsOH), new Compound(HI)		}, new Compound[]{ new Compound(CsI),			new Compound(H2O) }),
	CsOH_HClO4		(new Compound[]{ new Compound(CsOH), new Compound(HClO4)		}, new Compound[]{ new Compound(CsClO4),		new Compound(H2O) }),




	// Metal + Acid reactions (Metal + Acid = Salt + Hydrogen Gas)
	// Cs, Rb, K, Na, Li, Ba, Sr, Ca, Mg, Al, Mn, Zn, Cr, Fe, Cd, Co, Ni, Sn, Pb
	// Organised in order of reactivity with each acid.
	// Highest-lowest.
	// Use for future implementation of boom-boom Cs+HCl reactions.
	// TODO: Implement superheated reactivity with group 1 metals.

	// Hydrochloric Acid (HClO4)
	Cs_HCl			(new Compound[]{ new Compound(Cs, 2), new Compound(HCl, 2)	}, new Compound[]{ new Compound(CsCl, 2),		new Compound(H2) }),
	Rb_HCl			(new Compound[]{ new Compound(Rb, 2), new Compound(HCl, 2)	}, new Compound[]{ new Compound(RbCl, 2),		new Compound(H2) }),
	K_HCl			(new Compound[]{ new Compound(K, 2), new Compound(HCl, 2)	}, new Compound[]{ new Compound(KCl, 2),		new Compound(H2) }),
	Na_HCl			(new Compound[]{ new Compound(Na, 2), new Compound(HCl, 2)	}, new Compound[]{ new Compound(NaCl, 2),		new Compound(H2) }),
	Li_HCl			(new Compound[]{ new Compound(Li, 2), new Compound(HCl, 2)	}, new Compound[]{ new Compound(LiCl, 2),		new Compound(H2) }),

	Ba_HCl			(new Compound[]{ new Compound(Ba), new Compound(HCl, 2)		}, new Compound[]{ new Compound(BaClO42),	new Compound(H2) }),
	Sr_HCl			(new Compound[]{ new Compound(Sr), new Compound(HCl, 2)		}, new Compound[]{ new Compound(SrClO42),	new Compound(H2) }),
	Ca_HCl			(new Compound[]{ new Compound(Ca), new Compound(HCl, 2)		}, new Compound[]{ new Compound(CaClO42),	new Compound(H2) }),
	Mg_HCl			(new Compound[]{ new Compound(Mg), new Compound(HCl, 2)		}, new Compound[]{ new Compound(MgClO42),	new Compound(H2) }),
	Mn_HCl			(new Compound[]{ new Compound(Mn2), new Compound(HCl, 2)		}, new Compound[]{ new Compound(Mn$2ClO42),	new Compound(H2) }),
	Zn_HCl			(new Compound[]{ new Compound(Zn), new Compound(HCl, 2)		}, new Compound[]{ new Compound(ZnClO42),	new Compound(H2) }),
	Cr_HCl			(new Compound[]{ new Compound(Cr2), new Compound(HCl, 2)		}, new Compound[]{ new Compound(Cr$2ClO42),	new Compound(H2) }),
	Fe_2_HCl		(new Compound[]{ new Compound(Fe2), new Compound(HCl, 2)		}, new Compound[]{ new Compound(Fe$2ClO42),	new Compound(H2) }),
	Cd_HCl			(new Compound[]{ new Compound(Cd), new Compound(HCl, 2)		}, new Compound[]{ new Compound(CdClO42),	new Compound(H2) }),
	Co_HCl			(new Compound[]{ new Compound(Co2), new Compound(HCl, 2)		}, new Compound[]{ new Compound(Co$2ClO42),	new Compound(H2) }),
	Ni_HCl			(new Compound[]{ new Compound(Ni), new Compound(HCl, 2)		}, new Compound[]{ new Compound(NiClO42),	new Compound(H2) }),
	Sn_HCl			(new Compound[]{ new Compound(Sn2), new Compound(HCl, 2)		}, new Compound[]{ new Compound(Sn$2ClO42),	new Compound(H2) }),
	Pb_HCl			(new Compound[]{ new Compound(Pb), new Compound(HCl, 2)		}, new Compound[]{ new Compound(PbClO42),	new Compound(H2) }),

	Fe_3_HCl		(new Compound[]{ new Compound(Fe3, 2), new Compound(HCl, 6)	}, new Compound[]{ new Compound(Fe$3Cl3, 2),	new Compound(H2, 3) }),
	Al_HCl			(new Compound[]{ new Compound(Al, 2), new Compound(HCl, 6)	}, new Compound[]{ new Compound(AlCl3, 2),	new Compound(H2, 3) }),

	// Nitric Acid (HNO3)


	//  denotes an opening bracket.
	//  denotes a closing bracket.
	// Damn java and its lack of symbols.

	Cs_HNO3			(new Compound[]{ new Compound(Cs, 2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(CsNO3, 2),	new Compound(H2) }),
	Rb_HNO3			(new Compound[]{ new Compound(Rb, 2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(RbNO3, 2),	new Compound(H2) }),
	K_HNO3			(new Compound[]{ new Compound(K, 2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(KNO3, 2),		new Compound(H2) }),
	Na_HNO3			(new Compound[]{ new Compound(Na, 2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(NaNO3, 2),	new Compound(H2) }),
	Li_HNO3			(new Compound[]{ new Compound(Li, 2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(LiNO3, 2),	new Compound(H2) }),

	Ba_HNO3			(new Compound[]{ new Compound(Ba), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(BaSO4),		new Compound(H2) }),
	Sr_HNO3			(new Compound[]{ new Compound(Sr), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(SrSO4),		new Compound(H2) }),
	Ca_HNO3			(new Compound[]{ new Compound(Ca), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(CaSO4),		new Compound(H2) }),
	Mg_HNO3			(new Compound[]{ new Compound(Mg), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(MgSO4),		new Compound(H2) }),
	Mn_HNO3			(new Compound[]{ new Compound(Mn2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(Mn$2SO4),		new Compound(H2) }),
	Zn_HNO3			(new Compound[]{ new Compound(Zn), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(ZnSO4),		new Compound(H2) }),
	Cr_HNO3			(new Compound[]{ new Compound(Cr2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(Cr$2SO4),		new Compound(H2) }),
	Fe_2_HNO3		(new Compound[]{ new Compound(Fe2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(Fe$2SO4),		new Compound(H2) }),
	Cd_HNO3			(new Compound[]{ new Compound(Cd), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(CdSO4),		new Compound(H2) }),
	Co_HNO3			(new Compound[]{ new Compound(Co2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(Co$2SO4),		new Compound(H2) }),
	Ni_HNO3			(new Compound[]{ new Compound(Ni), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(NiSO4),		new Compound(H2) }),
	Sn_HNO3			(new Compound[]{ new Compound(Sn2), new Compound(HNO3, 2)	}, new Compound[]{ new Compound(Sn$2SO4),		new Compound(H2) }),
	Pb_HNO3			(new Compound[]{ new Compound(Pb), new Compound(HNO3, 2)		}, new Compound[]{ new Compound(PbSO4),		new Compound(H2) }),

	Fe_3_HNO3		(new Compound[]{ new Compound(Fe3, 2), new Compound(HNO3, 6)	}, new Compound[]{ new Compound(Fe$3NO33, 2),new Compound(H2, 3) }),
	Al_HNO3			(new Compound[]{ new Compound(Al, 2), new Compound(HNO3, 6)	}, new Compound[]{ new Compound(AlNO33, 2),	new Compound(H2, 3) }),



	// Sulphuric Acid (H2SO4)
	Cs_H2SO4		(new Compound[]{ new Compound(Cs, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Cs2SO4),		new Compound(H2) }),
	Rb_H2SO4		(new Compound[]{ new Compound(Rb, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Rb2SO4),		new Compound(H2) }),
	K_H2SO4			(new Compound[]{ new Compound(K, 2), new Compound(H2SO4)		}, new Compound[]{ new Compound(K2SO4),		new Compound(H2) }),
	Na_H2SO4		(new Compound[]{ new Compound(Na, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Na2SO4),		new Compound(H2) }),
	Li_H2SO4		(new Compound[]{ new Compound(Li, 2), new Compound(H2SO4)	}, new Compound[]{ new Compound(Li2SO4),		new Compound(H2) }),

	Ba_H2SO4		(new Compound[]{ new Compound(Ba), new Compound(H2SO4)		}, new Compound[]{ new Compound(BaSO4),		new Compound(H2) }),
	Sr_H2SO4		(new Compound[]{ new Compound(Sr), new Compound(H2SO4)		}, new Compound[]{ new Compound(SrSO4),		new Compound(H2) }),
	Ca_H2SO4		(new Compound[]{ new Compound(Ca), new Compound(H2SO4)		}, new Compound[]{ new Compound(CaSO4),		new Compound(H2) }),
	Mg_H2SO4		(new Compound[]{ new Compound(Mg), new Compound(H2SO4)		}, new Compound[]{ new Compound(MgSO4),		new Compound(H2) }),
	Mn_H2SO4		(new Compound[]{ new Compound(Mn2), new Compound(H2SO4)		}, new Compound[]{ new Compound(Mn$2SO4),		new Compound(H2) }),
	Zn_H2SO4		(new Compound[]{ new Compound(Zn), new Compound(H2SO4)		}, new Compound[]{ new Compound(ZnSO4),		new Compound(H2) }),
	Cr_H2SO4		(new Compound[]{ new Compound(Cr2), new Compound(H2SO4)		}, new Compound[]{ new Compound(Cr$2SO4),		new Compound(H2) }),
	Fe_2_H2SO4		(new Compound[]{ new Compound(Fe2), new Compound(H2SO4)		}, new Compound[]{ new Compound(Fe$2SO4),		new Compound(H2) }),
	Cd_H2SO4		(new Compound[]{ new Compound(Cd), new Compound(H2SO4)		}, new Compound[]{ new Compound(CdSO4),		new Compound(H2) }),
	Co_H2SO4		(new Compound[]{ new Compound(Co2), new Compound(H2SO4)		}, new Compound[]{ new Compound(Co$2SO4),		new Compound(H2) }),
	Ni_H2SO4		(new Compound[]{ new Compound(Ni), new Compound(H2SO4)		}, new Compound[]{ new Compound(NiSO4),		new Compound(H2) }),
	Sn_H2SO4		(new Compound[]{ new Compound(Sn2), new Compound(H2SO4)		}, new Compound[]{ new Compound(Sn$2SO4),		new Compound(H2) }),
	Pb_H2SO4		(new Compound[]{ new Compound(Pb), new Compound(H2SO4)		}, new Compound[]{ new Compound(PbSO4),		new Compound(H2) }),

	Fe_3_H2SO4		(new Compound[]{ new Compound(Fe3, 2), new Compound(H2SO4, 6)}, new Compound[]{ new Compound(Fe$32SO43, 2),new Compound(H2, 3) }),
	Al_H2SO4		(new Compound[]{ new Compound(Al, 2), new Compound(H2SO4, 6)	}, new Compound[]{ new Compound(Al2SO43, 2),new Compound(H2, 3) }),


	// Hydrobromic Acid (HBr)
	Cs_HBr			(new Compound[]{ new Compound(Cs, 2), new Compound(HBr, 2)	}, new Compound[]{ new Compound(CsBr, 2),		new Compound(H2) }),
	Rb_HBr			(new Compound[]{ new Compound(Rb, 2), new Compound(HBr, 2)	}, new Compound[]{ new Compound(RbBr, 2),		new Compound(H2) }),
	K_HBr			(new Compound[]{ new Compound(K, 2), new Compound(HBr, 2)	}, new Compound[]{ new Compound(KBr, 2),		new Compound(H2) }),
	Na_HBr			(new Compound[]{ new Compound(Na, 2), new Compound(HBr, 2)	}, new Compound[]{ new Compound(NaBr, 2),		new Compound(H2) }),
	Li_HBr			(new Compound[]{ new Compound(Li, 2), new Compound(HBr, 2)	}, new Compound[]{ new Compound(LiBr, 2),		new Compound(H2) }),

	Ba_HBr			(new Compound[]{ new Compound(Ba), new Compound(HBr, 2)		}, new Compound[]{ new Compound(BaBr2),		new Compound(H2) }),
	Sr_HBr			(new Compound[]{ new Compound(Sr), new Compound(HBr, 2)		}, new Compound[]{ new Compound(SrBr2),		new Compound(H2) }),
	Ca_HBr			(new Compound[]{ new Compound(Ca), new Compound(HBr, 2)		}, new Compound[]{ new Compound(CaBr2),		new Compound(H2) }),
	Mg_HBr			(new Compound[]{ new Compound(Mg), new Compound(HBr, 2)		}, new Compound[]{ new Compound(MgBr2),		new Compound(H2) }),
	Mn_HBr			(new Compound[]{ new Compound(Mn2), new Compound(HBr, 2)		}, new Compound[]{ new Compound(Mn$2Br2),		new Compound(H2) }),
	Zn_HBr			(new Compound[]{ new Compound(Zn), new Compound(HBr, 2)		}, new Compound[]{ new Compound(ZnBr2),		new Compound(H2) }),
	Cr_HBr			(new Compound[]{ new Compound(Cr2), new Compound(HBr, 2)		}, new Compound[]{ new Compound(Cr$2Br2),		new Compound(H2) }),
	Fe_2_HBr		(new Compound[]{ new Compound(Fe2), new Compound(HBr, 2)		}, new Compound[]{ new Compound(Fe$2Br2),		new Compound(H2) }),
	Cd_HBr			(new Compound[]{ new Compound(Cd), new Compound(HBr, 2)		}, new Compound[]{ new Compound(CdBr2),		new Compound(H2) }),
	Co_HBr			(new Compound[]{ new Compound(Co2), new Compound(HBr, 2)		}, new Compound[]{ new Compound(Co$2Br2),		new Compound(H2) }),
	Ni_HBr			(new Compound[]{ new Compound(Ni), new Compound(HBr, 2)		}, new Compound[]{ new Compound(NiBr2),		new Compound(H2) }),
	Sn_HBr			(new Compound[]{ new Compound(Sn2), new Compound(HBr, 2)		}, new Compound[]{ new Compound(Sn$2Br2),		new Compound(H2) }),
	Pb_HBr			(new Compound[]{ new Compound(Pb), new Compound(HBr, 2)		}, new Compound[]{ new Compound(PbBr2),		new Compound(H2) }),

	Fe_3_HBr		(new Compound[]{ new Compound(Fe3, 2), new Compound(HBr, 6)	}, new Compound[]{ new Compound(Fe$3Br3, 2),	new Compound(H2, 3) }),
	Al_HBr			(new Compound[]{ new Compound(Al, 2), new Compound(HBr, 6)	}, new Compound[]{ new Compound(AlBr3, 2),	new Compound(H2, 3) }),


	// Hydroiodic Acid (HI)
	Cs_HI			(new Compound[]{ new Compound(Cs, 2), new Compound(HI, 2)	}, new Compound[]{ new Compound(CsI, 2),		new Compound(H2) }),
	Rb_HI			(new Compound[]{ new Compound(Rb, 2), new Compound(HI, 2)	}, new Compound[]{ new Compound(RbI, 2),		new Compound(H2) }),
	K_HI			(new Compound[]{ new Compound(K, 2), new Compound(HI, 2)		}, new Compound[]{ new Compound(KI, 2),		new Compound(H2) }),
	Na_HI			(new Compound[]{ new Compound(Na, 2), new Compound(HI, 2)	}, new Compound[]{ new Compound(NaI, 2),		new Compound(H2) }),
	Li_HI			(new Compound[]{ new Compound(Li, 2), new Compound(HI, 2)	}, new Compound[]{ new Compound(LiI, 2),		new Compound(H2) }),

	Ba_HI			(new Compound[]{ new Compound(Ba), new Compound(HI, 2)		}, new Compound[]{ new Compound(BaI2),		new Compound(H2) }),
	Sr_HI			(new Compound[]{ new Compound(Sr), new Compound(HI, 2)		}, new Compound[]{ new Compound(SrI2),		new Compound(H2) }),
	Ca_HI			(new Compound[]{ new Compound(Ca), new Compound(HI, 2)		}, new Compound[]{ new Compound(CaI2),		new Compound(H2) }),
	Mg_HI			(new Compound[]{ new Compound(Mg), new Compound(HI, 2)		}, new Compound[]{ new Compound(MgI2),		new Compound(H2) }),
	Mn_HI			(new Compound[]{ new Compound(Mn2), new Compound(HI, 2)		}, new Compound[]{ new Compound(Mn$2I2),		new Compound(H2) }),
	Zn_HI			(new Compound[]{ new Compound(Zn), new Compound(HI, 2)		}, new Compound[]{ new Compound(ZnI2),		new Compound(H2) }),
	Cr_HI			(new Compound[]{ new Compound(Cr2), new Compound(HI, 2)		}, new Compound[]{ new Compound(Cr$2I2),		new Compound(H2) }),
	Fe_2_HI			(new Compound[]{ new Compound(Fe2), new Compound(HI, 2)		}, new Compound[]{ new Compound(Fe$2I2),		new Compound(H2) }),
	Cd_HI			(new Compound[]{ new Compound(Cd), new Compound(HI, 2)		}, new Compound[]{ new Compound(CdI2),		new Compound(H2) }),
	Co_HI			(new Compound[]{ new Compound(Co2), new Compound(HI, 2)		}, new Compound[]{ new Compound(Co$2I2),		new Compound(H2) }),
	Ni_HI			(new Compound[]{ new Compound(Ni), new Compound(HI, 2)		}, new Compound[]{ new Compound(NiI2),		new Compound(H2) }),
	Sn_HI			(new Compound[]{ new Compound(Sn2), new Compound(HI, 2)		}, new Compound[]{ new Compound(Sn$2I2),		new Compound(H2) }),
	Pb_HI			(new Compound[]{ new Compound(Pb), new Compound(HI, 2)		}, new Compound[]{ new Compound(PbI2),		new Compound(H2) }),

	Fe_3_HI			(new Compound[]{ new Compound(Fe3, 2), new Compound(HI, 6)	}, new Compound[]{ new Compound(Fe$3I3, 2),	new Compound(H2, 3) }),
	Al_HI			(new Compound[]{ new Compound(Al, 2), new Compound(HI, 6)	}, new Compound[]{ new Compound(AlI3, 2),		new Compound(H2, 3) }),


	// Perchloric Acid (HClO4O4)
	Cs_HClO4		(new Compound[]{ new Compound(Cs, 2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(CsCl, 2),		new Compound(H2) }),
	Rb_HClO4		(new Compound[]{ new Compound(Rb, 2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(RbCl, 2),		new Compound(H2) }),
	K_HClO4			(new Compound[]{ new Compound(K, 2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(KCl, 2),		new Compound(H2) }),
	Na_HClO4		(new Compound[]{ new Compound(Na, 2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(NaCl, 2),		new Compound(H2) }),
	Li_HClO4		(new Compound[]{ new Compound(Li, 2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(LiCl, 2),		new Compound(H2) }),

	Ba_HClO4		(new Compound[]{ new Compound(Ba), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(BaClO42),	new Compound(H2) }),
	Sr_HClO4		(new Compound[]{ new Compound(Sr), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(SrClO42),	new Compound(H2) }),
	Ca_HClO4		(new Compound[]{ new Compound(Ca), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(CaClO42),	new Compound(H2) }),
	Mg_HClO4		(new Compound[]{ new Compound(Mg), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(MgClO42),	new Compound(H2) }),
	Mn_HClO4		(new Compound[]{ new Compound(Mn2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(Mn$2ClO42),	new Compound(H2) }),
	Zn_HClO4		(new Compound[]{ new Compound(Zn), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(ZnClO42),	new Compound(H2) }),
	Cr_HClO4		(new Compound[]{ new Compound(Cr2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(Cr$2ClO42),	new Compound(H2) }),
	Fe_2_HClO4		(new Compound[]{ new Compound(Fe2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(Fe$2ClO42),	new Compound(H2) }),
	Cd_HClO4		(new Compound[]{ new Compound(Cd), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(CdClO42),	new Compound(H2) }),
	Co_HClO4		(new Compound[]{ new Compound(Co2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(Co$2ClO42),	new Compound(H2) }),
	Ni_HClO4		(new Compound[]{ new Compound(Ni), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(NiClO42),	new Compound(H2) }),
	Sn_HClO4		(new Compound[]{ new Compound(Sn2), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(Sn$2ClO42),	new Compound(H2) }),
	Pb_HClO4		(new Compound[]{ new Compound(Pb), new Compound(HClO4, 2)	}, new Compound[]{ new Compound(PbClO42),	new Compound(H2) }),

	Fe_3_HClO4		(new Compound[]{ new Compound(Fe3, 2), new Compound(HClO4, 6)}, new Compound[]{ new Compound(Fe$3Cl3, 2),	new Compound(H2, 3) }),
	Al_HClO4		(new Compound[]{ new Compound(Al, 2), new Compound(HClO4, 6)	}, new Compound[]{ new Compound(AlCl3, 2),	new Compound(H2, 3) }),


























	// perhaps this may cause a crash...
	Unknown_Unknown				(new Compound[]{ new Compound(UnknownC), new Compound(UnknownC) }, new Compound[]{ new Compound(UnknownC) });

	// Describes consumption of inputs per second.
	// Tick referring to internal RChem ticks, not minecraft ticks.
	private final int ConsumptionPerTick;
	private final List<Compound> Inputs = new ArrayList<Compound>();
	private final List<Compound> Outputs = new ArrayList<Compound>();

	private EnumRecipeList(Compound[] Inputs, Compound[] Outputs, int... ConsumptionPerTick)
	{
		for(Compound c : Inputs)
			this.Inputs.add(c);

		for(Compound c : Outputs)
			this.Outputs.add(c);

		if(ConsumptionPerTick.length > 0)
			this.ConsumptionPerTick = ConsumptionPerTick[0];

		else
			this.ConsumptionPerTick = 1;
	}

	public List<Compound> GetInputs()
	{
		return this.Inputs;
	}

	public List<Compound> GetProducts()
	{
		return this.Outputs;
	}

	public int GetConsumptionRate()
	{
		return this.ConsumptionPerTick;
	}


}
