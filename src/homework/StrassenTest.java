package homework;

import java.util.Scanner;

/**
 * This class tests the Strassen algoritm from Strassen.java class
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class StrassenTest {
	public static void main(String args[]) {
		Strassen test = new Strassen();
		Scanner cin = new Scanner(System.in);
		System.out
				.println("Select\n'1' to use a matrix populated with random numbers:");
		System.out
				.println("'2' to manually input two matrices from the console:");
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
			// random matrix populate
			System.out.println("Input matrix size:");
			// set the size of the square matrices
			int size = cin.nextInt();
			// initialize an instance variable of Strassen that will be used for
			// storage and calculation
			test = new Strassen(size);
			// populate both a and b with random numbers from 0 to 9
			test.populateRandom();
			// print matrices a and b
			test.print();
			// assign testMatrix to be the resulting matrix of a and b
			// multiplication
			int[][] testMatrix = test.calculate();
			// print the resulting matrix testMatrix
			System.out.println("Matrix C=A*B ");
			for (int i = 0; i < testMatrix.length; i++) {
				for (int j = 0; j < testMatrix.length; j++) {
					System.out.print(testMatrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Program end.");
			System.exit(0);
			break;
		case 2:
			// manual matrix populate
			System.out.println("Input matrix A dimensions:");
			int dx = cin.nextInt();
			int dy = cin.nextInt();
			int[][] testA = new int[dx][dy];
			// enter matrix A elements
			for (int i = 0; i < testA.length; i++) {
				System.out.println("Input elements of matrix A[" + i + "]");
				for (int j = 0; j < testA[0].length; j++) {
					testA[i][j] = cin.nextInt();
				}
			}

			System.out.println("Input matrix B dimensions:");
			dx = cin.nextInt();
			dy = cin.nextInt();
			int[][] testB = new int[dx][dy];
			// enter matrix B elements
			for (int i = 0; i < testB.length; i++) {
				System.out.println("Input elements of matrix B[" + i + "]");
				for (int j = 0; j < testB[0].length; j++) {
					testB[i][j] = cin.nextInt();
				}
			}
			// pass the two input matrices to class instance
			test.manualPopulate(testA, testB);
			test.print();
			testMatrix = test.calculate();
			System.out.println("Matrix C=A*B ");
			for (int i = 0; i < testMatrix.length; i++) {
				for (int j = 0; j < testMatrix.length; j++) {
					System.out.print(testMatrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Program end.");
			System.exit(0);
			break;
		default:
			// Undefined input
			System.out.println("Unspecified input, please input '1' or '2'");
			System.out.println("Program end.");
			System.exit(0);
		}

	}//end Main
}
