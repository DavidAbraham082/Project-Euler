package Problems;

import java.io.FileNotFoundException;
import java.util.Vector;

import Helpers.Helpers;

public class _001_To_010
{
  // PROBLEM 8
	// calculates largest product of 13 consecutive digits of a long number
	public static void thirteenproduct() throws FileNotFoundException {
		String in = Helpers.GetFileContents("ProblemData/008-1000-digit-number.txt").get(0);
		Vector<Long> vec = new Vector<Long>();
		for (char a : in.toCharArray()) {
			vec.add(Long.valueOf(Character.getNumericValue(a)));
		}
		long product = 0;
		for (int i = 0; i < 987; i++) {
			long prod = 1;
			for (int j = 0; j < 13; j++) {
				prod *= vec.get(i + j);
			}
			if (prod != 0 && prod > product)
				product = prod;
		}
		System.out.println(product);
	}
}