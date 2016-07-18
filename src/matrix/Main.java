package matrix;

public class Main {

	public static void main(String[] args) {
		double [][] a = {{1, 2}, {3, 4}};
		double [][] b = {{5, 6}, {8, 4}};
		
		SquareMatrix A = new SquareMatrix(a);
		SquareMatrix B = new SquareMatrix(b);
		SquareMatrix C = A.add(B);
		SquareMatrix D = A.multiply(B);

		System.out.println(C);
		System.out.println(D);
		System.out.println(a.length + " " + a[0].length);
	}

}
