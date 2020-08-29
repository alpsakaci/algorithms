package recursion;

public class TowersOfHanoi {

	static int numberOfDisks = 3;

	static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}

	public static void main(String[] args) {
		doTowers(numberOfDisks, 'A', 'B', 'C');
	}

}
