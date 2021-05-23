package sorting;

class QuickSortArray {

	private double[] arr;
	private int numberOfItems;

	public QuickSortArray(int max) {
		arr = new double[max];
		numberOfItems = 0;
	}

	public void insert(double value) {
		arr[numberOfItems++] = value;
	}

	public void display() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void quickSort() {
		recQuickSort(0, numberOfItems - 1);
	}

	public void recQuickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			double pivot = arr[right];

			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public void swap(int index1, int index2) {
		double temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public int partitionIt(int left, int right, double pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;

		while (true) {
//			find bigger item
			while (leftPtr < right && arr[++leftPtr] < pivot)
				;
//			find smaller item
			while (rightPtr > left && arr[--rightPtr] > pivot)
				;

			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}

		return leftPtr;
	}

}

public class QuickSort {

	public static void main(String[] args) {
		int maxSize = 8;
		QuickSortArray arr = new QuickSortArray(maxSize);

		for (int i = 0; i < maxSize; i++) {
			double value = (int) (Math.random() * 199);
			arr.insert(value);
		}

		arr.display();
		arr.quickSort();
		arr.display();
	}

}
