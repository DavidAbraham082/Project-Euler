package Problems;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;

import Helpers.Helpers;

public class _011_To_020 {
  // PROBLEM 11
  // calculates largest product of 4 adjacent numbers in a grid
	public static void gridlargestproduct () {
		int[][] grid = {
			{8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
			{49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,4,56,62,0},
			{81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,3,49,13,36,65},
			{52,70,95,23,4,60,11,42,69,24,68,56,1,32,56,71,37,2,36,91},
			{22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
			{24,47,32,60,99,3,45,2,44,75,33,53,78,36,84,20,35,17,12,50},
			{32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
			{67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
			{24,55,58,5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
			{21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
			{78,17,53,28,22,75,31,67,15,94,3,80,4,62,16,14,9,53,56,92},
			{16,39,5,42,96,35,31,47,55,58,88,24,0,17,54,24,36,29,85,57},
			{86,56,0,48,35,71,89,7,5,44,44,37,44,60,21,58,51,54,17,58},
			{19,80,81,68,5,94,47,69,28,73,92,13,86,52,17,77,4,89,55,40},
			{04,52,8,83,97,35,99,16,7,97,57,32,16,26,26,79,33,27,98,66},
			{88,36,68,87,57,62,20,72,3,46,33,67,46,55,12,32,63,93,53,69},
			{4,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
			{20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,4,36,16},
			{20,73,35,29,78,31,90,1,74,31,49,71,48,86,81,16,23,57,5,54},
			{1,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48},
		};
		int max = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				int curr;

				try {//right
					curr = 1;

					for (int k = 0; k < 4; k++)
						curr *= grid[i][j+k];

					if (curr > max)
						max = curr;
				}
				catch (IndexOutOfBoundsException e) {}

				try {//down
					curr = 1;

					for (int k = 0; k < 4; k++)
						curr *= grid[i+k][j];

					if (curr > max)
						max = curr;
				}
				catch (IndexOutOfBoundsException e) {
					continue;
				}

				try {//diagonal left
					curr = 1;

					for (int k = 0; k < 4; k++)
						curr *= grid[i+k][j+k];

					if (curr > max)
						max = curr;
				}
				catch (IndexOutOfBoundsException e) {}
				
				try {//diagonal right
					curr = 1;

					for (int k = 0; k < 4; k++)
						curr *= grid[i+k][j-k];

					if (curr > max)
						max = curr;
				}
				catch (IndexOutOfBoundsException e) {}
			}
		}
		System.out.println(max);
	}
  
  // PROBLEM 12
	// calculates first triangular number with >500 factors
	public static void trianglenumbers() {
		int factors = 0, trinum = 0, count = 1;
		while (factors < 500) {
			trinum = 0;
			factors = 0;
			for(int j = 1; j <= count; j++)
				trinum += j;
			
			for (int k = 1; k <= trinum; k++)
				if (trinum % k == 0)
					++factors;
			
			System.out.printf("%d\n", factors);
			++count;
		}
		System.out.println(trinum);
	}

  // PROBLEM 13
	// sums 150 bigintegers
	public static void sumhundredfifty() {
		try
		{
			BigInteger sum = new BigInteger("0");
			var numStrings = Helpers.GetFileContents("../ProblemData/013-50-digit-numbers.txt");
			for (String number : numStrings) {
				sum = sum.add(new BigInteger(number));
			}
			System.out.println(sum);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found!");
			return;
		}
	}
  
  // PROBLEM 14
	// finds int < n with longest collatz sequence
	public static void longestcollatz(long n) {
		int max = 1;
		long starter = 1L;
		HashMap<Long, Integer> found = new HashMap<>();

		for (long i = 1; i < n; i++) {
			int c = collatzCalc(i, found);
			if (c > max) {
				max = c;
				starter = i;
			}
		}

		System.out.println("" + starter + " " + max);
	}

  //calculates number of terms in collatz sequence for int n
  private static int collatzCalc(long n, HashMap<Long, Integer> found) {
		int result = 1;
		long curr = n;

		while (curr != 1) {
			if (curr % 2 == 0)
				curr /= 2;
			else
				curr = 3 * curr + 1;

			if (found.containsKey(curr)) {
				result += found.get(curr);
				curr = 1;
			} else
				result++;
		}

		found.put(n, result);
		return result;
	}
  
  // PROBLEM 15
	// calculates number of paths through a grid, travelling along gridlines,
	// from the top-left to bottom-right corner, travelling only right and down
	public static long latticePaths(int x, int y) {
		long result = 0;
		//trivial results
		if (x == 0 || y == 0)
			return result;
		if (x == 1 || y == 1)
			return 1;
		if (x == 2)
			return y;
		if (y == 2)
			return x;

		//grid
		long[][] lattice = new long[x][y];
		//populate first row/column with 1, second row/column with index
		//this is because 1xa grids have 1 path
		//and 2xa grids have a paths
		for (int i = 0; i < x; i++) {
			lattice[i][0] = 1;
			lattice[i][1] = i + 1;
		}
		for (int i = 0; i < y; i++) {
			lattice[0][i] = 1;
			lattice[1][i] = i + 1;	
		}

		result = latticePathsRecursive(x - 1, y - 1, lattice);
		return result;
	}

	private static long latticePathsRecursive(int x, int y, long[][]lattice) {
		long result = 0;
		if (lattice[x][y] == 0) {
			lattice[x][y] += latticePathsRecursive(x - 1, y, lattice);
			lattice[x][y] += latticePathsRecursive(x, y - 1, lattice);
		}
		result = lattice[x][y];
		return result;
	}

  // PROBLEM 16
	// calculates digit sum of 2^1000
	public static void digitSum() {
		long result = 0;
		BigInteger bi = new BigInteger("2");
		bi = bi.pow(1000);
		char[] biArray = bi.toString().toCharArray();

		for (char a : biArray)
			result += Character.getNumericValue(a);

		System.out.println(result);
	}
}
