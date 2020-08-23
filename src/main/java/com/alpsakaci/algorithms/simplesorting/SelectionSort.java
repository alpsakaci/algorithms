package com.alpsakaci.algorithms.simplesorting;

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
				swap(i, min);
			}
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
		BubbleSortArray array = new BubbleSortArray(10);

		array.insert(56);
		array.insert(35);
		array.insert(22);
		array.insert(15);

		array.display();
		array.sort();
		array.display();
	}

}
