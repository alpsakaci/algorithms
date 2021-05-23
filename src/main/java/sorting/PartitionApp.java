package sorting;

class PartitionArray {

	private double[] arr;
	private int numberOfItems;

	public PartitionArray(int max) {
		arr = new double[max];
		numberOfItems = 0;
	}

	public void insert(double value) {
		arr[numberOfItems++] = value;
	}

	public int size() {
		return numberOfItems;
	}

	public void display() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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

public class PartitionApp {

	public static void main(String[] args) {

		int maxSize = 16;
		PartitionArray arr = new PartitionArray(maxSize);

		for (int i = 0; i < maxSize; i++) {
			double value = (int) (Math.random() * 199);
			arr.insert(value);
		}

		arr.display();
		double pivot = 100;
		System.out.println("Pivot is " + pivot);

		int size = arr.size();
		int partitionIndex = arr.partitionIt(0, size - 1, pivot);
		System.out.println("Partition at index: " + partitionIndex);
		arr.display();
	}

}
