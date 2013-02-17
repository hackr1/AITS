package aits.chemistry.util;

import static aits.chemistry.util.EnumClassificationList.Acidic;
import static aits.chemistry.util.EnumClassificationList.AcidicOxide;
import static aits.chemistry.util.EnumClassificationList.Actinide;
import static aits.chemistry.util.EnumClassificationList.AlkaliMetal;
import static aits.chemistry.util.EnumClassificationList.Alkaline;
import static aits.chemistry.util.EnumClassificationList.AlkalineEarthMetal;
import static aits.chemistry.util.EnumClassificationList.Anion;
import static aits.chemistry.util.EnumClassificationList.Beta;
import static aits.chemistry.util.EnumClassificationList.Cation;
import static aits.chemistry.util.EnumClassificationList.Covalent;
import static aits.chemistry.util.EnumClassificationList.Halogen;
import static aits.chemistry.util.EnumClassificationList.Ionic;
import static aits.chemistry.util.EnumClassificationList.Lanthanide;
import static aits.chemistry.util.EnumClassificationList.Metalloid;
import static aits.chemistry.util.EnumClassificationList.NeutralOxide;
import static aits.chemistry.util.EnumClassificationList.NobleGas;
import static aits.chemistry.util.EnumClassificationList.NonMetal;
import static aits.chemistry.util.EnumClassificationList.PostTransitionMetal;
import static aits.chemistry.util.EnumClassificationList.Stable;
import static aits.chemistry.util.EnumClassificationList.TransitionMetal;
import static aits.chemistry.util.EnumClassificationList.UnknownClass;

import java.util.ArrayList;
import java.util.List;




public enum EnumCompoundList
{
	H				("Hydrogen", NonMetal, 1, 0, -1, +1, -259, -253, false, Stable),
	H_2				("Deuterium", NonMetal, 1, 1, -1, +1, -255, -250, true, Stable),
	// 31 real-life days of play
	H_3 			("Tritium", NonMetal, 1, 2, /*53568000*/ 20 * 10, +1, -253, -248, true, Beta),

	// Helium Isotopes
	He				("Helium", NobleGas, 2, 2, -1, 0, -272, -269, false, Stable),
	He_3			("Helium-3", NobleGas, 2, 1, -1, 0, -272, -269, true, Stable),


	// ** PERIOD 2 ** \\

	// Lithium Isotopes
	Li				("Lithium", AlkaliMetal, 3, 4, -1, +1, 181, 1342, false, Stable),
	Li_6			("Lithium-6", AlkaliMetal, 3, 3, -1, +1, 181, 1342, true, Stable),

	Be				("Beryllium", AlkalineEarthMetal, 4, 5, -1, +2, 1278, 2970, false, Stable),
	B				("Boron", Metalloid, 5, 6, -1, +3, 2300, 2550, false, Stable),

	C_2				("C(II)", "Carbon(II)", NonMetal, 6, 6, -1, +2, 3500, 4827, true, Stable),
	C_4				("C(IV)", "Carbon(IV)", NonMetal, 6, 6, -1, +4, 3500, 4827, true, Stable),

	N				("Nitrogen", NonMetal, 7, 7, -1, -3, -210, -196, false, Stable),
	O				("Oxygen", NonMetal, 8, 8, -1, -2, -218, -183, false, Stable),
	F				("Fluorine", Halogen, 9, 10, -1, -1, -220, -188, false, Stable),
	Ne				("Neon", NobleGas, 10, 10, -1, 0, -249, -246, false, Stable),


	// ** PERIOD 3 ** \\

	Na				("Sodium", AlkaliMetal, 11, 12, -1, +1, 98, 883, false, Stable),
	Mg				("Magnesium", AlkalineEarthMetal, 12, 12, -1, +2, 639, 1090, false, Stable),
	Al				("Aluminium", PostTransitionMetal, 13, 14, -1, +3, 660, 2467, false, Stable),
	Si				("Silicon", Metalloid, 14, 14, -1, +4, 1410, 2355, false, Stable),

	P3				("P(III)", "Phosphorus(III)", NonMetal, 15, 16, -1, +3, 44, 280, false, Stable),
	P5				("P(V)", "Phosphorus(V)", NonMetal, 15, 16, -1, +5, 44, 280, false, Stable),

	S2				("S(II)", "Sulphur(II)", NonMetal, 16, 16, -1, +2, 113, 445, false, Stable),
	S4				("S(IV)", "Sulphur(IV)", NonMetal, 16, 16, -1, +4, 113, 445, false, Stable),
	S6				("S(VI)", "Sulphur(VI)", NonMetal, 16, 16, -1, +6, 113, 445, false, Stable),

	Cl				("Chlorine", Halogen, 17, 18, -1, -1, -101, -35, false, Stable),
	Ar				("Argon", NobleGas, 18, 22, -1, 0, -189, -186, false, Stable),


	// ** PERIOD 4 ** \\

	K				("Potassium", AlkaliMetal, 19, 21, -1, +1, 64, 774, false, Stable),
	Ca				("Calcium", AlkalineEarthMetal, 20, 20, -1, +2, 839, 1484, false, Stable),

	Sc2				("Sc(II)", "Scandium(II)", TransitionMetal, 21, 24, -1, +2, 1539, 2832, false, Stable),
	Sc3				("Sc(III)", "Scandium(III)", TransitionMetal, 21, 24, -1, +3, 1539, 2832, false, Stable),

