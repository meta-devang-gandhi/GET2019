import java.io.IOException;

/**
 * This class contain methods to perform operation on sparse Matrices
 * @author Devang
 *
 */
public class SparseMatrice 
{
	private final int[][] sparseMatrice;
	private final int matriceRows;
	private final int matriceColumns;

	/**
	 *" Constructor used to initialize matrix in reduced form
	 * @param reducedSparseMatrice " containing information about nonzero element row,column and value"
	 * @param matriceRow "number of rows in original matrix"
	 * @param matriceColumn "number of column in original matrix"
	 */
	public SparseMatrice(int[][] reducedSparseMatrice, int matriceRow, int matriceColumn)
	{
		this.sparseMatrice = reducedSparseMatrice;
		this.matriceColumns = matriceRow;
		this.matriceRows = matriceColumn;
	}
	
	/**
	 * Constructor initializing sparse matrix than storing only non zero element and their row and column
	 * @param matrice  sparse matrix
	 */
	public SparseMatrice(int matrice[][])
	{
		this.matriceRows = matrice.length;
		this.matriceColumns = matrice[0].length;
		int countOfNonZeroElement = countNonZeroElementInSparseMatrice(matrice);
		this.sparseMatrice = new int[countOfNonZeroElement][3];

		int rowIndex = 0;
		int rowLength = matrice.length;
		int columnLength =  matrice[0].length;
		
		for (int arrayRowIndex = 0; arrayRowIndex < rowLength; arrayRowIndex++)
		{
			for (int arrayColIndex = 0; arrayColIndex < columnLength; arrayColIndex++) 
			{
				if (matrice[arrayRowIndex][arrayColIndex] != 0)
				{
					this.sparseMatrice[rowIndex][0] = arrayRowIndex;
					this.sparseMatrice[rowIndex][1] = arrayColIndex;
					this.sparseMatrice[rowIndex][2] = matrice[arrayRowIndex][arrayColIndex];
					rowIndex++;
				}
			}
		}
	}

	/**
	 * Method count the non zero elements in the sparse matrix
	 * @param matrice "sparse matrix"
	 * @return "number of non zero element"
	 */
	private int countNonZeroElementInSparseMatrice(int[][] matrice)
	{
		int countOfNonZeroElement = 0;
		int rowLength = matrice.length;
		int columnLength =  matrice[0].length;
		
		for (int arrayRowIndex = 0; arrayRowIndex < rowLength; arrayRowIndex++) 
		{
			for (int arrayColIndex = 0; arrayColIndex < columnLength; arrayColIndex++)
			{
				if (matrice[arrayRowIndex][arrayColIndex] != 0)
				{
					countOfNonZeroElement++;
				}
			}
		}
		return countOfNonZeroElement;
	}
	
	/**
	 *  Method convert the reduced sparse matrix array to its full size matrix
	 * @return  "full size sparse matrix array containing zero element and non zero elements"
	 */
	public int[][] getMatrice()
	{
		int matriceRow = this.matriceRows;
		int matriceColumn = this.matriceColumns;
		int matrice[][] = new int[matriceRows][matriceColumns];
		
		for (int matriceRowIndex = 0; matriceRowIndex < matriceRow; matriceRowIndex++)
		{
			for (int matriceColumnIndex = 0; matriceColumnIndex < matriceColumn; matriceColumnIndex++)
			{
				boolean elementFound = false;
				int sparseMatriceLength = this.sparseMatrice.length;
				for(int rowIndex = 0; rowIndex < sparseMatriceLength; rowIndex++)
				{
					if (this.sparseMatrice[rowIndex][0] == matriceRowIndex	&& this.sparseMatrice[rowIndex][1] == matriceColumnIndex)
					{
						elementFound = true;
						matrice[matriceRowIndex][matriceColumnIndex] = this.sparseMatrice[rowIndex][2];
						rowIndex++;
						break;
					}
				}
					if(!elementFound)
					{
						matrice[matriceRowIndex][matriceColumnIndex] = 0;
					}
			}
		}
		return matrice;
	}

