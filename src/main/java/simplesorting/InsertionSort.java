package simplesorting;

class InsertionSortArray {

	private double[] arr;
	private int numberOfItems;

	InsertionSortArray(int length) {
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
		int i, j;
		for (i = 1; i < numberOfItems; i++) {
			double temp = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] >= temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

}

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSortArray array = new InsertionSortArray(10);

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
