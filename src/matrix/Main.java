package matrix;

public class Main {

	public static void main(String[] args) {
		double [][] a = {{1, 2}, {3, 4}};
		double [][] b = {{5, 6}, {8, 4}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		Matrix C = A.add(B);

		System.out.println(C.toString());
	}

}
