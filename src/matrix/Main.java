package matrix;

public class Main {

	public static void main(String[] args) {
		double [][] a = {{1, 2}, {3, 4}};
		double [][] b = {{5, 6}, {8, 4}};
		
		SquareMatrix A = new SquareMatrix(a);
		SquareMatrix B = new SquareMatrix(b);
		SquareMatrix C = A.add(B);
		SquareMatrix D = new SquareMatrix(3, 3);

		System.out.println(C);
		System.out.println(D);
	}

}
