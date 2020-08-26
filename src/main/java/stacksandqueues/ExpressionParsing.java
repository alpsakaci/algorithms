package stacksandqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class InfixToPostfix {

	private Stack<Character> stack;
	private String input;
	private String output = "";

	public InfixToPostfix(String input) {
		this.input = input;
		stack = new Stack<Character>();
	}

	public void gotOper(char opThis, int prec1) {
		while (!stack.isEmpty()) {
			char opTop = stack.pop();
			
			if (opTop == '(') {
				stack.push(opTop);
				break;
			} else {
				int prec2;
				
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				
				if (prec2 < prec1) {
					stack.push(opTop);
					break;
				} else {
					output = output + opTop;
				}
			}
		}
		
		stack.push(opThis);
	}
	
	public void gotParen(char ch) {
		while (!stack.isEmpty()) {
			char chx = stack.pop();
			
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}

	public String doTranslation() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			stack.forEach(System.out::print);
			System.out.println();

			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			stack.forEach(System.out::print);
			System.out.println();
			output = output + stack.pop();
		}
		
		stack.forEach(System.out::print);
		System.out.println();
		
		return output;
	}

}

public class ExpressionParsing {
	
	public static String getString() throws IOException {
		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);
		
		return bufferedReader.readLine();
	}

	public static void main(String[] args) throws IOException {
		String input, output;
		
		while (true) {
			System.out.println("Enter infix: ");
			System.out.flush();
			input = getString();
			
			if (input.equals(""))
				break;
			
			InfixToPostfix parser = new InfixToPostfix(input);
			output = parser.doTranslation();
			System.out.println("Postfix: " + output);
		}
	}

}
