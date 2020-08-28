package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	public static char[] word = new char[100];
	static int size;
	static int count;

	public static void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");

		for (int i = 0; i < size; i++)
			System.out.print(word[i]);
		System.out.print("   ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	public static void rotate(int newSize) {
		int i;
		int position = size - newSize;
		char temp = word[position];

		for (i = position + 1; i < size; i++) {
			word[i - 1] = word[i];
		}
		word[i - 1] = temp;
	}

	public static void doAnagram(int newSize) {
		if (newSize == 1)
			return;

		for (int i = 0; i < newSize; i++) {
			doAnagram(newSize - 1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		return s;
	}

	public static void main(String[] args) throws IOException {
		System.out.print("Enter word: ");
		System.out.flush();

		String input = getString();
		size = input.length();
		count = 0;

		for (int i = 0; i < size; i++) {
			word[i] = input.charAt(i);
		}

		doAnagram(size);
	}

}
