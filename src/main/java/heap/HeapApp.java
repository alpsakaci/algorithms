package heap;

class Node {

	public int data;

	public Node(int key) {
		data = key;
	}

}

class Heap {

	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];

		while (index > 0 && heapArray[parent].data < bottom.data) {
			heapArray[index] = heapArray[parent]; // move down
			index = parent;
			parent = (parent - 1) / 2;
		}

		heapArray[index] = bottom;
	}

	public void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];

		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize && heapArray[leftChild].data < heapArray[rightChild].data) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}

			if (top.data >= heapArray[largerChild].data) {
				break;
			}

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize) {
			return false;
		} else {
			Node newNode = new Node(key);
			heapArray[currentSize] = newNode;
			trickleUp(currentSize++);

			return true;
		}
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);

		return root;
	}

	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].data;
		heapArray[index].data = newValue;

		if (oldValue < newValue)
			trickleUp(index);
		else
			trickleDown(index);

		return true;
	}

	public void displayHeap() {
		System.out.print("Heap: ");

		for (int i = 0; i < currentSize; i++) {
			if (heapArray[i] != null) {
				System.out.print(heapArray[i].data + " ");
			} else {
				System.out.println("-- ");
			}
		}
		System.out.println();

		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "...............................";
		System.out.println(dots + dots);

		while (currentSize > 0) {
			if (column == 0) {
				for (int k = 0; k < nBlanks; k++)
					System.out.print(" ");
			}
			System.out.print(heapArray[j].data);

			if (++j == currentSize)
				break;

			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else {
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(" ");
			}
		}
		System.out.println("\n" + dots + dots);
	}

}

public class HeapApp {

	public static void main(String[] args) {
		int value1, value2;
		Heap heap = new Heap(31);
		boolean success;
		
		heap.insert(70);
		heap.insert(40);
		heap.insert(50);
		heap.insert(20);
		heap.insert(60);
		heap.insert(100);
		heap.insert(80);
		heap.insert(30);
		heap.insert(10);
		heap.insert(90);
		
		heap.displayHeap();
		
		heap.remove();
		heap.displayHeap();
		
		heap.insert(200);
		heap.displayHeap();
		
		heap.change(0, 35);
		heap.displayHeap();
		heap.change(1, 15);
		heap.displayHeap();
	}

}