	Ti3				("Ti(III)", "Titanium(III)", TransitionMetal, 22, 26, -1, +3, 1660, 3287, false, Stable),
	Ti4				("Ti(IV)", "Titanium(IV)", TransitionMetal, 22, 26, -1, +4, 1660, 3287, false, Stable),


	V2				("V(II)", "Vanadium(II)", TransitionMetal, 23, 28, -1, +2, 1890, 3380, false, Stable),
	V3				("V(III)", "Vanadium(III)", TransitionMetal, 23, 28, -1, +3, 1890, 3380, false, Stable),
	V4				("V(IV)", "Vanadium(IV)", TransitionMetal, 23, 28, -1, +4, 1890, 3380, false, Stable),
	V5				("V(V)", "Vanadium(V)", TransitionMetal, 23, 28, -1, +5, 1890, 3380, false, Stable),

	Cr2				("Cr(II)", "Chromium(II)", TransitionMetal, 24, 28, -1, +2, 1857, 2672, false, Stable),
	Cr3				("Cr(III)", "Chromium(III)", TransitionMetal, 24, 28, -1, +3, 1857, 2672, false, Stable),
	Cr6				("Cr(VI)", "Chromium(VI)", TransitionMetal, 24, 28, -1, +6, 1857, 2672, false, Stable),

	Mn2				("Mn(II)", "Manganese(II)", TransitionMetal, 25, 30, -1, +2, 1245, 1962, false, Stable),
	Mn5				("Mn(V)", "Manganese(VI)", TransitionMetal, 25, 30, -1, +6, 1245, 1962, false, Stable),
	Mn7				("Mn(VII)", "Manganese(VII)", TransitionMetal, 25, 30, -1, +7, 1245, 1962, false, Stable),

	Fe2				("Fe(II)", "Iron(II)", TransitionMetal, 26, 30, -1, +2, 1535, 2750, false, Stable),
	Fe3				("Fe(III)", "Iron(III)", TransitionMetal, 26, 30, -1, +3, 1535, 2750, false, Stable),

	Co2				("Co(II)", "Cobalt(II)", TransitionMetal, 27, 31, -1, +2, 1495, 2870, false, Stable),
	Co3				("Co(III)", "Cobalt(III)", TransitionMetal, 27, 31, -1, +3, 1495, 2870, false, Stable),

	Ni				("Nickel", TransitionMetal, 28, 30, -1, +2, 1453, 2732, false, Stable),

	Cu1				("Cu(I)", "Copper(I)", TransitionMetal, 29, 35, -1, +1, 1083, 2567, false, Stable),
	Cu2				("Cu(II)", "Copper(II)", TransitionMetal, 29, 35, -1, +2, 1083, 2567, false, Stable),
	Cu3				("Cu(III)", "Copper(III)", TransitionMetal, 29, 35, -1, +3, 1083, 2567, false, Stable),

	Zn				("Zinc", TransitionMetal, 30, 35, -1, +2, 420, 907, false, Stable),

	Ga				("Gallium", PostTransitionMetal, 31, 39, -1, +3, 30, 2403, false, Stable),

	Ge2				("Ge(II)", "Germanium(II)", Metalloid, 32, 41, -1, +2, 937, 2830, false, Stable),
	Ge4				("Ge(IV)", "Germanium(IV)", Metalloid, 32, 41, -1, +4, 937, 2830, false, Stable),

	As3				("As(III)", "Arsenic(III)", Metalloid, 33, 42, -1, +3, 81, 613, false, Stable),
	As5				("As(V)", "Arsenic(V)", Metalloid, 33, 42, -1, +5, 81, 613, false, Stable),

	Se2				("Se(II)", "Selenium(II)", NonMetal, 34, 45, -1, +2, 217, 685, false, Stable),
	Se4				("Se(IV)", "Selenium(IV)", NonMetal, 34, 45, -1, +4, 217, 685, false, Stable),
	Se6				("Se(VI)", "Selenium(VI)", NonMetal, 34, 45, -1, +6, 217, 685, false, Stable),

	Br				("Bromine", Halogen, 35, 45, -1, -1, -7, 59, false, Stable),
	Kr				("Krypton", NobleGas, 36, 48, -1, 0, -157, -153, false, Stable),


	// ** PERIOD 5 ** \\

	Rb				("Rubidium", AlkaliMetal, 37, 48, -1, +1, 39, 688, false, Stable),
	Sr				("Strontium", AlkalineEarthMetal, 38, 50, -1, +2, 769, 1384, false, Stable),
	Y				("Yttrium", TransitionMetal, 39, 50, -1, +3, 1523, 3337, false, Stable),
	Zr				("Zirconium", TransitionMetal, 40, 51, -1, +4, 1852, 4377, false, Stable),
	Nb				("Niobium", TransitionMetal, 41, 52, -1, +5, 2468, 4927, false, Stable),

	Mo4				("Mo(IV)", "Molybdenum(IV)", TransitionMetal, 42, 54, -1, +4, 2617, 4612, false, Stable),
	Mo6				("Mo(VI)", "Molybdenum(VI)", TransitionMetal, 42, 54, -1, +6, 2617, 4612, false, Stable),

	Tc4				("Tc(IV)", "Technetium(IV)", TransitionMetal, 43, 55, -1, +4, 2200, 4877, false, Stable),
	Tc7				("Tc(VII)", "Technetium(VII)", TransitionMetal, 43, 55, -1, +7, 2200, 4877, false, Stable),

	Ru3				("Ru(III)", "Ruthenium(III)", TransitionMetal, 44, 57, -1, +3, 2250, 3900, false, Stable),
	Ru4				("Ru(IV)", "Ruthenium(IV)", TransitionMetal, 44, 57, -1, +4, 2250, 3900, false, Stable),

