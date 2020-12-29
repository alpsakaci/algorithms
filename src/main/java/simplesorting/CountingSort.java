package simplesorting;

public class CountingSort {

	static void sort(int arr[]) {

		int[] counter = new int[arr.length + 1];
		int[] output = new int[arr.length];

		for (int i = 0; i < counter.length; i++) {
			counter[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			counter[arr[i]]++;
		}

		for (int i = 1; i <= arr.length; i++) {
			counter[i] += counter[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[counter[arr[i]] - 1] = arr[i];
			counter[arr[i]]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		 0 <= arr[i] <= arr.length
		int arr[] = { 4, 3, 3, 2, 1, 7, 6, 9, 0, 10, 0 };

		printArray(arr);
		sort(arr);
		printArray(arr);
	}

}
