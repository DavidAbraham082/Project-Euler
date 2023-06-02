package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Helpers
{
  public static ArrayList<String> GetFileContents(String fileName) throws FileNotFoundException
  {
    ArrayList<String> output = new ArrayList<String>();
    
    Scanner scanner = new Scanner(new File(fileName));
    while (scanner.hasNextLine())
    {
      output.add(scanner.nextLine());
    }

    return output;
  }

  //returns list of primes under n
	public static Vector<Integer> primesUnderN(int n) {
		boolean prime[] = new boolean[n];
		Arrays.fill(prime, true);

		//this function is Eratosthenes' Seive
		for (int i = 2; i * i < n; i++)
			if (prime[i])
				for (int j = i * 2; j < n; j += i)
					prime[j] = false;
	
		Vector<Integer> primes = new Vector<Integer>();

		for (int i = 2; i * i < n; i++)
			if (prime[i])
				primes.add(i);

		return primes;
	}
}
