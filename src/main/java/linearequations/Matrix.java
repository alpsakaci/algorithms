package linearequations;

public class Matrix {
	private double[][] data;

	public Matrix(int m, int n) {
		data = new double[m][n];
	}

	public Matrix(double[][] data) {
		this.data = data;
	}

	public void setIdentity() {
		int nrows = data.length;
		int ncols = data[0].length;

		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				if (i == j)
					data[i][j] = 1.0;
				else
					data[i][j] = 0.0;
			}
		}
	}

	public int getNumRows() {
		return data.length;
	}

	public int getNumCols() {
		return data[0].length;
	}

	public double getElement(int i, int j) {
		return data[i][j];
	}

	public void setElement(int i, int j, double val) {
		data[i][j] = val;
	}

	public void incrElement(int i, int j, double incr) {
		data[i][j] += incr;
	}

	public Matrix add(Matrix b) {
		Matrix result = null;

		int nrows = data.length;
		int ncols = data[0].length;

		if (nrows == b.data.length && ncols == b.data[0].length) {
			result = new Matrix(nrows, ncols);
			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < ncols; j++) {
					result.data[i][j] = this.data[i][j] + b.data[i][j];
				}
			}
		}

		return result;
	}

	public Matrix mult(Matrix b) {
		Matrix result = null;

		int nrows = data.length;
		int p = data[0].length;

		if (p == b.data.length) {
			result = new Matrix(nrows, b.data[0].length);
			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < result.data[0].length; j++) {
					double t = 0.0;
					for (int k = 0; k < p; k++) {
						t += data[i][k] * b.data[k][j];
					}
					result.data[i][j] = t;
				}
			}
		}

		return result;
	}

	public void print() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + "\t");
			}

			System.out.println();
		}

		System.out.println();
	}

	public static Matrix gaussian(Matrix a, Matrix b) {
		int n = a.data.length; // Number of unknowns
		Matrix q = new Matrix(n, n + 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) { // Form q matrix
				q.data[i][j] = a.data[i][j];
			}

			q.data[i][n] = b.data[i][0];
		}

		solveForward(q); // Do Gaussian elimination
		solveBack(q); // Perform back substitution

		Matrix x = new Matrix(n, 1);
		for (int i = 0; i < n; i++) {
			x.data[i][0] = q.data[i][n];
		}

		return x;
	}

	private static void solveForward(Matrix q) {
		int n = q.data.length;

		for (int i = 0; i < n; i++) { // Find row w/max element in this
			int maxRow = i; // column, at or below diagonal
			for (int k = i + 1; k < n; k++) {
				if (Math.abs(q.data[k][i]) > Math.abs(q.data[maxRow][i])) {
					maxRow = k;
				}
			}
				

			if (maxRow != i) {// If row not current row, swap
				for (int j = i; j <= n; j++) {
					double t = q.data[i][j];
					q.data[i][j] = q.data[maxRow][j];
					q.data[maxRow][j] = t;
				}
			}

			for (int j = i + 1; j < n; j++) { // Calculate pivot ratio
				double pivot = q.data[j][i] / q.data[i][i];
				for (int k = i; k <= n; k++) { // Pivot operation itself
					q.data[j][k] -= q.data[i][k] * pivot;
				}
			}
		}
	}

	private static void solveBack(Matrix q) {
		int n = q.data.length;

		for (int j = n - 1; j >= 0; j--) { // Start at last row
			double t = 0.0; // t- temporary
			for (int k = j + 1; k < n; k++) {
				t += q.data[j][k] * q.data[k][n];
			}
			q.data[j][n] = (q.data[j][n] - t) / q.data[j][j];
		}
	}
	
}