	Rh				("Rhodium", TransitionMetal, 45, 58, -1, +3, 1966, 3727, false, Stable),

	Pd2				("Pd(II)", "Palladium(II)", TransitionMetal, 46, 60, -1, +2, 1552, 2927, false, Stable),
	Pd4				("Pd(IV)", "Palladium(IV)", TransitionMetal, 46, 60, -1, +4, 1552, 2927, false, Stable),

	Ag				("Silver", TransitionMetal, 47, 61, -1, +1, 962, 2212, false, Stable),

	Cd				("Cadmium", TransitionMetal, 48, 64, -1, +2, 321, 765, false, Stable),
	In				("Indium", PostTransitionMetal, 49, 66, -1, +3, 157, 2000, false, Stable),

	Sn2				("Sn(II)", "Tin(II)", PostTransitionMetal, 50, 69, -1, +2, 232, 2270, false, Stable),
	Sn4				("Sn(IV)", "Tin(IV)", PostTransitionMetal, 50, 69, -1, +4, 232, 2270, false, Stable),

	Sb3				("Sb(III)", "Antimony(III)", Metalloid, 51, 71, -1, +3, 630, 1750, false, Stable),
	Sb5				("Sb(V)", "Antimony(V)", Metalloid, 51, 71, -1, +5, 630, 1750, false, Stable),

	Te2				("Te(II)", "Tellurium(II)", Metalloid, 52, 76, -1, +2, 449, 990, false, Stable),
	Te4				("Te(IV)", "Tellurium(IV)", Metalloid, 52, 76, -1, +4, 449, 990, false, Stable),

	I				("Iodine", Halogen, 53, 74, -1, -1, 114, 184, false, Stable),
	Xe				("Xenon", NobleGas, 54, 77, -1, 0, -112, -108, false, Stable),


	// ** PERIOD 6 ** \\

	Cs				("Cesium", AlkaliMetal, 55, 78, -1, +1, 29, 678, false, Stable),
	Ba				("Barium", AlkalineEarthMetal, 56, 81, -1, +2, 725, 1140, false, Stable),
	La				("Lanthanum", Lanthanide, 57, 82, -1, +3, 920, 3469, false, Stable),

	Ce3				("Ce(III)", "Cerium(III)", Lanthanide, 58, 82, -1, +3, 795, 3257, false, Stable),
	Ce4				("Ce(IV)", "Cerium(IV)", Lanthanide, 58, 82, -1, +4, 795, 3257, false, Stable),

	Pr				("Praseodymium", Lanthanide, 59, 82, -1, +3, 935, 3127, false, Stable),
	Nd				("Neodymium", Lanthanide, 60, 84, -1, +3, 1010, 3127, false, Stable),
	Pm				("Promethium", Lanthanide, 61, 84, -1, +3, 1100, 3000, false, Stable),
	Sm				("Samarium", Lanthanide, 62, 88, -1, +3, 1072, 1900, false, Stable),
	Eu				("Europium", Lanthanide, 63, 89, -1, +3, 822, 1597, false, Stable),
	Gd				("Gadolinium", Lanthanide, 64, 93, -1, +3, 1311, 3233, false, Stable),
	Tb				("Terbium", Lanthanide, 65, 94, -1, +3, 1360, 3041, false, Stable),
	Dy				("Dysprosium", Lanthanide, 66, 97, -1, +3, 1412, 2562, false, Stable),
	Ho				("Holmium", Lanthanide, 67, 98, -1, +3, 1470, 2720, false, Stable),
	Er				("Erbium", Lanthanide, 68, 99, -1, +3, 1522, 2510, false, Stable),
	Tm				("Thulium", Lanthanide, 69, 100, -1, +3, 1545, 1727, false, Stable),
	Yb				("Ytterbium", Lanthanide, 70, 103, -1, +3, 824, 1466, false, Stable),
	Lu				("Lutetium", Lanthanide, 71, 104, -1, +3, 1656, 3315, false, Stable),
	Hf				("Hafnium", TransitionMetal, 72, 106, -1, +4, 2150, 5400, false, Stable),
	Ta				("Tantalum", TransitionMetal, 73, 108, -1, +5, 2996, 5425, false, Stable),
	W				("Tungsten", TransitionMetal, 74, 110, -1, +6, 3410, 5660, false, Stable),

	Re6				("Re(VI)", "Rhenium(VI)", TransitionMetal, 75, 111, -1, +6, 3180, 5627, false, Stable),
	Re7				("Re(VII)", "Rhenium(VII)", TransitionMetal, 75, 111, -1, +7, 3180, 5627, false, Stable),

	Os2				("Os(II)", "Osmium(II)", TransitionMetal, 76, 114, -1, +2, 3045, 5027, false, Stable),
	Os3				("Os(III)", "Osmium(III)", TransitionMetal, 76, 114, -1, +3, 3045, 5027, false, Stable),
	Os4				("Os(IV)", "Osmium(IV)", TransitionMetal, 76, 114, -1, +4, 3045, 5027, false, Stable),
	Os8				("Os(VIII)", "Osmium(VIII)", TransitionMetal, 76, 114, -1, +8, 3045, 5027, false, Stable),

	Ir3				("Ir(III)", "Iridium(III)", TransitionMetal, 77, 115, -1, +3, 2410, 4527, false, Stable),
	Ir4				("Ir(IV)", "Iridium(IV)", TransitionMetal, 77, 115, -1, +4, 2410, 4527, false, Stable),

