package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

	private static int fib(int n) {
		if (n <= 1) {
			return 1;
		} else if (memo.get(n) != null) {
			return memo.get(n);
		} else {
			int val = fib(n - 1) + fib(n - 2);
			memo.put(n, val);
			return val;
		}
	}

	public static void main(String[] args) {
		System.out.println(fib(20));
		System.out.println(memo);
	}

}
