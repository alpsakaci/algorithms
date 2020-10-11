package stacksandqueues;

import java.util.Stack;

class BracketChecker {

	private String input;

	BracketChecker(String input) {
		this.input = input;
	}

	public boolean check() {
		Stack<Character> stack = new Stack<Character>();
		boolean isCorrect = true;

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!stack.isEmpty()) {
					char chx = stack.pop();
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
						System.out.println("Error: " + ch + " at " + i);
						isCorrect = false;
					}
				} else {
					System.out.println("Error: " + ch + " at " + i);
					isCorrect = false;
				}
				break;
			default:
				break;
			}
		}

		if (!stack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
			isCorrect = false;
		}

		return isCorrect;
	}

}

public class DelimiterMatching {

	public static void main(String[] args) {
		BracketChecker checker = new BracketChecker("a{b(c[d]e)f}");

		System.out.println(checker.check());
	}

}