	Pt2				("Pt(II)", "Platinum(II)", TransitionMetal, 78, 117, -1, +2, 1772, 3827, false, Stable),
	Pt4				("Pt(IV)", "Platinum(IV)", TransitionMetal, 78, 117, -1, +4, 1772, 3827, false, Stable),

	Au1				("Au(I)", "Gold(I)", TransitionMetal, 79, 118, -1, +1, 1064, 2807, false, Stable),
	Au3				("Au(III)", "Gold(III)", TransitionMetal, 79, 118, -1, +3, 1064, 2807, false, Stable),

	Hg1				("Hg(I)", "Mercury(I)", TransitionMetal, 80, 121, -1, +1, -39, 357, false, Stable),
	Hg2				("Hg(II)", "Mercury(II)", TransitionMetal, 80, 121, -1, +2, -39, 357, false, Stable),

	Tl1				("Tl(I)", "Thallium(I)", PostTransitionMetal, 81, 123, -1, +1, 303, 1457, false, Stable),
	Tl3				("Tl(III)", "Thallium(III)", PostTransitionMetal, 81, 123, -1, +3, 303, 1457, false, Stable),

	Pb				("Lead", PostTransitionMetal, 82, 125, -1, +2, 327, 1740, false, Stable),
	Bi				("Bismuth", PostTransitionMetal, 83, 126, -1, +3, 271, 1560, false, Stable),
	Po				("Polonium", PostTransitionMetal, 84, 125, -1, +4, 254, 962, false, Stable),
	At				("Astatine", Halogen, 85, 125, -1, -1, 302, 337, false, Stable),
	Rn				("Radon", NobleGas, 86, 136, -1, 0, -71, -62, false, Stable),


	// ** PERIOD 7 ** \\

	Fr				("Francium", AlkaliMetal, 87, 136, -1, +1, 27, 677, false, Stable),
	Ra				("Radium", AlkalineEarthMetal, 88, 138, -1, +2, 700, 1737, false, Stable),
	Ac				("Actinium", Actinide, 89, 138, -1, +3, 1050, 3200, false, Stable),
	Th				("Thorium", Actinide, 90, 142, -1, +4, 1750, 4790, false, Stable),
	Pa				("Protactinium", Actinide, 91, 140, -1, +5, 1568, 4027, false, Stable),
	U				("Uranium", Actinide, 92, 146, -1, +6, 1132, 3818, false, Stable),
	Np				("Neptunium", Actinide, 93, 144, -1, +5, 640, 3902, false, Stable),
	Pu				("Plutonium", Actinide, 94, 150, -1, +4, 640, 3235, false, Stable),
	Am				("Americium", Actinide, 95, 148, -1, +3, 994, 2607, false, Stable),
	Cm				("Curium", Actinide, 96, 151, -1, +3, 1340, 3110, false, Stable),
	Bk				("Berkelium", Actinide, 97, 150, -1, +3, 985, -300, false, Stable),
	Cf				("Californium", Actinide, 98, 153, -1, +3, 900, -300, false, Stable),
	Es				("Einsteinium", Actinide, 99, 153, -1, +3, 860, -300, false, Stable),
	Fm				("Fermium", Actinide, 100, 157, -1, +3, 1527, -300, false, Stable),
	Md				("Mendelevium", Actinide, 101, 157, -1, +3, -300, -300, false, Stable),
	No				("Nobelium", Actinide, 102, 157, -1, +2, 827, -300, false, Stable),
	Lr				("Lawrencium", Actinide, 103, 159, -1, +3, 1627, -300, false, Stable),
	Rf				("Rutherfordium", TransitionMetal, 104, 157, -1, +4, -300, -300, false, Stable),
	Db				("Dubnium", TransitionMetal, 105, 163, -1, +5, -300, -300, false, Stable),
	Sg				("Seaborgium", TransitionMetal, 106, 157, -1, +6, -300, -300, false, Stable),
	Bh				("Bohrium", TransitionMetal, 107, 157, -1, +7, -300, -300, false, Stable),
	Hs				("Hassium", TransitionMetal, 108, 161, -1, +8, -300, -300, false, Stable),
	Mt				("Meiterium", UnknownClass, 109, 159, -1, 0, -300, -300, false, Stable),
	Ds				("Darmstadtium", UnknownClass, 110, 162, -1, 0, -300, -300, false, Stable),
	Rg				("Roentgenium", UnknownClass, 111, 162, -1, 0, -300, -300, false, Stable),
	Cn				("Copernicium", TransitionMetal, 112, 165, -1, 0, -300, -300, false, Stable),
	Uut				("Ununtrium", UnknownClass, 113, 173, -1, 0, -300, -300, false, Stable),
	Fl				("Flerovium", UnknownClass, 114, 175, -1, 0, -300, -300, false, Stable),
	Uup				("Ununpentium", UnknownClass, 115, 173, -1, 0, -300, -300, false, Stable),
	Lv				("Livermorium", UnknownClass, 116, 176, -1, 0, -300, -300, false, Stable),
	Uus				("Ununseptium", UnknownClass, 117, 175, -1, 0, -300, -300, false, Stable),
	Uuo				("Ununoctium", UnknownClass, 118, 175, -1, 0, -300, -300, false, Stable),






	// ** COMPOUNDS ** \\

	// ** MONO ELEMENTAL MOLECULES ** \\

