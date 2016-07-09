package matrix;

public class Matrix {
	private final int numOfRows; /**< number of numOfRows */
	private final int numOfColumns; /**< number of numOfColumns */
	private final double [][] matrix;

	public Matrix(int numOfRows, int numOfColumns)
	{
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		matrix = new double[numOfRows][numOfColumns];
	}
	
	public Matrix(double[][] data)
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
	
	public int getNumOfRows()
	{
		return this.numOfRows;
	}
	
	public int getNumOfColumns()
	{
		return this.numOfColumns;
	}
	
	public Matrix add(Matrix B)
	{
		if (B.numOfRows != this.numOfRows && B.numOfColumns != this.numOfColumns)
		{
			throw new RuntimeException("The matrix dimensions are not equal.");
		}
		Matrix C = new Matrix(this.numOfRows, this.numOfColumns);
		for (int rowIdx = 0; rowIdx < this.numOfRows; rowIdx++)
		{
			for (int colIdx = 0; colIdx < this.numOfColumns; colIdx++)
			{
				C.matrix[rowIdx][colIdx] = this.matrix[rowIdx][colIdx] + B.matrix[rowIdx][colIdx]; 
			}
		}
		return C;
	}
	
	public void multiply(Matrix B)
	{
		if (B.numOfRows != this.numOfRows && B.numOfColumns != this.numOfColumns)
		{
			throw new RuntimeException("");
		}
		Matrix C = new Matrix(B.numOfRows, B.numOfColumns);
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