	/**
	 * Method  used to multiply two sparse matrices
	 * @param matrice "Object of SparseMatrice class containing only non zero element"
	 * @return "Object of SparseMatrice containing only non zero element"
	 * @throws IOException throws io exception when column of first matrix is not equal to the rows of second matrix
	 */
	public SparseMatrice getMultiplicationOfTwoSparseMatrice(SparseMatrice matrice) throws IOException
	{
		if(this.matriceColumns != matrice.matriceRows)
		{
			throw new IOException("Can't perform multiplication");
		}
		
		int[][] multiplyMatrice = new int[this.matriceRows][matrice.matriceColumns];
		int sum = 0;
		int firstMatriceElement = 0;
		boolean firstMatriceElementFound = false;
		boolean secondMatriceElementFound = false;
		int secondMatriceElement = 0;
		
		for (int firstMatriceRowIndex = 0; firstMatriceRowIndex < this.matriceRows; firstMatriceRowIndex++)
		{
			for (int secondMatriceColumnIndex = 0; secondMatriceColumnIndex < matrice.matriceColumns; secondMatriceColumnIndex++) 
			{
				for (int firstMatriceColumnIndex = 0; firstMatriceColumnIndex < this.matriceColumns; firstMatriceColumnIndex++)
				{
					for (int rowIndex = 0; rowIndex < this.sparseMatrice.length; rowIndex++)
					{
						if (this.sparseMatrice[rowIndex][0] == firstMatriceRowIndex	&& this.sparseMatrice[rowIndex][1] == firstMatriceColumnIndex)
						{
							firstMatriceElement = this.sparseMatrice[rowIndex][2];
							firstMatriceElementFound = true;
							break;
						}
					}
					for (int rowIndex = 0; rowIndex < matrice.sparseMatrice.length; rowIndex++)
					{
						if (matrice.sparseMatrice[rowIndex][0] == firstMatriceColumnIndex && matrice.sparseMatrice[rowIndex][1] == secondMatriceColumnIndex) 
						{
							secondMatriceElement = matrice.sparseMatrice[rowIndex][2];
							secondMatriceElementFound = true;
							break;
						}
					}
					if (!firstMatriceElementFound) 
					{
						firstMatriceElement = 0;
					}
					if (!secondMatriceElementFound)
					{
						secondMatriceElement = 0;
					}
					sum = sum + firstMatriceElement * secondMatriceElement;
					firstMatriceElementFound = false;
					secondMatriceElementFound = false;
				}

				multiplyMatrice[firstMatriceRowIndex][secondMatriceColumnIndex] = sum;
				sum = 0;
			}
		}
		return new SparseMatrice(multiplyMatrice);
	}
	
	/**
	 * Method  used to find transpose of sparse matrix
	 * @return object of SparseMatrice containing non zero element of transpose matrix 
	 */
	public SparseMatrice getTransposeOfSparseMatrice()
	{
		int[][] transposeMatrice = new int[this.sparseMatrice.length][3];
		
		for(int rowIndex = 0; rowIndex < this.sparseMatrice.length; rowIndex++)
		{
			transposeMatrice[rowIndex][0] = this.sparseMatrice[rowIndex][1];
			transposeMatrice[rowIndex][1] = this.sparseMatrice[rowIndex][0];
			transposeMatrice[rowIndex][2] = this.sparseMatrice[rowIndex][2];
		}
		
		transposeMatrice = sortMatriceAccordingToRowColumn(transposeMatrice);
		return new SparseMatrice(transposeMatrice,this.matriceColumns,this.matriceRows);
	}
	
	/**
	 * Method  used to sort the matrix containing only non zero element 
	 * @param matrice  "Array containing row,column and value of non zero element"
	 * @return "Sorted array "
	 */
	private int[][] sortMatriceAccordingToRowColumn(int[][] matrice)
	{
		for(int firstRowIndex = 0; firstRowIndex < matrice.length; firstRowIndex++)
		{
			for(int secondRowIndex = (firstRowIndex+1); secondRowIndex < matrice.length; secondRowIndex++ )
			{
				if(matrice[firstRowIndex][0] > matrice[secondRowIndex][0])
				{
					int tempData = matrice[secondRowIndex][0];
					matrice[secondRowIndex][0] = matrice[firstRowIndex][0];
					matrice[firstRowIndex][0] = tempData;
					
					tempData = matrice[secondRowIndex][1];
					matrice[secondRowIndex][1] = matrice[firstRowIndex][1];
					matrice[firstRowIndex][1] = tempData;
					
					tempData = matrice[secondRowIndex][2];
					matrice[secondRowIndex][2] = matrice[firstRowIndex][2];
					matrice[firstRowIndex][2] = tempData;
				}
			}
		}
		
		for(int firstRowIndex =0; firstRowIndex < matrice.length; firstRowIndex++)
		{
			for(int secondRowIndex = (firstRowIndex+1); secondRowIndex < matrice.length; secondRowIndex++ )
			{
				if(matrice[firstRowIndex][0] == matrice[secondRowIndex][0])
				{
					if(matrice[firstRowIndex][1] > matrice[secondRowIndex][1])
					{
						int tempData = matrice[secondRowIndex][1];
						
						matrice[secondRowIndex][1] = matrice[firstRowIndex][1];
						matrice[firstRowIndex][1] = tempData;
						
						tempData = matrice[secondRowIndex][2];
						matrice[secondRowIndex][2] = matrice[firstRowIndex][2];
						matrice[firstRowIndex][2] = tempData;
					}
				}
			}
		}
		return matrice;
	}
	
