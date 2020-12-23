package knuttshuffle;

import java.util.Random;

public class KnuttShuffle {

	private int[] arr = new int[16];

	public KnuttShuffle() {
		for (int i = 0; i < arr.length; i++) {
			this.arr[i] = i + 1;
		}
	}

	public int[] getArray() {
		return this.arr;
	}

	public int[] shuffle() {
		for (int i = arr.length - 1; i >= 0; i--) {
			Random random = new Random();
			int j = random.ints(0, arr.length - 1).findFirst().getAsInt();
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		return this.arr;
	}

	public void printArray() {
		System.out.print("\n[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1)
				System.out.print(", ");
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		KnuttShuffle ks = new KnuttShuffle();
		ks.printArray();
		ks.shuffle();
		ks.printArray();
	}

}
