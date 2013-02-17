RChem Mod


ASDFASDJF

---------

--> Machines
	--> Lab Table
		- Allows various items to be placed in it's inventory (similar to IC2's Nuclear Reactor) to interact with each other.
		- Similarly, bigger tables (more blocks) allow for more space in the reaction area.

		- Mechanics:
			--> Must be set up like IRL; FilterPaper should be above Filters, which in turn should be above a Beaker etc.
			--> A Lever and a WaterBucket can be crafted together to make a water tap. They can be used on the table with a Container{ Beaker/Flask/MeasuringCylinder/Bottle/Cell/TestTube } to get water, infintely. Not buckets.
			--> Items gotten from Filters (precipitates, powders) will take the place of the filter paper, destroying it.
			--> Liquid Products must be collected in a Container, or the set up will not work.
			--> Containers with liquids inside cannot be taken away from the table. An attempt to close the inventory with a liquid container still inside (not on the table) will result in it being dropped (use slash potion effect), destroying it.
				- In addition, caustics will cause damage to players, similar to splash potions
					--> Damage dealt is calculated by (Concentration[nearest10%] / 10) (2 Damage = 1 Heart) for strong caustics, (Concentration[nearest10%] / 10 - 7) damage for weak caustics.
						- 99% HCl will deal (100/10) = 10 damage = 5 hearts.

			--> Containers with liquids must be placed above a Filter (without paper) above a cell to be safely collected.

			--> Substance creation (by mixing)
				- Mix items by stacking them directly above one another, with a filter in between. The mixing will occur immediately. Both items need to be in a valid Container (not bucket) to work.
				- Precipitates and solids collected will be placed at the bottom left corner of the table. If the table is full, they will drop to the ground.
					--> Examples:
						- Acid/Alkali creation
							--> Acids/Alkalies of varying concentration can be created.
								- Stacking combining more of the acidic/alkaline compound with the acid will increase the concentration by 10%, up to 99%.
								- Mixing 2 acids will work as well.
									--> Example:
										- HCl(HydrogenChlorideGas)Container + H2O(Water)Container -> HCl(HydrochloricAcid)[1%]
										- HCl(HydrogenChlorideGas) + HCl(HydrochloricAcid)[1%] -> HCl(HydrochloricAcid)[10%]
										- HCl(HydrogenChlorideGas) + HCl(HydrochloricAcid)[10%] -> HCl(HydrochloricAcid)[20%]
										...
										- HCl(HydrogenChlorideGas) + HCl(HydrochloricAcid)[90%] -> HCl(HydrochloricAcid)[99%]

								- Acids/alkalies can be diluted by mixing an existing acid/alkali Container with a Container of water. This functions similarly to increasing concentration, just in reverse. (Yes, the water will be lost. Simply collect more! [Taps are great])

		- Possible recipes:
			--> Beaker + Heat source + Water + SaltpetreDust -> SaltpetreSolution
				- HotSaltpetreSolution(100C+) + K2CO3(WoodAsh) -> KNO3SolutionWithPrecipitate
																  {
																		AqueousKNO3(PotassiumNitrate)
																		CaCO3Precipitate(CalciumCarbonate)
																		K2CO3Precipitate(PotassiumCarbonate)
																  }

			--> Filter + FilterPaper + Beaker + SolutionWithPrecipitate
				- SolutionInBeaker + Precipitate(s)[AsResult]

			--> Acid + Base -> Salt + H2O(Water)
			--> Acid + Carbonate -> Salt + Water + CO2(CarbonDioxideGas)
			--> Acid + ReactiveMetal -> Salt + H2(HydrogenGas)

			--> Base + AmmoniumSalt -> NH3(AmmoniaGas) + Salt + H2O(Water)


			--> Acidic (NonMetal) Oxide + H2O(Water) -> Acid
			--> Basic (Metal) Oxide + H2O(Water) -> Base
			--> Basic (Metal) Oxide + Acid -> Salt + H2O(Water)

			--> AmphotericOxide(Zn,Al,Pb) + Acid -> Salt + H2O(Water)
			--> AmphotericOxide(Zn,Al,Pb) + Base -> Salt + H2O(Water)


	--> Environmental Collector
		- Uses small amounts of power to generate elements from, literally, THIN AIR!
		- Requires AirTightContainers{ Cell/TestTube } to collect.
		- Collects one Container's worth of element every 30 seconds.
		- Use GUI to select which elements to collect;
			--> One of the 5 elements below is generated every 30 seconds (with matching probability); if it matches the selected one, it is output. Else, it is discarded.
			--> The probablility of successfully collecting the element depends on it's composition in the atmosphere; (Note, some values have been messed with (most notably WaterVapour and HydrogenGas) to let the total be 100%, and to help early-game accessiblity of some items)
				- N2(NitrogenGas) -> 78%
				- O2(OxygenGas) -> 21%
				- Ar(ArgonGas) -> 0.9%
				- H20(WaterVapour) -> 0.06%
				- CO2(CarbonDioxideGas) -> 0.039%
				- H2(HydrogenGas) -> 0.001%


	--> Optical Microscope
		- Allows player to see composition of the most basic, organic-based items (eg. wood, sand etc)
		- Does not show synthesis recipe.
		- Placed in world, no power required.


	--> Scanning Electron Microscope
		- Allows players to see composition of all organic-based items.
		- Shows synthesis recipe for optical microscope-scannable items only.
		- Requires power.


	--> Scanning Tunnelling Microscope
		- Allows players to see composition of all items.
		- Shows synthesis recipe for scanning-electron-microscope-scannable items.
		- Requires high amounts of power.


	--> Advanced Quantum Tunnel Drill Nanoscope
		- Allows players to see composition of all items and elements.
		- Shows synthesis recipe for all items.
		- Requires insane amounts of power.
		- Destroys sample in the process (no, you can't retrieve the items)


	--> Heat Fermenter
		- Produces items by slowly heating them
		- Requires minute amounts of energy, or small amounts of fuel
		- Possible recipes:
			--> Logs -> Wood Ash (K2NO3)


	--> Basic Synthesis Machine
		- Allows recipes recorded (either by hand, or notebook) to be synthesised.
		- Only allows recipes gotten from Scanning Electron Microscopes to be synthesised. (Only a small subset of them, to be precise)
		- Works *very* slowly, based mechanical systems.
		- Only works on particle/granular scale/itemic.
		- Compression Chamber (compressing/mechanical force) & Heating Chamber (using fuel)
			--> Possible restrictions:
				- Bones+Water + SlimeBall -> RottenFlesh								(Via Heating)
				- Seeds + Dirt -> Grass
				- RottenFlesh + Sugar -> RawPorkchops
				- RottenFlesh + Bones -> Leather										(Via Heating)
				- Snowballs + Clay+ RoseRed -> RedstoneDust								(Via Heating)
				- WoodAsh(K2NO3) + ProcessedSaltpetre(KNO3) + Charcoal -> Gunpowder		(Via Heating)

		- Chance (~5%) to lose item in the process.
		- Low - Moderate power draw (depending on number of elements/compounds to combine)

	--> Chemical Synthesis Machine
		- Allows recipes from both scanning microscopes to be synthesised.
		- Works at slow-moderate speed (depending on number of elements/compounds to combine)
		- Works on molecular/cellular scale
		- Compression Chamber, Heating Chamber and














