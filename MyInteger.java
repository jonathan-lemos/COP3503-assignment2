import java.util.List;
import java.util.ArrayList;

public class MyInteger{
	private int val;
	private static List<Integer> primeVec;

	public MyInteger(int val){
		this.val = val;
		primeVec = new ArrayList<>();
		primeVec.add(Integer.valueOf(2));
	}

	public int getValue(){
		return this.val;
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
		return val % 2 == 0;
	}

	public static boolean isOdd(int val){
		return !MyInteger.isEven(val);
	}

	public static boolean isPrime(int val){
		for (int i = primeVec.get(primeVec.size() - 1) + 1; i <= val; ++i){
			int j;
			for (j = 0; j < primeVec.size(); ++j){
				if (i % primeVec.get(j) == 0)
					break;
			}
			if (j == primeVec.size()){
				primeVec.add(Integer.valueOf(i));
			}
		}
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
