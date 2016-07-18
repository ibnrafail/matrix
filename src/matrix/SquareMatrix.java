package matrix;

import java.util.Arrays;

/**
 * Class of square matrix.
 *   
 * @author Iskandar Gabdrakhmanov faruk.iskandar@yandex.ru
 *
 */
public class SquareMatrix {
	private final int numOfRows; /**< number of numOfRows */
	private final int numOfColumns; /**< number of numOfColumns */
	private final double [][] matrix;
	
	/**
	 * Basic Matrix class constructor.
	 * @param numOfRows number of matrix rows.
	 * @param numOfColumns number of matrix columns.
	 */
	public SquareMatrix(int numOfRows, int numOfColumns)
	{
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		matrix = new double[numOfRows][numOfColumns];
		this.resetMatrix();
	}
	public SquareMatrix(int dimension)
	{
		this(dimension, dimension);
	}
	/**
	 * Constructor that takes an array as Matrix initializer.
	 * @param data 2d array for Matrix object initialization.
	 */
	public SquareMatrix(double[][] data)
	{
		double firstRowLen = data[0].length;
		for (int rowIdx = 0; rowIdx < data.length; rowIdx++)
		{
			if (firstRowLen != data[rowIdx].length)
				throw new RuntimeException("The matrix is not square."); 
		}
		numOfRows = data.length;
		numOfColumns = data[0].length;
		matrix = new double[numOfRows][numOfColumns];
		for (int rowIdx = 0; rowIdx < numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < numOfColumns; colIdx++)
			{
				this.matrix[rowIdx][colIdx] = data[rowIdx][colIdx];
			}
		}
	}
	/**
	 * @return number of Matrix rows.
	 */
	public int getNumOfRows()
	{
		return this.numOfRows;
	}
	/**
	 * @return number of Matrix columns.
	 */
	public int getNumOfColumns()
	{
		return this.numOfColumns;
	}
	/**
	 * Returns matrix as an array.
	 */
	public double [][] toArray()
	{
		return this.matrix;
	}
	/**
	 * Adds one square matrix to another.
	 * @param B object of SquareMatrix.
	 * @return result of two matrix addition of type.
	 * 		   SquareMatrix.
	 */
	public SquareMatrix add(SquareMatrix B)
	{
		if (B.numOfRows != this.numOfRows && B.numOfColumns != this.numOfColumns)
		{
			throw new RuntimeException("The matrix dimensions don't match.");
		}
		SquareMatrix C = new SquareMatrix(this.numOfRows, this.numOfColumns);
		
		for (int rowIdx = 0; rowIdx < this.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < this.numOfColumns; colIdx++)
			{
				C.matrix[rowIdx][colIdx] = this.matrix[rowIdx][colIdx] + B.matrix[rowIdx][colIdx]; 
			}
		}
		return C;
	}
	/**
	 * Multiplies one square matrix with another.
	 * @param B object of SquareMatrix.
	 * @return result of two matrix multiplication of type
	 * 		   SquareMatrix.
	 */
	public SquareMatrix multiply(SquareMatrix B)
	{
		if (this.numOfColumns != B.numOfRows)
		{
			throw new RuntimeException("The matrix dimensions don't match (A.numOfColumns != B.numOfRows).");
		}
		SquareMatrix C = new SquareMatrix(this.numOfRows, B.numOfColumns);
		for (int rowIdx = 0; rowIdx < C.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < C.numOfColumns; colIdx++)
			{
				C.matrix[rowIdx][colIdx] = 0;
				for (int idx = 0; idx < this.numOfColumns; idx++)
				{
					C.matrix[rowIdx][colIdx] += this.matrix[rowIdx][idx] * B.matrix[idx][colIdx];
				}
			}
		}
		return C;
	}
	/**
	 * Sets all matrix elements to null.
	 */
	public void resetMatrix()
	{
		for (int rowIdx = 0; rowIdx < this.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < this.numOfColumns; colIdx++)
			{
				this.matrix[rowIdx][colIdx] = 0;
			}
		}
	}
	/**
	 * Generates hash code for SquareMatrix object.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + numOfColumns;
		result = prime * result + numOfRows;
		return result;
	}
	/**
	 * Checks whether to SquareMatrix objects equal or not
	 * @return boolean value with comparison result
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (numOfColumns != other.numOfColumns)
			return false;
		if (numOfRows != other.numOfRows)
			return false;

		return true;
	}
	/**
	 * Returns a string representation of SquareMatrix. 
	 */
	public String toString()
	{
		String matrix = new String();
		for (int rowIdx = 0; rowIdx < this.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < this.numOfColumns; colIdx++)
			{
				matrix += String.valueOf(this.matrix[rowIdx][colIdx]);
				if (colIdx != this.numOfColumns - 1)
				{
					matrix += " ";
				}
			}
			if (rowIdx != this.numOfRows - 1)
			{
				matrix += "\n";
			}
		}
		return matrix;
	}
	public static SquareMatrix generateIdentity(int dimension)
	{
		SquareMatrix C = new SquareMatrix(dimension);
		for (int idx = 0; idx < dimension; idx++)
		{
			C.matrix[idx][idx] = 1;
		}
		return C;
	}
}
