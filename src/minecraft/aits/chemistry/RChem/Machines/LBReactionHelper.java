package requimrar.Minecraft.RChem.Machines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

import requimrar.Minecraft.RChem.EnumRecipeList;
import requimrar.Minecraft.RChem.Compound;
import requimrar.Minecraft.RChem.RChemMod;
import requimrar.Minecraft.RChem.EnumCompoundList;
import requimrar.Minecraft.RChem.EnumCompoundList.*;
import requimrar.Minecraft.RChem.Item.ItemCompound;
import requimrar.Minecraft.RChem.Item.RChemItem;
import requimrar.Minecraft.RChem.Machines.LabBench.TileLabBench;
import requimrar.Minecraft.RChem.RChemHelper;

import com.google.common.primitives.Ints;

import static requimrar.Minecraft.RChem.EnumClassificationList.*;
import static requimrar.Minecraft.RChem.EnumCompoundList.*;

public class LBReactionHelper
{
	private static List<Compound> RecursionHelpList = new ArrayList<Compound>();
	private static ItemStack[] inventory;
	private static TileLabBench t;
	private static boolean DidFailPreviously = false;

	public static void ReactLabBench(ItemStack[] inv, TileLabBench te)
	{
		ItemStack stack1;
		ItemStack stack2;

		ItemStack R1;
		ItemStack R2;
		int R1Count;
		int R2Count;
		int I1Count;
		int I2Count;

		List<Compound> Inputs = new ArrayList<Compound>();

		inventory = inv;
		t = te;

		NextReaction:
			for(int i = 0; i < inventory.length; i++)
			{
				stack1 = inventory[i];

				if(stack1 == null)
					continue;


				if(stack1.getItem() instanceof ItemCompound)
				{
					// Look around
					for(int size = 0; size < stack1.stackSize; size++)
					{
						if(((RChemItem)stack1.getItem()).CanConnectOnBottom())
						{
							// look down
							// sanity check
							if(i < 83)
							{
								//						reactant = (RChemItem) t.getStackInSlot(i + 12).getItem();
								stack2 = inventory[i + 12];
								if(stack2 == null)
								{
									continue NextReaction;
								}


								//								String CombinedClass = ItemCompound.GetCompoundFromIS(itemstack).GetClassification().ClassDescription() +
								//												ItemCompound.GetCompoundFromIS(ReactantStack).GetClassification().ClassDescription();
								//
								//								if(CombinedClass.contains("AcidAlkali") || CombinedClass.contains("AlkaliAcid"))
								//								{
								//									// Neutralisation Reaction.
								//
								//									ListR1 = new ArrayList<ICompound>();
								//									ListR2 = new ArrayList<ICompound>();
								//
								//									ListR1.addAll(ItemCompound.GetCompoundFromIS(itemstack).GetComponents());
								//									ListR2.addAll(ItemCompound.GetCompoundFromIS(ReactantStack).GetComponents());
								//
								//									ListRE1 = SimplifyComponents(ListR1);
								//									ListRE2 = SimplifyComponents(ListR2);
								//
								//
								//
								//									R1Count = 1;
								//									R2Count = 1;
								//
								//
								//									// Find the cations
								//									ICompound C1 = FindCation(ListR1);
								//									ICompound C2 = FindCation(ListR2);
								//
								//									// Find the anions
								//									ICompound A1 = FindAnion(ListR1);
								//									ICompound A2 = FindAnion(ListR2);
								//
								//									// We gotta make sure the charges are the same...
								//
								//									int I1Count = 0;
								//									int I2Count = 0;
								//
								//									if(C2.Compound.GetIonicCharge() * C2.Count == (-A1.Compound.GetIonicCharge()) * A1.Count)
								//									{
								//										I1Count = 1;
								//										I2Count = 1;
								//										ListRE1.set(ListRE1.indexOf(C1), C2);
								//									}
								//									if(C1.Compound.GetIonicCharge() * C1.Count == (-A2.Compound.GetIonicCharge()) * A2.Count)
								//									{
								//										I1Count = 1;
								//										I2Count = 1;
								//										ListRE2.set(ListRE1.indexOf(C2), C1);
								//									}
								//
								//									else if(C2.Compound.GetIonicCharge() * C2.Count != (-A1.Compound.GetIonicCharge() * A1.Count) ||
								//													C1.Compound.GetIonicCharge() * C1.Count != (-A2.Compound.GetIonicCharge()) * A2.Count)
								//									{
								//										// for NaOH + H2SO4 example.
								//
								//										// lcm1 = LCM(2, -(-1)) = LCM(2, 1) = 2
								//										// lcm2 = LCM(1, -(-2)) = LCM(1, 2) = 2
								//
								//										// HBr + Ba(OH)2 = BaBr2 + H2O
								//
								//										// 2HBr + Ba(OH)2 = BaBr2 + 2H2O
								//
								//										// lcm1 = LCM(2, 1) = 2
								//										// lcm2 = LCM(1, 2) = 2
								//
								//
								//										int lcm1 = RChemHelper.CalculateLCM(C2.Compound.GetIonicCharge() * C2.Count, (-A1.Compound.GetIonicCharge()) * A1.Count);
								//										int lcm2 = RChemHelper.CalculateLCM(C1.Compound.GetIonicCharge() * C1.Count, (-A2.Compound.GetIonicCharge()) * A2.Count);
								//
								//										// 2
								//										int NeededR1 = (C1.Compound.GetIonicCharge() * C1.Count) / lcm1;
								//
								//										// 1
								//										int NeededR2 = (C2.Compound.GetIonicCharge() * C2.Count) / lcm2;
								//
								//										List<ICompound> Input1 = new ArrayList<ICompound>();
								//										List<ICompound> Input2 = new ArrayList<ICompound>();
								//
								//										if(NeededR1 <= itemstack.stackSize)
								//										{
								//											// make sure that the itemstack is big enough
								//											itemstack.stackSize -= NeededR1;
								//											for(int x = 0; x < NeededR1; x++)
								//											{
								//												Input1.addAll(ListRE1);
								//											}
								//
								//											// H, H, Br, Br = H, H, Br, Br
								//											Input1 = SimplifyComponents(Input1);
								//										}
								//										else
								//											continue NextReaction;
								//
								//										if(NeededR2 <= ReactantStack.stackSize)
								//										{
								//											ReactantStack.stackSize -= NeededR2;
								//											for(int x = 0; x < NeededR2; x++)
								//											{
								//												Input2.addAll(ListRE2);
								//											}
								//
								//											// Ba, O, H, O, H = Ba, O, H, O, H
								//											Input2 = SimplifyComponents(Input2);
								//										}
								//										else
								//											continue NextReaction;
								//
								//										// By now, if anything wasn't enough it should have returned.
								//										// we need to combine the compounds...
								//
								//										Input1 = CombineCompounds(Input1);
								//										Input2 = CombineCompounds(Input2);
								//
								//										ICompound NC1 = FindCation(Input1);
								//										ICompound NC2 = FindCation(Input2);
								//
								//										ListRE1.clear();
								//										ListRE2.clear();
								//
								//										ListRE1.addAll(Input1);
								//										ListRE2.addAll(Input2);
								//
								//										System.out.println(NC1.Compound.GetChemName());
								//										System.out.println(NC2.Compound.GetChemName());
								//
								//										ListRE1.set(ListRE1.indexOf(NC1), NC2);
								//										ListRE2.set(ListRE2.indexOf(NC2), NC1);
								//									}



								// Add the current itemstack and the one below this
								// as inputs.


								NextRecipe:
									for(EnumRecipeList l : EnumRecipeList.values())
									{
										for(Compound c : l.GetInputs())
										{
											if(c.Compound.GetChemName() != ItemCompound.GetCompoundFromIS(stack1).GetChemName() &&
															c.Compound.GetChemName() != ItemCompound.GetCompoundFromIS(stack2).GetChemName())
												continue NextRecipe;
										}

										System.out.println("Found");

										if(stack1.stackSize < l.GetInputs().get(0).Count || stack2.stackSize < l.GetInputs().get(1).Count)
											continue NextRecipe;


										List<Integer> InputSub = new ArrayList<Integer>();
										List<ItemStack> Outputs = new ArrayList<ItemStack>();

										InputSub.add(l.GetInputs().get(0).Count * l.GetConsumptionRate());
										InputSub.add(l.GetInputs().get(1).Count * l.GetConsumptionRate());

										for(Compound oc : l.GetProducts())
										{
											Outputs.add(new ItemStack(RChemMod.CompoundMetaItem, oc.Count, oc.Compound.ordinal()));
										}

										PlaceItemsInInv(i, Outputs, InputSub);
										continue NextReaction;


									}

								continue NextReaction;
							}
						}
					}
				}
			}
	}

