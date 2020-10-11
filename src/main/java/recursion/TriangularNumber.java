package recursion;

public class TriangularNumber {

	public static int triangle(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + triangle(n - 1);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			System.out.println("n=" + i + "->" + triangle(i));
		}
	}

}
