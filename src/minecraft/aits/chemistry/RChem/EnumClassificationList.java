package requimrar.Minecraft.RChem;



public enum EnumClassificationList
{
	// Classes
	AlkaliMetal				("Alkali Metal"),
	AlkalineEarthMetal		("Alkaline Earth Metal"),
	Lanthanide				("Lanthanide"),
	Actinide				("Actinide"),
	TransitionMetal			("Transition Metal"),
	PostTransitionMetal		("Post-Transition Metal"),
	Metalloid				("Metalloid"),
	NonMetal				("Non-metal"),
	Halogen					("Halogen"),
	NobleGas				("Noble Gas"),
	Unknown					("Unknown"),

	// States
	Solid					("Solid"),
	Liquid					("Liquid"),
	Gas						("Gas"),
	Aqueous					("Aqueous Solution"),

	// Radiation types
	Stable					("Stable"),
	Alpha					("Alpha"),
	Beta					("Beta"),
	Gamma					("Gamma"),

	// Metal Reactivity
	Reactive				("Reactive Metal"),
	NotReactive				("Non-reactive Metal"),

	// Alkali/Acid
	Acidic					("Acid"),
	WeakAcidic				("Weak Acid"),
	Alkaline				("Alkali"),
	WeakAlkaline			("Weak Alkali"),
	Neutral					("Neutral"),

	// For oxides
	BasicOxide				("Basic Oxide"),
	AcidicOxide				("Acidic Oxide"),
	NeutralOxide			("Neutral Oxide"),
	AmphotericOxide			("Amphoteric Oxide"),


	// Solubility in Water
	SolubleInWater			("Soluble in water"),
	NotSolubleInWater		("Not soluble in water"),

	// Bonds/Charges
	Cation					("Cation (+)"),
	Anion					("Anion (-)"),
	Covalent				("Covalent"),
	Ionic					("Ionic"),


	NotApplicable			("N/A"),
	UnknownClass			("Unknown");



	private final String ClassDescription;
	private EnumClassificationList(String str)
	{
		this.ClassDescription = str;
	}

	public String ClassDescription()
	{
		return this.ClassDescription;
	}
}
