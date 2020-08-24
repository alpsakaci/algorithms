package stacksandqueues;

class Stack {

	private int maxSize;
	private double[] stackArray;
	private int top;

	Stack(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new double[maxSize];
		top = -1;
	}

	public void push(double value) {
		if (!isFull())
			stackArray[++top] = value;
		else
			System.out.println("Stack is full.");
	}

	public double pop() {
		return stackArray[top--];
	}

	public double peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

}

public class StackWithArray {

	public static void main(String[] args) {
		Stack stack = new Stack(10);

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
