package com.alpsakaci.algorithms.simplesorting;

class Bubble {
	private double[] arr;
	private int numberOfItems;
	
	Bubble(int length) {
		arr = new double[length];
		numberOfItems = 0;
	}
	
	public void insert(double value) {
		arr[numberOfItems] = value;
		numberOfItems++;
	}
	
	public void display() {
		for(int i = 0; i < numberOfItems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void sort() {
		for(int i = 0; i < numberOfItems - 1; i++) {
			for(int j = 0; j < numberOfItems - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(j, j+1);
				}
			}
		}
	}
	
	private void swap(int index1, int index2) {
		double temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}

public class BubbleSortApp {

	public static void main(String[] args) {
		Bubble array = new Bubble(10);
		
		array.insert(34);
		array.insert(12);
		array.insert(1);
		array.insert(17);
		array.insert(44);
		array.insert(3);
		
		array.display();
		array.sort();
		array.display();

	}

}
