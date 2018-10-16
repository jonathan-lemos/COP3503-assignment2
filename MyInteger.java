import java.util.List;
import java.util.ArrayList;

public class MyInteger{
	private int val;
	// this stores previously found prime values
	// see isPrime() for details
	private static List<Integer> primeVec;

	public int getValue(){
		return this.val;
	}

	public MyInteger(int val){
		this.val = val;
		// only needs to be initialized once because it is static
		if (primeVec == null){
			primeVec = new ArrayList<>();
			// 2 is the first prime number
			primeVec.add(Integer.valueOf(2));
		}
	}

	public boolean isEven(){
		return MyInteger.isEven(this.val);
	}

	public boolean isOdd(){
		return MyInteger.isOdd(this.val);
	}

	public boolean isPrime(){
		return MyInteger.isPrime(this.val);
	}

	public static boolean isEven(int val){
		// value mod 2 is true if it is divisible by 2 i.e. even
		return val % 2 == 0;
	}

	public static boolean isOdd(int val){
		return !MyInteger.isEven(val);
	}

	public static boolean isPrime(int val){
		// we only need to check if the number is divisible by prime numbers, since any non-prime number can be expressed as a combination of primes

		// from the last found prime until our target value
		for (int i = primeVec.get(primeVec.size() - 1) + 1; i <= val; ++i){
			int j;
			// check if i is divisible by any of our previously found primes
			for (j = 0; j < primeVec.size(); ++j){
				if (i % primeVec.get(j) == 0)
					break;
			}
			// if i was not divisible by any of them
			if (j == primeVec.size()){
				// i is prime, so add it to the list
				primeVec.add(Integer.valueOf(i));
			}
		}
		// if our number is in the list, it is prime
		return primeVec.contains(Integer.valueOf(val));
	}

	public static boolean isEven(MyInteger o){
		return MyInteger.isEven(o.val);
	}

	public static boolean isOdd(MyInteger o){
		return MyInteger.isOdd(o.val);
	}

	public static boolean isPrime(MyInteger o){
		return MyInteger.isPrime(o.val);
	}

	public boolean equals(int val){
		return this.val == val;
	}

	public boolean equals(MyInteger o){
		return this.val == o.val;
	}
}
