package Problems;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import Helpers.Helpers;

public class _021_To_030 {
  // PROBLEM 21
	// calculates sum of amicable numbers under n
	public static int SumAmicableUnderN(int n) {
		Integer factorSum[] = new Integer[n + 1];
		Arrays.fill(factorSum, 0);

		for (Integer prime : Helpers.primesUnderN(n+1)) {
			factorSum[prime] = 1;
		}

		for (int numberToCheck = 4; numberToCheck < n + 1; numberToCheck++)
		{
			if (factorSum[numberToCheck] == 1) continue;

			for (int factor = 1; factor <= numberToCheck / 2; factor++)
			{
				if (numberToCheck % factor == 0)
				{
					factorSum[numberToCheck] += factor;
				}
			}
		}

		int finalSum = 0;

		for (int candidate = 4; candidate < n + 1; candidate++)
		{
			if (factorSum[candidate] <= candidate) continue;
			if (factorSum[candidate] > n) continue;
			if (factorSum[factorSum[candidate]] == candidate)
			{
				finalSum += candidate + factorSum[candidate];
				factorSum[factorSum[candidate]] = -1;
				factorSum[candidate] = -1;
			}
		}

		return finalSum;
	}

  // PROBLEM 22
  // alphabetise list and calculate sum of products of alphabetical value x list index
  public static void nameScores() throws FileNotFoundException
  {
    String namesString = Helpers.GetFileContents("ProblemData/022-names.txt").get(0);
    namesString = namesString.replaceAll("\"", "");
    List<String> names = Arrays.asList(namesString.split(","));
    names.sort(null);

    int finalSum = 0;

    for (String name : names) {
      int alphaSum = 0;
      for (char chara : name.toCharArray()) {
        alphaSum += (int)chara - 64;
      }
      finalSum += alphaSum * (names.indexOf(name) + 1);
    }

    System.out.println(finalSum);
  }
  
  // PROBLEM 25
  // calculates index of first fibonacci number with 1000 digits
	public static void thousandFib() {
		int result = 0;
		BigInteger[] fibstore = {new BigInteger("0"), new BigInteger("1"), new BigInteger("1")};

		int i = 0, j, k;
		while (fibstore[i].toString().length() < 1000) {
				result++;
				j = (i + 1) % 3;
				k = (j + 1) % 3;
				fibstore[i] = fibstore[j].add(fibstore[k]);
				i++;
				i %= 3;
		}

		System.out.println(result);
	}
}
