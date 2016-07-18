package test;

import static org.junit.Assert.*;

import org.junit.Test;
import matrix.SquareMatrix;

public class SquareMatrixTest {

	@Test
	public void testSquareMatrixIntInt() {
		
		SquareMatrix matrix = new SquareMatrix(3, 3);
		double [][] matrixExpected = {{0.0, 0.0, 0.0},
									  {0.0, 0.0, 0.0},
									  {0.0, 0.0, 0.0}};
		int rowsExp = matrixExpected.length;
		int colsExp = matrixExpected[0].length;
		assertTrue(matrix.getNumOfColumns() == colsExp);
		assertTrue(matrix.getNumOfRows() == rowsExp);
		assertArrayEquals(matrix.toArray(), matrixExpected);
	}

	@Test
	public void testSquareMatrixDoubleArrayArray() {
		double [][] matrixExpected = {{1.0, 2.0, 3.0},
				  					  {4.0, 5.0, 6.0},
				  					  {7.0, 8.0, 9.0}};
		SquareMatrix matrix = new SquareMatrix(matrixExpected);
		int rowsExp = matrixExpected.length;
		int colsExp = matrixExpected[0].length;
		assertTrue(matrix.getNumOfColumns() == colsExp);
		assertTrue(matrix.getNumOfRows() == rowsExp);
		assertArrayEquals(matrix.toArray(), matrixExpected);
	}

	@Test
	public void testGetNumOfRows() {
		SquareMatrix matrix = new SquareMatrix(5, 5);
		assertTrue(matrix.getNumOfRows() == 5);
	}

	@Test
	public void testGetNumOfColumns() {
		SquareMatrix matrix = new SquareMatrix(5, 5);
		assertTrue(matrix.getNumOfColumns() == 5);
	}

	@Test
	public void testAdd() {
		double [][] dataA = {{1.0, 2.0, 3.0},
				  		 	 {4.0, 5.0, 6.0},
				  		 	 {7.0, 8.0, 9.0}};

		double [][] dataB = {{10.0, 11.0, 12.0},
	  		 	 			 {13.0, 14.0, 15.0},
	  		 	 			 {16.0, 17.0, 18.0}};
		
		double [][] expected = {{11.0, 13.0, 15.0},
	 	 			 		 	{17.0, 19.0, 21.0},
	 	 			 		 	{23.0, 25.0, 27.0}};

		SquareMatrix A = new SquareMatrix(dataA);
		SquareMatrix B = new SquareMatrix(dataB);
		SquareMatrix C = A.add(B);
		assertArrayEquals(C.toArray(), expected);
	}

	@Test
	public void testMultiply() {
		double [][] dataA = {{1.0, 2.0, 3.0},
	  		 	 			 {4.0, 5.0, 6.0},
	  		 	 			 {7.0, 8.0, 9.0}};

		double [][] dataB = {{10.0, 11.0, 12.0},
	 	 			 		 {13.0, 14.0, 15.0},
	 	 			 		 {16.0, 17.0, 18.0}};

		double [][] expected = {{84.0, 90.0, 96.0},
								{201.0, 216.0, 231.0},
								{318.0, 342.0, 366.0}};

		SquareMatrix A = new SquareMatrix(dataA);
		SquareMatrix B = new SquareMatrix(dataB);
		SquareMatrix C = A.multiply(B);
		assertArrayEquals(expected, C.toArray());
	}

	@Test
	public void testToString() {
		double [][] matrixData = {{1.0, 2.0, 3.0},
	 	 			 		 	  {4.0, 5.0, 6.0},
	 	 			 		 	  {7.0, 8.0, 9.0}};
		String expected = "1.0 2.0 3.0\n4.0 5.0 6.0\n7.0 8.0 9.0";
		SquareMatrix matrix = new SquareMatrix(matrixData);
		assertEquals(expected, matrix.toString());
	}

}
