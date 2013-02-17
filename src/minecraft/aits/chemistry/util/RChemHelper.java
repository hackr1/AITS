package aits.chemistry.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import aits.chemistry.machines.labbench.TileLabBench;

public class RChemHelper
{

	public static List<TileLabBench>	LabBenches	= new ArrayList<TileLabBench>();


	public static class ECompare implements Comparator<Compound>
	{
		@Override
		public int compare(Compound e1, Compound e2)
		{
			return e1.Compound.GetAtomicNumber() - e2.Compound.GetAtomicNumber();
		}
	}

	public static float translateValue(float value, float leftMin, float leftMax, float rightMin, float rightMax)
	{
		float leftRange = leftMax - leftMin;
		float rightRange = rightMax - rightMin;
		float valueScaled = (value - leftMin) / leftRange;
		return rightMin + valueScaled * rightRange;
	}

	public static boolean ContainsDigit(String s)
	{
		boolean containsDigit = false;

		if (s != null)
			for (char c : s.toCharArray())
				if (Character.isDigit(c))
				{
					containsDigit = true;
					break;
				}
		return containsDigit;
	}

	public static String ConvertToUnicode(String s)
	{
		boolean DidFindOxidation = false;
		String unicode = "";
		for (char c : s.toCharArray())
		{
			switch (c)
			{
				case '0':
					if(!DidFindOxidation)
						unicode += '\u2080';

					DidFindOxidation = false;
					break;

				case '1':
					if(!DidFindOxidation)
						unicode += '\u2081';

					DidFindOxidation = false;
					break;

				case '2':
					if(!DidFindOxidation)
						unicode += '\u2082';

					DidFindOxidation = false;
					break;

				case '3':
					if(!DidFindOxidation)
						unicode += '\u2083';

					DidFindOxidation = false;
					break;

				case '4':
					if(!DidFindOxidation)
						unicode += '\u2084';

					DidFindOxidation = false;
					break;

				case '5':
					if(!DidFindOxidation)
						unicode += '\u2085';

					DidFindOxidation = false;
					break;

				case '6':
					if(!DidFindOxidation)
						unicode += '\u2086';

					DidFindOxidation = false;
					break;

				case '7':
					if(!DidFindOxidation)
						unicode += '\u2087';

					DidFindOxidation = false;
					break;

				case '8':
					if(!DidFindOxidation)
						unicode += '\u2088';

					DidFindOxidation = false;
					break;

				case '9':
					if(!DidFindOxidation)
						unicode += '\u2089';

					DidFindOxidation = false;
					break;

				case 'Ä':
					unicode += '(';
					break;

				case '¹':
					unicode += ')';
					break;

				case '$':
					DidFindOxidation = true;
					break;

				default:
					unicode += c;
					break;
			}
		}
		return unicode;
	}

	private static int GetGCD(int a, int b)
	{
		while (b > 0)
		{
			int temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	public static int CalculateGCD(int... input)
	{
		int result = input[0];
		for (int i = 1; i < input.length; i++)
			result = GetGCD(result, input[i]);

		return result;
	}

	private static int GetLCM(int a, int b)
	{
		return a * (b / GetGCD(a, b));
	}

	public static int CalculateLCM(int... input)
	{
		int result = input[0];
		for (int i = 1; i < input.length; i++)
			result = GetLCM(result, input[i]);

		return result;
	}
}
