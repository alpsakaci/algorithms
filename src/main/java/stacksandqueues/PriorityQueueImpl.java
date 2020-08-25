package stacksandqueues;

class PriorityQueue {

	private int maxSize;
	private double[] queueArray;
	private int numberOfItems;

	PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new double[maxSize];
		numberOfItems = 0;
	}

	public void enqueue(double value) {
		int i;

		if (numberOfItems == 0) {
			queueArray[numberOfItems++] = value;
		} else {
			for (i = numberOfItems - 1; i >= 0; i--) {
				if(value > queueArray[i]) {
					queueArray[i+1] = queueArray[i];
				} else {
					break;
				}
			}
			queueArray[i+1] = value;
			numberOfItems++;
		}
	}
	
	public double dequeue() {
		return queueArray[--numberOfItems];
	}

	public double peek() {
		return queueArray[numberOfItems - 1];
	}

	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	public boolean isFull() {
		return numberOfItems == maxSize;
	}

}

public class PriorityQueueImpl {

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);
		queue.enqueue(30);
		queue.enqueue(50);
		queue.enqueue(10);
		queue.enqueue(40);
		queue.enqueue(20);
		
		while (!queue.isEmpty()) {
			double value = queue.dequeue();
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
