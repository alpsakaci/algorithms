package stacksandqueues;

class Queue {
	
	private int maxSize;
	private int[] queueArray;
	private int front;
	private int rear;
	private int numberOfItems;
	
	Queue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		front = 0;
		rear = -1;
		numberOfItems = 0;
	}
	
	public void enqueue(int value) {
		if (rear == maxSize - 1)
			rear = -1;
		queueArray[++rear] = value;
		numberOfItems++;
	}
	
	public int dequeue() {
		int temp = queueArray[front++];
		
		if (front == maxSize)
			front = 0;
		numberOfItems--;
		
		return temp;
	}
	
	public int peek() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return numberOfItems == 0;
	}
	
	public boolean isFull() {
		return numberOfItems == maxSize;
	}
	
	public int size() {
		return numberOfItems;
	}
	
}

public class CircularQueue {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		while (!queue.isEmpty()) {
			System.out.println("Dequeue: " + queue.dequeue() + " Size: " + queue.size());	
		}
	}

}
