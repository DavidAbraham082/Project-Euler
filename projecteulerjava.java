import java.util.*;
import java.math.*;

public class projecteulerjava {
	public static void main(String[] args) {
		System.out.println(latticePaths(4, 6));
	}
	
	//calculates index of first fibonacci number with 1000 digits
	public static int thousandFib() {
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

		return result;
	}

	//calculates digit sum of 2^1000
	public static long digitSum() {
		long result = 0;
		BigInteger bi = new BigInteger("2");
		bi = bi.pow(1000);
		char[] biArray = bi.toString().toCharArray();

		for (char a : biArray)
			result += Character.getNumericValue(a);

		return result;
	}

	//calculates number of paths through a grid, travelling along gridlines,
	//from the top-left to bottom-right corner, travelling only right and down
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

	//finds int < n with collatz sequence with most terms
	public static void longestcollatz(long n) {
		int max = 1;
		long starter = 1L;
		Map<Long, Integer> found = new HashMap<>();

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
	private static int collatzCalc(long n, Map<Long, Integer> found) {
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

	//sums 150 bigintegers
	public static void sumhundredfifty() {
		BigInteger numbers[] = {
			new BigInteger("37107287533902102798797998220837590246510135740250"),
			new BigInteger("46376937677490009712648124896970078050417018260538"),
			new BigInteger("74324986199524741059474233309513058123726617309629"),
			new BigInteger("91942213363574161572522430563301811072406154908250"),
			new BigInteger("23067588207539346171171980310421047513778063246676"),
			new BigInteger("89261670696623633820136378418383684178734361726757"),
			new BigInteger("28112879812849979408065481931592621691275889832738"),
			new BigInteger("44274228917432520321923589422876796487670272189318"),
			new BigInteger("47451445736001306439091167216856844588711603153276"),
			new BigInteger("70386486105843025439939619828917593665686757934951"),
			new BigInteger("62176457141856560629502157223196586755079324193331"),
			new BigInteger("64906352462741904929101432445813822663347944758178"),
			new BigInteger("92575867718337217661963751590579239728245598838407"),
			new BigInteger("58203565325359399008402633568948830189458628227828"),
			new BigInteger("80181199384826282014278194139940567587151170094390"),
			new BigInteger("35398664372827112653829987240784473053190104293586"),
			new BigInteger("86515506006295864861532075273371959191420517255829"),
			new BigInteger("71693888707715466499115593487603532921714970056938"),
			new BigInteger("54370070576826684624621495650076471787294438377604"),
			new BigInteger("53282654108756828443191190634694037855217779295145"),
			new BigInteger("36123272525000296071075082563815656710885258350721"),
			new BigInteger("45876576172410976447339110607218265236877223636045"),
			new BigInteger("17423706905851860660448207621209813287860733969412"),
			new BigInteger("81142660418086830619328460811191061556940512689692"),
			new BigInteger("51934325451728388641918047049293215058642563049483"),
			new BigInteger("62467221648435076201727918039944693004732956340691"),
			new BigInteger("15732444386908125794514089057706229429197107928209"),
			new BigInteger("55037687525678773091862540744969844508330393682126"),
			new BigInteger("18336384825330154686196124348767681297534375946515"),
			new BigInteger("80386287592878490201521685554828717201219257766954"),
			new BigInteger("78182833757993103614740356856449095527097864797581"),
			new BigInteger("16726320100436897842553539920931837441497806860984"),
			new BigInteger("48403098129077791799088218795327364475675590848030"),
			new BigInteger("87086987551392711854517078544161852424320693150332"),
			new BigInteger("59959406895756536782107074926966537676326235447210"),
			new BigInteger("69793950679652694742597709739166693763042633987085"),
			new BigInteger("41052684708299085211399427365734116182760315001271"),
			new BigInteger("65378607361501080857009149939512557028198746004375"),
			new BigInteger("35829035317434717326932123578154982629742552737307"),
			new BigInteger("94953759765105305946966067683156574377167401875275"),
			new BigInteger("88902802571733229619176668713819931811048770190271"),
			new BigInteger("25267680276078003013678680992525463401061632866526"),
			new BigInteger("36270218540497705585629946580636237993140746255962"),
			new BigInteger("24074486908231174977792365466257246923322810917141"),
			new BigInteger("91430288197103288597806669760892938638285025333403"),
			new BigInteger("34413065578016127815921815005561868836468420090470"),
			new BigInteger("23053081172816430487623791969842487255036638784583"),
			new BigInteger("11487696932154902810424020138335124462181441773470"),
			new BigInteger("63783299490636259666498587618221225225512486764533"),
			new BigInteger("67720186971698544312419572409913959008952310058822"),
			new BigInteger("95548255300263520781532296796249481641953868218774"),
			new BigInteger("76085327132285723110424803456124867697064507995236"),
			new BigInteger("37774242535411291684276865538926205024910326572967"),
			new BigInteger("23701913275725675285653248258265463092207058596522"),
			new BigInteger("29798860272258331913126375147341994889534765745501"),
			new BigInteger("18495701454879288984856827726077713721403798879715"),
			new BigInteger("38298203783031473527721580348144513491373226651381"),
			new BigInteger("34829543829199918180278916522431027392251122869539"),
			new BigInteger("40957953066405232632538044100059654939159879593635"),
			new BigInteger("29746152185502371307642255121183693803580388584903"),
			new BigInteger("41698116222072977186158236678424689157993532961922"),
			new BigInteger("62467957194401269043877107275048102390895523597457"),
			new BigInteger("23189706772547915061505504953922979530901129967519"),
			new BigInteger("86188088225875314529584099251203829009407770775672"),
			new BigInteger("11306739708304724483816533873502340845647058077308"),
			new BigInteger("82959174767140363198008187129011875491310547126581"),
			new BigInteger("97623331044818386269515456334926366572897563400500"),
			new BigInteger("42846280183517070527831839425882145521227251250327"),
			new BigInteger("55121603546981200581762165212827652751691296897789"),
			new BigInteger("32238195734329339946437501907836945765883352399886"),
			new BigInteger("75506164965184775180738168837861091527357929701337"),
			new BigInteger("62177842752192623401942399639168044983993173312731"),
			new BigInteger("32924185707147349566916674687634660915035914677504"),
			new BigInteger("99518671430235219628894890102423325116913619626622"),
			new BigInteger("73267460800591547471830798392868535206946944540724"),
			new BigInteger("76841822524674417161514036427982273348055556214818"),
			new BigInteger("97142617910342598647204516893989422179826088076852"),
			new BigInteger("87783646182799346313767754307809363333018982642090"),
			new BigInteger("10848802521674670883215120185883543223812876952786"),
			new BigInteger("71329612474782464538636993009049310363619763878039"),
			new BigInteger("62184073572399794223406235393808339651327408011116"),
			new BigInteger("66627891981488087797941876876144230030984490851411"),
			new BigInteger("60661826293682836764744779239180335110989069790714"),
			new BigInteger("85786944089552990653640447425576083659976645795096"),
			new BigInteger("66024396409905389607120198219976047599490197230297"),
			new BigInteger("64913982680032973156037120041377903785566085089252"),
			new BigInteger("16730939319872750275468906903707539413042652315011"),
			new BigInteger("94809377245048795150954100921645863754710598436791"),
			new BigInteger("78639167021187492431995700641917969777599028300699"),
			new BigInteger("15368713711936614952811305876380278410754449733078"),
			new BigInteger("40789923115535562561142322423255033685442488917353"),
			new BigInteger("44889911501440648020369068063960672322193204149535"),
			new BigInteger("41503128880339536053299340368006977710650566631954"),
			new BigInteger("81234880673210146739058568557934581403627822703280"),
			new BigInteger("82616570773948327592232845941706525094512325230608"),
			new BigInteger("22918802058777319719839450180888072429661980811197"),
			new BigInteger("77158542502016545090413245809786882778948721859617"),
			new BigInteger("72107838435069186155435662884062257473692284509516"),
			new BigInteger("20849603980134001723930671666823555245252804609722"),
			new BigInteger("53503534226472524250874054075591789781264330331690")
		};

		BigInteger result = new BigInteger("1");

		for (BigInteger bi : numbers) {
			result = result.add(bi);
		}

		System.out.println(result);
	}

	//calculates first triangular number with >500 factors
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

	//calculates largest product of 4 adjacent numbers in a grid
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

	//calculates largest product of 13 consecutive digits of a long number
	public static long thirteenproduct() {
		String in = "731671765313306249192251196744265747423553491949349698" +
		"352031277450632623957831801698480186947885184385861560789112949495" +
		"459501737958331952853208805511125406987471585238630507156932909632" +
		"952274430435576689664895044524452316173185640309871112172238311362" +
		"229893423380308135336276614282806444486645238749303589072962904915" +
		"604407723907138105158593079608667017242712188399879790879227492190" +
		"169972088809377665727333001053367881220235421809751254540594752243" +
		"525849077116705560136048395864467063244157221553975369781797784617" +
		"406495514929086256932197846862248283972241375657056057490261407972" +
		"968652414535100474821663704844031998900088952434506585412275886668" +
		"811642717147992444292823086346567481391912316282458617866458359124" +
		"566529476545682848912883142607690042242190226710556263211111093705" +
		"442175069416589604080719840385096245544436298123098787992724428490" +
		"918884580156166097919133875499200524063689912560717606058861164671" +
		"094050775410022569831552000559357297257163626956188267042825248360" +
		"0823257530420752963450";
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
		return product;
	}

	//calculates sum of primes under n
	public static long sumPrimesUnderN(int n) {
		boolean prime[] = new boolean[n];
		Arrays.fill(prime, true);
		//this function is Eratosthenes' Seive
		for (int i = 2; i * i < n; i++)
			if (prime[i])
				for (int j = i * 2; j < n; j += i)
					prime[j] = false;
		

		long total = 0;
		for (int i = 2; i < n; i++) {
			if (prime[i])
				total += i;
		}

		return total;
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