	Cl2				("Chlorine", 0, Covalent, new Compound[]{ new Compound(Cl, 2) }, -101, -35, "#80FAFAD2", -1, Stable),
	O3				("Ozone", 0, Covalent, new Compound[]{ new Compound(O, 3) }, -192, -112, "#80F0FFFF", -1, Stable),
	O2				("Oxygen", 0, Covalent, new Compound[]{ new Compound(O, 2) }, -219, -183, "#80F0FFFF", -1, Stable),
	H2				("Hydrogen", 0, Covalent, new Compound[]{ new Compound(H, 2) }, -259, -253, "#80FFFFFF", -1, Stable),




	// ** OXIDES ** \\

	// Neutral Oxides
	H2O				("Water", 0, NeutralOxide, new Compound[]{ new Compound(H, 2), new Compound(O) }, 0, 100, "#8087CEFA", -1, Stable),

	// Acidic Oxides
	CO2				("Carbon Dioxide", 0, AcidicOxide, new Compound[]{ new Compound(C_4), new Compound(O, 2) }, -78, -57, "#80FFFFFF", -1, Stable),
	NO2				("Nitrogen Dioxide", 0, AcidicOxide, new Compound[]{ new Compound(N), new Compound(O, 2) }, -11, 21, "#80FF7F50", -1, Stable),
	SiO2			("Silicon Dioxide", 0, AcidicOxide, new Compound[]{ new Compound(Si), new Compound(O, 2) }, 1663, 2230, "#80F8F8F8", -1, Stable),








	// ** VARIOUS IONS FOR ACIDS ** \\

	// Anions
	iSO4			("Sulphate", -2, Anion, new Compound[]{ new Compound(S6), new Compound(O, 4) }, -300, -300, "", -1, Stable),
	iNO3			("Nitrate", -1, Anion, new Compound[]{ new Compound(N), new Compound(O, 3) }, -300, -300, "", -1, Stable),
	iOH				("Hydroxide", -1, Anion, new Compound[]{ new Compound(O), new Compound(H) }, -300, -300, "", -1, Stable),
	iClO4			("Perchlorate", -1, Anion, new Compound[]{ new Compound(Cl), new Compound(O, 4) }, -300, -300, "", -1, Stable),


	// Cations
	iNH4			("Ammonium", +1, Alkaline, new Compound[]{ new Compound(N, Cation), new Compound(H, 4, Anion) }, -300, -300, "", -1, Stable),





	// ** ACIDS ** \\

