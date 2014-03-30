package homework;

/**
 * This class implements the LCS algorithm
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class LCS {
	private int m;
	private int n;
	private int[][] c;
	private char[][] b;

	// LCSLength: computes the length of an LCS of two character sequences;
	// Stores values to c and b matrices
	public void LCSLength(char[] x, char[] y) {
		this.m = x.length; // length of array x
		this.n = y.length; // length of array y
		c = new int[m + 1][n + 1]; // stores c[i,j] values
		b = new char[m + 1][n + 1]; // stores b[i,j] values

		// Computes the entries of matrix c in row-major order;
		// Computes the entries of matrix b that point to the table entry
		// corresponding to the optimal subproblem solution chosen when
		// computing c[i,j];
		// To avoid encoding problems letters s, u and l will be used to
		// represent northwest, upwards and leftwards arrows respectively;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 's';
				} else if (c[i - 1][j] >= c[i][j - 1]) {

					c[i][j] = c[i - 1][j];
					b[i][j] = 'u';
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = 'l';
				}
			}
		}
	}

	// LCSPrint: prints out an LCS of X and Y in the proper, forward order
	public void LCSPrint(char[] x, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i][j] == 's') {
			LCSPrint(x, i - 1, j - 1);
			System.out.print(x[i - 1]);
		} else if (b[i][j] == 'u') {
			LCSPrint(x, i - 1, j);
		} else {
			LCSPrint(x, i, j - 1);
		}
	}
}
