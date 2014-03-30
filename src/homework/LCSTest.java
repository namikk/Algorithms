package homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class tests the LCS from LCS.java class
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class LCSTest {

	public static void main(String[] args) {
		LCS lcsTester = new LCS();
		Scanner cin = new Scanner(System.in);
		System.out.println("Select\n'1' to use 2 predefined sequences;");
		System.out.println("'2' to manually input 2 sequences the console:");
		int x = 0;
		try {
			x = cin.nextInt();
		} catch (Exception e) {
			System.out.println("Error.Please enter an integer.");
			System.out.println("Program end.");
			System.exit(0);
		}
		switch (x) {
		case 1:
			// predefined sequences
			char[] s1 = { 'A', 'B', 'C', 'B', 'D', 'A', 'B' };
			char[] s2 = { 'B', 'D', 'C', 'B', 'A' };
			// print both s1 and s2
			System.out.print("Sequence 1: ");
			for (int i = 0; i < s1.length; i++) {
				System.out.print(s1[i] + " ");
			}
			System.out.println();
			System.out.print("Sequence 2: ");
			for (int i = 0; i < s2.length; i++) {
				System.out.print(s2[i] + " ");
			}
			System.out.println();
			// find the LCS and print it
			lcsTester = new LCS();
			lcsTester.LCSLength(s1, s2);
			System.out.print("LCS is: ");
			lcsTester.LCSPrint(s1, s1.length, s2.length);
			System.exit(0);
			break;
		case 2:
			// 2 character arraylists for dynamic input of chars
			ArrayList<Character> seq1 = new ArrayList<Character>();
			ArrayList<Character> seq2 = new ArrayList<Character>();
			String adder;
			System.out
					.println("Enter sequence 1, write 'esc' when done to continue with the program");
			while (1 < 2) {
				adder = cin.next();
				if (adder.equals("esc"))
					break;
				else
					seq1.add(adder.charAt(0));
			}
			System.out
					.println("Enter sequence 2, write 'esc' when done to continue with the program");
			while (1 < 2) {
				adder = cin.next();
				if (adder.equals("esc"))
					break;
				else
					seq2.add(adder.charAt(0));
			}
			// convert character arraylists to char[] array
			s1 = new char[seq1.size()];
			s2 = new char[seq2.size()];
			for (int i = 0; i < s1.length; i++) {
				s1[i] = seq1.get(i);
			}
			for (int i = 0; i < s2.length; i++) {
				s2[i] = seq2.get(i);
			}

			System.out.print("Sequence 1: ");
			for (int i = 0; i < s1.length; i++) {
				System.out.print(s1[i] + " ");
			}
			System.out.println();
			System.out.print("Sequence 2: ");
			for (int i = 0; i < s2.length; i++) {
				System.out.print(s2[i] + " ");
			}
			System.out.println();
			// find the LCS and print it
			lcsTester.LCSLength(s1, s2);
			System.out.print("LCS is: ");
			lcsTester.LCSPrint(s1, s1.length, s2.length);
			System.exit(0);

			break;
		default:
			// Undefined input
			System.out.println("Unspecified input, please input '1' or '2'");
			System.out.println("Program end.");
			System.exit(0);
		}

	}
}
