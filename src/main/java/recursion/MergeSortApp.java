package recursion;

class DArray {

	private double[] arr;
	private int numberOfItems;

	public DArray(int maxSize) {
		arr = new double[maxSize];
		numberOfItems = 0;
	}

	public void insert(double value) {
		arr[numberOfItems] = value;
		numberOfItems++;
	}

	public void display() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void mergeSort() {
		double[] workSpace = new double[numberOfItems];
		recMergeSort(workSpace, 0, numberOfItems - 1);
	}

	private void recMergeSort(double[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid + 1, upperBound);
			merge(workSpace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(double[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int i = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (arr[lowPtr] < arr[highPtr]) {
				workSpace[i++] = arr[lowPtr++];
			} else {
				workSpace[i++] = arr[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			workSpace[i++] = arr[lowPtr++];
		}
		
		while (highPtr <= upperBound) {
			workSpace[i++] = arr[highPtr++];
		}
		
		for (i=0; i<n; i++) {
			arr[lowerBound+i] = workSpace[i];
		}
	}

}

public class MergeSortApp {

	public static void main(String[] args) {
		int maxSize = 100;
		DArray arr = new DArray(maxSize);

		arr.insert(64);
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(99);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);

		arr.display();
		arr.mergeSort();
		arr.display();
	}

}
