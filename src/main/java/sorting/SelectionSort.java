package sorting;

class SelectionSortArray {

	private double[] arr;
	private int numberOfItems;

	SelectionSortArray(int length) {
		arr = new double[length];
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

	public void sort() {
		int i, j, min;

		for (i = 0; i < numberOfItems - 1; i++) {
			min = i;
			for (j = i + 1; j < numberOfItems; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (i != min)
				swap(i, min);
		}
	}

	private void swap(int index1, int index2) {
		double temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSortArray array = new SelectionSortArray(10);

		array.insert(2);
		array.insert(3);
		array.insert(1);
		array.insert(5);
		array.insert(6);
		array.insert(4);

		array.display();
		array.sort();
		array.display();
	}

}