	/**
	 * Method  used to check if given matrix is symmetrical or not
	 * @return  if matrix is symmetrical then return true else false
	 */
	public boolean isSparseMatriceSymmetrical()
	{	
		SparseMatrice transposeMatrice = this.getTransposeOfSparseMatrice();
		int counter=0;
		for(int indexValueFirst=0;indexValueFirst<this.sparseMatrice.length;indexValueFirst++)
		{
			for(int indexValueSecond=0;indexValueSecond<transposeMatrice.sparseMatrice.length;indexValueSecond++)
			{
				if(this.sparseMatrice[indexValueFirst][0] == transposeMatrice.sparseMatrice[indexValueSecond][0] && this.sparseMatrice[indexValueFirst][1] == transposeMatrice.sparseMatrice[indexValueSecond][1] && this.sparseMatrice[indexValueFirst][2] == transposeMatrice.sparseMatrice[indexValueSecond][2])
				{
					counter++;
				}
			}
		}
		if(counter==this.sparseMatrice.length)
		{ 
			return true; 
		}
		return false;
	}
	
	/**
	 * Method  used to add two sparse matrices
	 * @param matrice "Object of SparseMatrice class containing only non zero element"
	 * @return "object of SparseMatrice containing only non zero element"
	 * @throws IOException throws io exception when row and column of first matrix is not equal to the rows and column
	 *  of second matrix
	 */
	public SparseMatrice getAdditionOfTwoSparseMatrice(SparseMatrice matrice) throws IOException
	{
		if(this.matriceRows != matrice.matriceRows || this.matriceColumns != matrice.matriceColumns)
		{
			throw new IOException("Can't perform addition");
		}
		
		int sameElementCount =0;
		for(int firstMatriceRowIndex = 0; firstMatriceRowIndex < this.sparseMatrice.length;firstMatriceRowIndex++)
		{
			boolean elementFound = false;
			for(int secondMatriceRowIndex =0; secondMatriceRowIndex < matrice.sparseMatrice.length; secondMatriceRowIndex++)
			{
				if(this.sparseMatrice[firstMatriceRowIndex][0] == matrice.sparseMatrice[secondMatriceRowIndex][0]){
					if(this.sparseMatrice[firstMatriceRowIndex][1] == matrice.sparseMatrice[secondMatriceRowIndex][1])
					{
						sameElementCount++;
					}
				}
			}
			
		}
		int[][] additionMatrice = new int[ (this.sparseMatrice.length + matrice.sparseMatrice.length) - sameElementCount ][3];
		int rowIndex =0;
		for(int firstMatriceRowIndex = 0; firstMatriceRowIndex < this.sparseMatrice.length;firstMatriceRowIndex++)
		{
			boolean elementFound =false;
			for(int secondMatriceRowIndex =0; secondMatriceRowIndex < matrice.sparseMatrice.length; secondMatriceRowIndex++)
			{
				if(this.sparseMatrice[firstMatriceRowIndex][0] == matrice.sparseMatrice[secondMatriceRowIndex][0])
				{
					if(this.sparseMatrice[firstMatriceRowIndex][1] == matrice.sparseMatrice[secondMatriceRowIndex][1])
					{
						additionMatrice[rowIndex][0] = this.sparseMatrice[firstMatriceRowIndex][0];
						additionMatrice[rowIndex][1] = this.sparseMatrice[firstMatriceRowIndex][1];
						additionMatrice[rowIndex][2] = this.sparseMatrice[firstMatriceRowIndex][2] + matrice.sparseMatrice[secondMatriceRowIndex][2];
						rowIndex++;
						elementFound = true;
					}
				}
			}
			if(!elementFound)
			{
				additionMatrice[rowIndex][0] = this.sparseMatrice[firstMatriceRowIndex][0];
				additionMatrice[rowIndex][1] = this.sparseMatrice[firstMatriceRowIndex][1];
				additionMatrice[rowIndex][2] = this.sparseMatrice[firstMatriceRowIndex][2]; 
				rowIndex++;
			}
		}
		
		for(int firstMatriceRowIndex = 0; firstMatriceRowIndex < matrice.sparseMatrice.length;firstMatriceRowIndex++)
		{
			boolean elementFound =false;
			for(int secondMatriceRowIndex =0; secondMatriceRowIndex < this.sparseMatrice.length; secondMatriceRowIndex++)
			{
				if(matrice.sparseMatrice[firstMatriceRowIndex][0] == this.sparseMatrice[secondMatriceRowIndex][0])
				{
					if(matrice.sparseMatrice[firstMatriceRowIndex][1] == this.sparseMatrice[secondMatriceRowIndex][1])
					{
						elementFound = true;
					}
				}
			}
			if(!elementFound)
			{
				additionMatrice[rowIndex][0] = matrice.sparseMatrice[firstMatriceRowIndex][0];
				additionMatrice[rowIndex][1] = matrice.sparseMatrice[firstMatriceRowIndex][1];
				additionMatrice[rowIndex][2] = matrice.sparseMatrice[firstMatriceRowIndex][2]; 
				rowIndex++;
			}
		}
		return new SparseMatrice(additionMatrice,this.matriceRows,this.matriceColumns);
		
	}
}