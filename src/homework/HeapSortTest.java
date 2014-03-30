package homework;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class tests the Heap-sort from HeapSort.java class
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class HeapSortTest extends HeapSort {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("Select\n'1' to use a predefined array;");
		System.out.println("'2' to manually input an array from the console:");
		int x = 0;
		try{
		x = cin.nextInt();
		}
		catch(Exception e){
			System.out.println("Error.Please enter an integer.");
			System.out.println("Program end.");
			System.exit(0);
		}
		switch (x) {
		case 1:
			// using a hardcoded array to test heapsort;
			int array[] = { 440, 16, 2, 100, 77, 40, 120, 550, 123, 234, 623,
					258 };

			System.out.println("Unsorted array: ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			heapSort(array);
			System.out.println("\nSorted array: ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("\nProgram end.");
			System.exit(0);
			break;
		case 2:
			// using manual input to test heapsort;
			// adds integer elements to an arraylist
			// until a non-integer character is input
			// then converts arraylist into an int[] array
			// and sorts it
			System.out
					.println("Input array elements separated by a 'Space' or 'Enter';");
			System.out.println("When done, input a non integer character;");
			ArrayList<Integer> list = new ArrayList<Integer>();
			try {
				while (1 < 2) {
					x = cin.nextInt();
					list.add(x);
				}
			} catch (Exception e) {
			}
			array = new int[list.size()];
			for (int i = 0; i < array.length; i++) {
				array[i] = list.get(i);
			}
			System.out.println("Unsorted array: ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			heapSort(array);

			System.out.println("\nSorted array: ");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("\nProgram end.");
			System.exit(0);
			break;
		default:
			// Undefined input
			System.out.println("Unspecified input, please input '1' or '2'");
			System.out.println("Program end.");
			System.exit(0);
		}
	}// end Main

}
