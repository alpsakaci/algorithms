package sorting;

class ArraySh {

	private double[] arr;
	private int numberOfItems;

	ArraySh(int max) {
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

	public void shellSort() {
		int outer, inner;
		double temp;
		int h = 1;

		while (h > 0) {
			for (outer = h; outer < numberOfItems; outer++) {
				temp = arr[outer];
				inner = outer;

				while (inner > h - 1 && arr[inner - h] >= temp) {
					arr[inner] = arr[inner - h];
					inner -= h;
				}
				arr[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

}

public class ShellSort {

	public static void main(String[] args) {

		int maxSize = 10;
		ArraySh arr = new ArraySh(maxSize);

		for (int i = 0; i < maxSize; i++) {
			double value = (int) (Math.random() * 99);
			arr.insert(value);
		}

		arr.display();
		arr.shellSort();
		arr.display();
	}

}
