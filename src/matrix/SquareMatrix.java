package matrix;

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
		this.numOfRows = data.length;
		this.numOfColumns = data[0].length;
		matrix = new double[numOfRows][numOfColumns];

		for (int rowIdx = 0; rowIdx < this.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < this.numOfColumns; colIdx++)
			{
				this.matrix[rowIdx][colIdx] = data[rowIdx][colIdx];
			}
		}
	}
	/**
	 * @return number of Matrix rows
	 */
	public int getNumOfRows()
	{
		return this.numOfRows;
	}
	/**
	 * @return number of Matrix columns
	 */
	public int getNumOfColumns()
	{
		return this.numOfColumns;
	}
	
	public SquareMatrix add(SquareMatrix B)
	{
		if (B.numOfRows != this.numOfRows && B.numOfColumns != this.numOfColumns)
		{
			throw new RuntimeException("The matrix dimensions are not equal.");
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
	
	public void multiply(SquareMatrix B)
	{
		if (B.numOfRows != this.numOfRows && B.numOfColumns != this.numOfColumns)
		{
			throw new RuntimeException("");
		}
		SquareMatrix C = new SquareMatrix(B.numOfRows, B.numOfColumns);
	}

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
			matrix += "\n";
		}
		return matrix;
	}
}
