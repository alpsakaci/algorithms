package linearequations;

public class Gaussian {

	public static void main(String[] args) {
		double[][] arr1 = { 
				{ 3, 1, -2 },
				{ 2, 4, 3 },
				{ 1, -3, 0 }
			};

		double[][] arr2 = {
				{ 5 },
				{ 35 },
				{ -5 }
			};

		Matrix a = new Matrix(arr1);
		Matrix b = new Matrix(arr2);

		Matrix x = Matrix.gaussian(a, b);
		System.out.println("Matrix a:");
		a.print();
		System.out.println("Vector b:");
		b.print();
		System.out.println("Solution vector x:");
		x.print();

	}

}