	// Strong Acids
	HF				("Hydrofluoric Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),
	HCl				("Hydrochloric Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(Cl, Anion) }, -114, -85, "#40FFFFFF", -1, Stable),
	HBr				("Hydrobromic Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(Br, Anion) }, -42, 83, "#40FFFFFF", -1, Stable),
	HI				("Hydroiodic Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(I, Anion) }, -42, 83, "#40FFFFFF", -1, Stable),
	H2SO4			("Sulphuric Acid", 0, Acidic, new Compound[]{ new Compound(H, 2, Cation), new Compound(iSO4, Anion) }, 10, 337, "#40FFFFFF", -1, Stable),
	HNO3			("Nitric Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(iNO3, Anion) }, -42, 83, "#40FFFFFF", -1, Stable),
	HClO4			("Perchloric Acid", 0, Acidic, new Compound[]{ new Compound(H, Cation), new Compound(iClO4, Anion) }, -42, 83, "#40FFFFFF", -1, Stable),




	// ** BASES ** \\

	// Strong Bases
	LiOH			("Lithium Hydroxide", 0, Alkaline, new Compound[]{ new Compound(Li, Cation), new Compound(iOH, Anion) }, -300, -300, "", -1, Stable),
	NaOH			("Sodium Hydroxide", 0, Alkaline, new Compound[]{ new Compound(Na, Cation), new Compound(iOH, Anion) }, -300, -300, "", -1, Stable),
	KOH				("Potassium Hydroxide", 0, Alkaline, new Compound[]{ new Compound(K, Cation), new Compound(iOH, Anion) }, -300, -300, "", -1, Stable),
	RbOH			("Rubidium Hydroxide", 0, Alkaline, new Compound[]{ new Compound(Li, Cation), new Compound(iOH, Anion) }, -300, -300, "", -1, Stable),
	CsOH			("Cesium Hydroxide", 0, Alkaline, new Compound[]{ new Compound(Li, Cation), new Compound(iOH, Anion) }, -300, -300, "", -1, Stable),




	// ** OTHER COMPOUDNDS OF INTEREST ** \\
	// TODO: Categorise these properly.











	// ** INFINITELY LONG LIST OF SALTS ** \\
	// TODO: Find out a way to use reflection to dyamically fetch a list of compounds from somewhere online.



	// Fluoride Salts
	NH4F			("Ammonium Fluoride", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),

	// Metal Salts
	LiF				("Lithium Fluoride", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),
	NaF				("Sodium Fluoride", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),
	KF				("Potassium Fluoride", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),
	RbF				("Rubidium Fluoride", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),
	CsF				("Caesium Fluoride", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(F, Anion) }, -300, -300, "", -1, Stable),

	BaF2			("Barium Fluoride", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	SrF2			("Strontium Fluoride", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	CaF2			("Calcium Fluoride", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	MgF2			("Magnesium Fluoride", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnF2			("Zinc Fluoride", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2F2			("Chromium(II) Fluoride", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2F2			("Iron(II) Fluoride", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2F2			("Manganese(II) Fluoride", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2F2			("Cobalt(II) Fluoride", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2F2			("Tin(II) Fluoride", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	CdF2			("Cadmium Fluoride", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	NiF2			("Nickel Fluoride", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),
	PbF2			("Lead Fluoride", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(F, 2, Anion) }, -300, -300, "", -1, Stable),

	AlF3			("Aluminium Fluoride", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(F, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3F3			("Iron(III) Fluoride", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(F, 3, Anion) }, -300, -300, "", -1, Stable),







	// Chloride Salts
	NH4Cl			("Ammonium Chloride", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),

	// Metal Salts
	LiCl			("Lithium Chloride", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),
	NaCl			("Sodium Chloride", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),
	KCl				("Potassium Chloride", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),
	RbCl			("Rubidium Chloride", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),
	CsCl			("Caesium Chloride", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(Cl, Anion) }, -300, -300, "", -1, Stable),

	BaCl2			("Barium Chloride", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	SrCl2			("Strontium Chloride", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	CaCl2			("Calcium Chloride", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	MgCl2			("Magnesium Chloride", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnCl2			("Zinc Chloride", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2Cl2			("Chromium(II) Chloride", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2Cl2			("Iron(II) Chloride", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2Cl2			("Manganese(II) Chloride", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2Cl2			("Cobalt(II) Chloride", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2Cl2			("Tin(II) Chloride", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	CdCl2			("Cadmium Chloride", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	NiCl2			("Nickel Chloride", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),
	PbCl2			("Lead Chloride", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(Cl, 2, Anion) }, -300, -300, "", -1, Stable),

	AlCl3			("Aluminium Chloride", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(Cl, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3Cl3			("Iron(III) Chloride", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(Cl, 3, Anion) }, -300, -300, "", -1, Stable),







	// Bromide Salts
	NH4Br			("Ammonium Bromide", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),


	// Metal Salts
	LiBr			("Lithium Bromide", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),
	NaBr			("Sodium Bromide", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),
	KBr				("Potassium Bromide", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),
	RbBr			("Rubidium Bromide", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),
	CsBr			("Caesium Bromide", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(Br, Anion) }, -300, -300, "", -1, Stable),

	BaBr2			("Barium Bromide", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	SrBr2			("Strontium Bromide", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	CaBr2			("Calcium Bromide", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	MgBr2			("Magnesium Bromide", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnBr2			("Zinc Bromide", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2Br2			("Chromium(II) Bromide", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2Br2			("Iron(II) Bromide", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2Br2			("Manganese(II) Bromide", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2Br2			("Cobalt(II) Bromide", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2Br2			("Tin(II) Bromide", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	CdBr2			("Cadmium Bromide", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	NiBr2			("Nickel Bromide", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),
	PbBr2			("Lead Bromide", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(Br, 2, Anion) }, -300, -300, "", -1, Stable),

	AlBr3			("Aluminium Bromide", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(Br, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3Br3			("Iron(III) Bromide", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(Br, 3, Anion) }, -300, -300, "", -1, Stable),


	// Iodide Salts
	NH4I			("Ammonium Iodide", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),


	// Metal Salts
	LiI				("Lithium Iodide", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),
	NaI				("Sodium Iodide", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),
	KI				("Potassium Iodide", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),
	RbI				("Rubidium Iodide", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),
	CsI				("Caesium Iodide", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(I, Anion) }, -300, -300, "", -1, Stable),

	BaI2			("Barium Iodide", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	SrI2			("Strontium Iodide", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	CaI2			("Calcium Iodide", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	MgI2			("Magnesium Iodide", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnI2			("Zinc Iodide", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2I2			("Chromium(II) Iodide", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2I2			("Iron(II) Iodide", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2I2			("Manganese(II) Iodide", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2I2			("Cobalt(II) Iodide", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2I2			("Tin(II) Iodide", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	CdI2			("Cadmium Iodide", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	NiI2			("Nickel Iodide", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),
	PbI2			("Lead Iodide", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(I, 2, Anion) }, -300, -300, "", -1, Stable),

	AlI3			("Aluminium Iodide", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(I, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3I3			("Iron(III) Iodide", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(I, 3, Anion) }, -300, -300, "", -1, Stable),


	// Perchloride Salts
	NH4ClO4			("Ammonium Perchlorate", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),


	// Metal Salts
	LiClO4			("Lithium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),
	NaClO4			("Sodium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),
	KClO4			("Potassium Perchlorate", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),
	RbClO4			("Rubidium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),
	CsClO4			("Caesium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(iClO4, Anion) }, -300, -300, "", -1, Stable),

	BaÄClO4¹2		("Barium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	SrÄClO4¹2		("Strontium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	CaÄClO4¹2		("Calcium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	MgÄClO4¹2		("Magnesium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnÄClO4¹2		("Zinc Perchlorate", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2ÄClO4¹2		("Chromium(II) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2ÄClO4¹2		("Iron(II) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2ÄClO4¹2		("Manganese(II) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2ÄClO4¹2		("Cobalt(II) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2ÄClO4¹2		("Tin(II) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	CdÄClO4¹2		("Cadmium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	NiÄClO4¹2		("Nickel Perchlorate", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),
	PbÄClO4¹2		("Lead Perchlorate", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(iClO4, 2, Anion) }, -300, -300, "", -1, Stable),

	AlÄClO4¹3		("Aluminium Perchlorate", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(iClO4, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3ÄClO4¹3		("Iron(III) Perchlorate", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(iClO4, 3, Anion) }, -300, -300, "", -1, Stable),




	// Nitrate Salts

	// Ä denotes an opening bracket.
	// ¹ denotes a closing bracket.
	// Damn java and its lack of symbols.

	NH4NO3			("Ammonium Nitrate", 0, Ionic, new Compound[]{ new Compound(iNH4, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),


	// Metal Salts
	LiNO3			("Lithium Nitrate", 0, Ionic, new Compound[]{ new Compound(Li, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),
	NaNO3			("Sodium Nitrate", 0, Ionic, new Compound[]{ new Compound(Na, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),
	KNO3			("Potassium Nitrate", 0, Ionic, new Compound[]{ new Compound(K, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),
	RbNO3			("Rubidium Nitrate", 0, Ionic, new Compound[]{ new Compound(Rb, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),
	CsNO3			("Caesium Nitrate", 0, Ionic, new Compound[]{ new Compound(Cs, Cation), new Compound(iNO3, Anion) }, -300, -300, "", -1, Stable),
	BaÄNO3¹2		("Barium Nitrate", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	SrÄNO3¹2		("Strontium Nitrate", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	CaÄNO3¹2		("Calcium Nitrate", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	MgÄNO3¹2		("Magnesium Nitrate", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	Mn$2ÄNO3¹2		("Manganese(II) Nitrate", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	Fe$2ÄNO3¹2		("Iron(II) Nitrate", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	Co$2ÄNO3¹2		("Cobalt(II) Nitrate", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	Sn$2ÄNO3¹2		("Tin(II) Nitrate", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	ZnÄNO3¹2		("Zinc Nitrate", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	Cr$2ÄNO3¹2		("Chromium(II) Nitrate", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	CdÄNO3¹2		("Cadmium Nitrate", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	NiÄNO3¹2		("Nickel Nitrate", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),
	PbÄNO3¹2		("Lead Nitrate", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(iNO3, 2, Anion) }, -300, -300, "", -1, Stable),

	AlÄNO3¹3		("Aluminium Nitrate", 0, Ionic, new Compound[]{ new Compound(Al, Cation), new Compound(iNO3, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$3ÄNO3¹3		("Iron(III) Nitrate", 0, Ionic, new Compound[]{ new Compound(Fe3, Cation), new Compound(iNO3, 3, Anion) }, -300, -300, "", -1, Stable),


	// Sulphate Salts
	ÄNH4¹2SO4		("Ammonium Sulphate", 0, Ionic, new Compound[]{ new Compound(iNH4, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),


	// Metal Salts
	Li2SO4			("Lithium Sulphate", 0, Ionic, new Compound[]{ new Compound(Li, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Na2SO4			("Sodium Sulphate", 0, Ionic, new Compound[]{ new Compound(Na, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	K2SO4			("Potassium Sulphate", 0, Ionic, new Compound[]{ new Compound(K, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Rb2SO4			("Rubidium Sulphate", 0, Ionic, new Compound[]{ new Compound(Rb, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Cs2SO4			("Caesium Sulphate", 0, Ionic, new Compound[]{ new Compound(Cs, 2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),

	BaSO4			("Barium Sulphate", 0, Ionic, new Compound[]{ new Compound(Ba, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	SrSO4			("Strontium Sulphate", 0, Ionic, new Compound[]{ new Compound(Sr, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	CaSO4			("Calcium Sulphate", 0, Ionic, new Compound[]{ new Compound(Ca, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	MgSO4			("Magnesium Sulphate", 0, Ionic, new Compound[]{ new Compound(Mg, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	ZnSO4			("Zinc Sulphate", 0, Ionic, new Compound[]{ new Compound(Zn, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Cr$2SO4			("Chromium(II) Sulphate", 0, Ionic, new Compound[]{ new Compound(Cr2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Fe$2SO4			("Iron(II) Sulphate", 0, Ionic, new Compound[]{ new Compound(Fe2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Mn$2SO4			("Manganese(II) Sulphate", 0, Ionic, new Compound[]{ new Compound(Mn2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Co$2SO4			("Cobalt(II) Sulphate", 0, Ionic, new Compound[]{ new Compound(Co2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	Sn$2SO4			("Tin(II) Sulphate", 0, Ionic, new Compound[]{ new Compound(Sn2, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	CdSO4			("Cadmium Sulphate", 0, Ionic, new Compound[]{ new Compound(Cd, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	NiSO4			("Nickel Sulphate", 0, Ionic, new Compound[]{ new Compound(Ni, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),
	PbSO4			("Lead Sulphate", 0, Ionic, new Compound[]{ new Compound(Pb, Cation), new Compound(iSO4, Anion) }, -300, -300, "", -1, Stable),

	Al2ÄSO4¹3		("Aluminium Sulphate", 0, Ionic, new Compound[]{ new Compound(Al, 2, Cation), new Compound(iSO4, 3, Anion) }, -300, -300, "", -1, Stable),
	Fe$32ÄSO4¹3		("Iron(III) Sulphate", 0, Ionic, new Compound[]{ new Compound(Fe3, 2, Cation), new Compound(iSO4, 3, Anion) }, -300, -300, "", -1, Stable),












	UnknownC		("Unknown Compound", 0, UnknownClass, new Compound[]{ new Compound(Uuo, 1) }, -300, -300, "", -1, Stable);






	private final String ReadableName;
	private final String ShortName;
	private final EnumClassificationList Classification;
	private final int IonicCharge;

	private final int BoilingPoint;
	private final int MeltingPoint;

	private final String HexColour;

	private final List<Compound> Components = new ArrayList<Compound>();

	private final int AtomicNumber;
	private final int NeutronNumber;
	private final int HalfLife;
	private final boolean IsIsotope;
	private final EnumClassificationList RadState;


	public final static EnumCompoundList[] Compounds = values();

	private static String GetColour(EnumClassificationList c)
	{
		String hex = "";
		switch(c)
		{
			case Actinide:
				hex = "#FFD3D3D3";
				break;

			case AlkaliMetal:
				hex = "#FFC0C0C0";
				break;

			case AlkalineEarthMetal:
				hex = "#FFC0C0C0";
				break;

			case Halogen:
				hex = "#80FFFAFA";
				break;

			case NobleGas:
				hex = "#40FFF5EE";
				break;

			case Lanthanide:
				hex = "#FFC0C0C0";
				break;

			case NonMetal:
				hex = "#FF708090";
				break;

			case PostTransitionMetal:
				hex = "#FFC0C0C0";
				break;

			case Metalloid:
				hex = "#FFC0C0C0";
				break;

			case TransitionMetal:
				hex = "#FFC0C0C0";
				break;

			default:
				hex = "#FFF4A460";
				break;
		}

		return hex;
	}


	// Element that may need more than one oxidation state, eg. C, Mn etc.
	private EnumCompoundList(String ShortName, String FullName, EnumClassificationList Classification, int AtomicNumber, int NeutronNumber, int HalfLife,
					int IonicCharge, int MeltingPoint, int BoilingPoint, boolean IsIsotope, EnumClassificationList RadState)
	{
		this.ShortName = ShortName;
		this.ReadableName = FullName;
		this.Classification = Classification;

		this.AtomicNumber = AtomicNumber;
		this.NeutronNumber = NeutronNumber;
		this.HalfLife = HalfLife;

		this.MeltingPoint = MeltingPoint;
		this.BoilingPoint = BoilingPoint;
		this.IsIsotope = IsIsotope;


		this.RadState = RadState;

		this.IonicCharge = IonicCharge;
		this.HexColour = GetColour(this.Classification);
	}

	// Typical element with one common oxidation state
	private EnumCompoundList(String FullName, EnumClassificationList Classification, int AtomicNumber, int NeutronNumber, int HalfLife,
					int IonicCharge, int MeltingPoint, int BoilingPoint, boolean IsIsotope, EnumClassificationList RadState)
	{
		this.ShortName = "";
		this.ReadableName = FullName;
		this.Classification = Classification;

		this.AtomicNumber = AtomicNumber;
		this.NeutronNumber = NeutronNumber;
		this.HalfLife = HalfLife;

		this.MeltingPoint = MeltingPoint;
		this.BoilingPoint = BoilingPoint;
		this.IsIsotope = IsIsotope;


		this.RadState = RadState;

		this.IonicCharge = IonicCharge;
		this.HexColour = GetColour(this.Classification);
	}

	// Run-of-the-mill polyatomic compounds.
	private EnumCompoundList(String name, int IonicCharge, EnumClassificationList classification, Compound[] Components,	int MeltingPoint, int BoilingPoint,
					String HexColour, int HalfLife, EnumClassificationList RadState)
	{
		this.ShortName = name();
		this.ReadableName = name;
		this.Classification = classification;
		this.IonicCharge = IonicCharge;

		this.MeltingPoint = MeltingPoint;
		this.BoilingPoint = BoilingPoint;

		this.HexColour = HexColour;
		this.RadState = RadState;

		this.NeutronNumber = 0;
		this.AtomicNumber = 0;
		this.IsIsotope = false;
		this.HalfLife = HalfLife;

		for(Compound C : Components)
			this.Components.add(C);
	}

	public String GetShortName()
	{
		if(this.ShortName == "")
			return RChemHelper.ConvertToUnicode(this.GetChemName());

		return this.GetChemName();
	}

	public String GetFullName()
	{
		return this.ReadableName;
	}

	public List<Compound> GetComponents()
	{
		if(this.IsElement())
		{
			List<Compound> ret = new ArrayList<Compound>();
			ret.add(new Compound(this, 1));
			return ret;
		}
		else
			return this.Components;
	}

	public int GetMeltingPoint()
	{
		return this.MeltingPoint;
	}

	public int GetBoilingPoint()
	{
		return this.BoilingPoint;
	}

	public EnumClassificationList GetClassification()
	{
		return this.Classification;
	}

	public String GetHexColour()
	{
		if(this.HexColour == "")
			return "#FFC0C0C0";

		else
			return this.HexColour;
	}


	// Element funcs
	public String GetChemName()
	{
		if(RChemHelper.ContainsDigit(this.name()) && this.IsElement())
			return this.name().substring(0, this.name().length() - 1);
		else if(this.name().contains("¹") || this.name().contains("Ä"))
		{
			String ret = this.name();

			// eliminate the dollar signs we use for oxidation states
			// replace the symbols we use for brackets.
			ret.replaceAll("$", "");
			ret.replaceAll("Ä", "(");
			ret.replaceAll("¹", ")");

			return ret;
		}
		else
			return this.name();
	}



	public int GetAtomicNumber()
	{
		return this.AtomicNumber;
	}

	public int GetNeutronNumber()
	{
		return this.NeutronNumber;
	}

	public int GetHalfLife()
	{
		return this.HalfLife;
	}

	public boolean GetIsIsotope()
	{
		return this.IsIsotope;
	}

	public EnumClassificationList GetRadiationState()
	{
		return this.RadState;
	}

	public boolean IsElement()
	{
		return this.Components.isEmpty();
	}

	public int GetIonicCharge()
	{
		return this.IonicCharge;
	}
}