	private static int FindFreeSlot()
	{
		for(int x = 0; x < t.getSizeInventory(); x++)
		{
			if(t.getStackInSlot(x) == null)
				return x;
		}

		return -1;
	}

	private static void PlaceItemsInInv(int i, List<ItemStack> Outputs, List<Integer> InputSubtraction)
	{
		// First, subtract the required amounts from the itemstacks.
		// FIXME:
		// TODO: Handle more than 2 inputs
		// XXX:


		if(t.getStackInSlot(i).stackSize > InputSubtraction.get(0))
			t.getStackInSlot(i).stackSize -= InputSubtraction.get(0);

		else
			t.setInventorySlotContents(i, null);

		if(t.getStackInSlot(i + 12).stackSize > InputSubtraction.get(1))
			t.getStackInSlot(i + 12).stackSize -= InputSubtraction.get(1);

		else
			t.setInventorySlotContents(i + 12, null);


		int z = i + 24;

		for(ItemStack out : Outputs)
		{
			if(z < 108)
			{
				if(t.getStackInSlot(z) == null)
					t.setInventorySlotContents(z, out);

				else if(t.getStackInSlot(z).isItemEqual(out))
				{
					if(t.getStackInSlot(z).stackSize + out.stackSize <= 64)
					{
						t.setInventorySlotContents(z, new ItemStack(t.getStackInSlot(z).getItem(), t.getStackInSlot(z).stackSize +
										out.stackSize, out.getItemDamage()));
					}

					else
					{
						t.setInventorySlotContents(z, new ItemStack(t.getStackInSlot(z).getItem(), 64, out.getItemDamage()));
						// try to put the extra below.
						if(z + 12 < 108)
						{
							if(t.getStackInSlot(z + 12) == null)
							{
								t.setInventorySlotContents(z + 12, out);
								continue;
							}

							else if(t.getStackInSlot(z + 12).isItemEqual(out))
							{
								if(t.getStackInSlot(z).stackSize + out.stackSize <= 64)
								{
									t.setInventorySlotContents(z, new ItemStack(t.getStackInSlot(z).getItem(), t.getStackInSlot(z).stackSize +
													out.stackSize, out.getItemDamage()));
									z++;
									continue;
								}
							}
						}


						int s = FindFreeSlot();
						if(s > 0)
							t.setInventorySlotContents(s, new ItemStack(out.getItem(), (t.getStackInSlot(z).stackSize + out.stackSize) - 64, out.getItemDamage()));

						else
							return;
					}
				}
			}

			else
			{
				int s = FindFreeSlot();

				if(s > 0)
					t.setInventorySlotContents(s, out);

				else
					return;

				continue;
			}
			z++;
		}

		return;
	}

