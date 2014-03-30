package homework;

/**
 * This class implements the Strassen algoritm for calculating the product of
 * two matrices
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class Strassen {
	// matrices' data is held within these class instances
	protected int[][] a;
	protected int[][] b;

	// default constructor, creates a,b matrices of size 1
	public Strassen() {
		a = new int[1][1];
		b = new int[1][1];
	}

	// size input constructor, creates a,b square matrices of size n each
	public Strassen(int n) {
		a = new int[n][n];
		b = new int[n][n];
	}

	// 2 args constructor, takes 2 predefined square matrices as input
	public Strassen(int[][] inputA, int[][] inputB) {
		a = inputA;
		b = inputB;
	}

	// matrix a getter, return matrix A as int[][]
	public int[][] getA() {
		return a;
	}

	// matrix b getter, return matrix B as int[][]
	public int[][] getB() {
		return b;
	}

	// squareCheck method for making matrices square and of power of 2 length
	// takes matrices of any dimensions and makes them strassen compatible
	public void squareCheck(int[][] matrixA, int[][] matrixB) {
		// set n to be the larger matrix length
		int n = Math.max(matrixA.length, matrixB.length);
		// set m to be the larger matrix width
		int m = Math.max(matrixA[0].length, matrixB[0].length);
		/*
		 * if ((n & -n) == n) statement uses bit-wise comparison of n with -n
		 * (written in 2's complement) to check if given number is power of 2;
		 * if n is power of 2, (n & -n) will return n, example: n=00100 &
		 * -n=11100 (number 4 and -4) will return 00100, which means (n&-n)==n
		 * is true if n is not power of 2, (n & -n) will not return n, example:
		 * n=01100 & -n=10100 (number 12 and -12) will return 00100, which means
		 * (n&-n)==n is not true
		 */
		if ((n == m) && ((n & -n) == n)) {
			// matrix is square and length is a power of 2,
			// no need to make its length a power of 2
			return;
		} else {
			// set n to be the largest of the length or width
			n = Math.max(m, n);
			while ((n & -n) != n) {
				n++;// increase n until its a power of 2
			}
			// create 2 temp square arrays of new size n that is a power of 2
			int[][] tempA = new int[n][n];
			int[][] tempB = new int[n][n];
			// copy from matrices A and B into temp arrays
			for (int i = 0; i < matrixA.length; i++) {
				for (int j = 0; j < matrixA[0].length; j++) {
					tempA[i][j] = matrixA[i][j];
				}
			}
			for (int i = 0; i < matrixB.length; i++) {
				for (int j = 0; j < matrixB[0].length; j++) {
					tempB[i][j] = matrixB[i][j];
				}
			}
			// Reinitialize arrays A and B to be of size n
			matrixA = new int[n][n];
			matrixB = new int[n][n];

			// copy from temp arrays back to matrices A and B
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrixA[i][j] = tempA[i][j];
					matrixB[i][j] = tempB[i][j];
				}
			}

		}
		a = matrixA;
		b = matrixB;
		// matrices A and B are now square and their length is a power of 2
		// original element data is preserved, new elements are set to 0
	}// end squareCheck

	// fills each matrix with random numbers between 0 and 9
	public void populateRandom() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = (int) (Math.random() * 10);
				b[i][j] = (int) (Math.random() * 10);
			}
		}
		squareCheck(a, b);
	}

	// manualPopulate enables user to manually provide 2 matrices
	public void manualPopulate(int[][] inputA, int[][] inputB) {
		a = inputA;
		b = inputB;
		squareCheck(a, b);
	}

	// print method to display both a and b matrices
	public void print() {
		// matrix a print
		System.out.println("Matrix A");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		// matrix b print
		System.out.println("Matrix B");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	// subarray method, copies elements from parent array A into child array
	// subArray,
	// int x and int y determine the starting range
	public void subCopy(int[][] subArray, int[][] A, int x, int y) {
		int n = A.length;
		for (int i = 0; i < (n / 2); i++) {
			for (int j = 0; j < (n / 2); j++) {
				subArray[i][j] = A[i + x][j + y];
			}
		}

	}

	// combine method for copying all subArray element into larger array A,
	// int x and int y determine the coordinates in the target array where data
	// is to be copied
	public void combine(int[][] subArray, int[][] A, int x, int y) {
		for (int i = 0; i < subArray.length; i++) {
			for (int j = 0; j < subArray.length; j++) {
				A[i + x][j + y] = subArray[i][j];
			}
		}
	}

	// addMatrix method adds two matrices a and b,
	// returns matrix c as a+b
	public int[][] addMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	// subtractMatrix method for subtracting matrix b from matrix a
	// return matrix c as a-b
	public int[][] subtractMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}

	// Strassen Matrix Multiplication algorithm core
	public int[][] strassenMult(int[][] a, int[][] b) {
		int n = a.length;
		// initiate resulting matrix c to be of size n
		int[][] c = new int[n][n];

		// trivial case, bottom up condition
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0];
		}

		else {
			// partition a into submatrices
			int[][] a11 = new int[n / 2][n / 2];
			int[][] a12 = new int[n / 2][n / 2];
			int[][] a21 = new int[n / 2][n / 2];
			int[][] a22 = new int[n / 2][n / 2];
			// partition b into submatrices
			int[][] b11 = new int[n / 2][n / 2];
			int[][] b12 = new int[n / 2][n / 2];
			int[][] b21 = new int[n / 2][n / 2];
			int[][] b22 = new int[n / 2][n / 2];
			// partition c into submatrices
			int[][] c11 = new int[n / 2][n / 2];
			int[][] c12 = new int[n / 2][n / 2];
			int[][] c21 = new int[n / 2][n / 2];
			int[][] c22 = new int[n / 2][n / 2];
			// copy data from a into submatrices
			subCopy(a11, a, 0, 0);
			subCopy(a12, a, 0, n / 2);
			subCopy(a21, a, n / 2, 0);
			subCopy(a22, a, n / 2, n / 2);
			// copy data from b into submatrices
			subCopy(b11, b, 0, 0);
			subCopy(b12, b, 0, n / 2);
			subCopy(b21, b, n / 2, 0);
			subCopy(b22, b, n / 2, n / 2);
			// create 10 new matrices
			int[][] s1 = new int[n / 2][n / 2];
			int[][] s2 = new int[n / 2][n / 2];
			int[][] s3 = new int[n / 2][n / 2];
			int[][] s4 = new int[n / 2][n / 2];
			int[][] s5 = new int[n / 2][n / 2];
			int[][] s6 = new int[n / 2][n / 2];
			int[][] s7 = new int[n / 2][n / 2];
			int[][] s8 = new int[n / 2][n / 2];
			int[][] s9 = new int[n / 2][n / 2];
			int[][] s10 = new int[n / 2][n / 2];
			// calculate each of the 10 matrices according to the Strassen's
			// formulae found in the book
			s1 = subtractMatrix(b12, b22);// S1 = B12 - B22 ;
			s2 = addMatrix(a11, a12);// S2 = A11 + A12 ;
			s3 = addMatrix(a21, a22);// S3 = A21 + A22 ;
			s4 = subtractMatrix(b21, b11);// S4 = B21 - B11 ;
			s5 = addMatrix(a11, a22);// S5 = A11 + A22 ;
			s6 = addMatrix(b11, b22);// S6 = B11 + B22 ;
			s7 = subtractMatrix(a12, a22);// S7 = A12 - A22 ;
			s8 = addMatrix(b21, b22);// S8 = B21 + B22 ;
			s9 = subtractMatrix(a11, a21);// S9 = A11 - A21 ;
			s10 = addMatrix(b11, b12);// S10 = B11 + B12 ;
			// create 7 new matrices to store recursive products
			int[][] p1 = new int[n / 2][n / 2];
			int[][] p2 = new int[n / 2][n / 2];
			int[][] p3 = new int[n / 2][n / 2];
			int[][] p4 = new int[n / 2][n / 2];
			int[][] p5 = new int[n / 2][n / 2];
			int[][] p6 = new int[n / 2][n / 2];
			int[][] p7 = new int[n / 2][n / 2];
			// calculate each of the 7 matrices according to the Strassen's
			// formulae found in the book
			p1 = strassenMult(a11, s1);
			p2 = strassenMult(s2, b22);
			p3 = strassenMult(s3, b11);
			p4 = strassenMult(a22, s4);
			p5 = strassenMult(s5, s6);
			p6 = strassenMult(s7, s8);
			p7 = strassenMult(s9, s10);
			// calculate submatrices of c using previously calculated p matrices
			c11 = addMatrix(subtractMatrix(addMatrix(p5, p4), p2), p6);
			c12 = addMatrix(p1, p2);
			c21 = addMatrix(p3, p4);
			c22 = subtractMatrix(subtractMatrix(addMatrix(p5, p1), p3), p7);
			// finally combine the c submatrices into the resulting c matrix
			combine(c11, c, 0, 0);
			combine(c12, c, 0, n / 2);
			combine(c21, c, n / 2, 0);
			combine(c22, c, n / 2, n / 2);

		}
		// return matrix c=a*b
		return c;
	} // end strassenMult

	// method to be called when calculating the matrix product
	// returns A*B
	public int[][] calculate() {
		return strassenMult(getA(), getB());
	}
}