	private static List<Compound> CombineCompounds(List<Compound> list)
	{
		for(int x = 0; x < list.size(); x++)
		{
			for(int y = x; y < list.size(); y++)
			{
				if(((Compound)list.toArray()[x]).Compound == ((Compound)list.toArray()[y]).Compound)
				{
					list.get(x).Count += list.get(y).Count;
					list.get(y).Count = 0;
				}
			}
		}

		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x).Count == 0)
				list.remove(x);
		}

		return list;
	}

	private static List<Compound> SplitElements(List<Compound> list)
	{
		List<Compound> ret = new ArrayList<Compound>();

		for(Compound e : list)
		{
			if(e.Count == 1)
				ret.add(e);

			else
			{
				for(int i = 0; i < e.Count; i++)
				{
					ret.add(new Compound(e.Compound, 1, e.Charge));
				}
			}
		}

		return ret;
	}

	private static void SplitCompounds(Compound c)
	{
		// Split every compound recursively into a it's components, until everything consists
		// of elements only.
		// This will add to the global list.
		for(Compound chem : c.Compound.GetComponents())
		{
			if(chem.Compound.IsElement())
				RecursionHelpList.add(chem);

			else
				SplitCompounds(chem);
		}
	}

	// Simplifies a list of compounds into its elemental components
	public static List<Compound> SimplifyComponents(List<Compound> list)
	{
		// the onus is on the caller to call this before using things like search...

		// for each compound...
		// Basically, we split the components up.

		List<Compound> ret = new ArrayList<Compound>();

		for(Compound c : list)
		{
			if(c.Compound.IsElement())
				ret.add(c);

			else
				SplitCompounds(c);
		}

		for(Compound e : RecursionHelpList)
		{
			ret.add(e);
		}
		RecursionHelpList.clear();
		ret = SplitElements(ret);

		return ret;
	}

	public static Compound FindCation(List<Compound> list)
	{
		for(Compound c : list)
		{
			if(c.Charge == Cation)
				return c;
		}
		return null;
	}
	public static Compound FindAnion(List<Compound> list)
	{
		for(Compound c : list)
		{
			if(c.Charge == Anion)
				return c;
		}
		return null;
	}

	public static EnumCompoundList SearchCompoundByComponent(List<Compound> components)
	{
		Collections.sort(components, new RChemHelper.ECompare());
		List<Integer> cs = new ArrayList<Integer>();


		SkipCompound:
			for(EnumCompoundList c : EnumCompoundList.Compounds)
			{
				RecursionHelpList.clear();
				RecursionHelpList.addAll(SplitElements(SimplifyComponents(c.GetComponents())));

				Collections.sort(RecursionHelpList, new RChemHelper.ECompare());



				for(int i = 0; i < RecursionHelpList.size(); i++)
				{
					if((components.get(i).Compound == RecursionHelpList.get(i).Compound) && components.size() == RecursionHelpList.size())
						continue;

					else
						continue SkipCompound;
				}


				RecursionHelpList.clear();
				return c;
			}

		// try more before giving up..
		// simplify the components this time.
		if(DidFailPreviously)
		{
			DidFailPreviously = false;
			return EnumCompoundList.UnknownC;
		}

		// try to divide everything by a common denominator.
		List<Integer> counts = new ArrayList<Integer>();

		for(Compound c : components)
			counts.add(c.Count);

		int GCF = RChemHelper.CalculateGCD(Ints.toArray(counts));

		for(Compound c : components)
			c.Count /= GCF;

		DidFailPreviously = true;
		return SearchCompoundByComponent(components);
	}

	public static EnumCompoundList SearchCompoundByReadableName(String readablename)
	{
		for(EnumCompoundList c : EnumCompoundList.values())
		{
			if(c.GetFullName() == readablename || c.GetShortName() == readablename)
				return c;
		}
		return EnumCompoundList.UnknownC;
	}

	public static EnumCompoundList SearchCompoundByChemicalFormula(String formula)
	{
		return null;
	}

	/*													else

//	 Check if there is a recipe containing one of their compounds.
//	 Note: ICompound(O3) and ICompound(O2) are never used except for actual ozone and oxygen.

//	 For every compound...

SkipCompound:
	for(int c0 = 0; c0 < RChemCompoundEnums.Compounds.length; c0++)
	{
		// For every component of that compound...
		for(int c1 = 0; c1 < RChemCompoundEnums.Compounds[c0].GetComponents().size(); c1++)
		{
			// For every component of this compound...
			for(int c2 = 0; c2 < RChemCompoundItem.GetCompoundFromIS(itemstack).GetComponents().size(); c2++)
			{
				ThisComponent = (IChemical) RChemCompoundItem.GetCompoundFromIS(itemstack).GetComponents().toArray()[c2];

				// And every component of the reactant compound...
				for(int c3 = 0; c3 < RChemCompoundItem.GetCompoundFromIS(ReactantStack).GetComponents().size(); c3++)
				{
					ReactantComponent = (IChemical) RChemCompoundItem.GetCompoundFromIS(ReactantStack).GetComponents().toArray()[c3];


					// Check if they contain the components required for the result Compounds[c0].
					if(!RChemCompoundEnums.Compounds[c0].GetComponents().contains(ThisComponent) &&
									!RChemCompoundEnums.Compounds[c0].GetComponents().contains(ReactantComponent))
					{
						// Neither reactant contains the stuff required for this compound, let's quit.
						continue SkipCompound;
					}

				}
			}
		}

		// If we got all the way here... the compound can be made, we just need some final checks.

		// First, get the type of reaction by combining their two classifications,
	 */


}
