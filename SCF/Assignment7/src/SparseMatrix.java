/**
 * Class is used to perform matrix function like add, multiplication, transpose
 * Class is immutable.
 * @author devang2304
 */
public final class SparseMatrix
{
	private final int[][] sparseMatrix;
	
	/**
	 * Constructor used to take sparse matrix and and eliminate the zero from the Sparse matrix. 
	 * @param array input sparse matrix
	 */
   public SparseMatrix(int array[][])
   {
	   int size = SparseMatrix.countNonZero(array);
	   this.sparseMatrix = new int[3][size];
	   int sparseCount = 0;

	   for (int i = 0; i < array.length; i++)
	   {
	        for (int j = 0; j < array[0].length; j++)
	        {
	           if (array[i][j] != 0)
	           {
	              sparseMatrix[0][sparseCount] = i;
	              sparseMatrix[1][sparseCount] = j;
	              sparseMatrix[2][sparseCount] = array[i][j];
	              sparseCount++;
	            }
	        }
	   }
   }
   
   /**
    * Method used to find size nonzero element of the sparse matrix
    * @param array
    * @return size of nonzero element
    */
   public static int countNonZero(int array[][]) 
   {
	   int count = 0;
	   int length = array.length;
	   for (int i = 0; i < length; i++) 
	   {
	      for (int j = 0; j < length; j++) 
	      {
	          if (array[i][j] != 0)
	          {
	             count++;
	          }
	      }
	   }
	   return count;
   }

   /**
    * Method convert the matrix into transpose matrix
    * @return transpose matrix.
    */
   public int[][] transpose()
   {
	   int transposeMatrix[][] = new int[sparseMatrix.length][sparseMatrix[0].length];
	   
	   
	   System.out.println("-----------------------");
	   int i=0;
		   for(int j=0; j<sparseMatrix[0].length; j++)
		   {
			
			   transposeMatrix[i][j] = sparseMatrix[i+1][j];
			   transposeMatrix[i+1][j] = sparseMatrix[i][j]; 
			   transposeMatrix[i+2][j] = sparseMatrix[i+2][j];
			   
			   for(int k=j; k > 0; k--)
			   {
			 
			   if(   transposeMatrix[i][k] <= transposeMatrix[i][k-1])
			   {
				   if(transposeMatrix[i][k] == transposeMatrix[i][k-1])
				   {
					   if(transposeMatrix[i+1][k]< transposeMatrix[i+1][k-1])
					   {
						   int temp = transposeMatrix[i+1][k];
						   transposeMatrix[i+1][k] = transposeMatrix[i+1][k-1];
						   transposeMatrix[i+1][k-1] = temp;
						   
						    temp = transposeMatrix[i][k];
						   transposeMatrix[i][k] = transposeMatrix[i][k-1];
						   transposeMatrix[i][k-1] = temp;
						   
						    temp = transposeMatrix[i+2][k];
						   transposeMatrix[i+2][k] = transposeMatrix[i+2][k-1];
						   transposeMatrix[i+2][k-1] = temp;
					   }
				   }
				   else
				   {
					   int temp = transposeMatrix[i][k];
					   transposeMatrix[i][k] = transposeMatrix[i][k-1];
					   transposeMatrix[i][k-1] = temp;
					   
					   temp = transposeMatrix[i+2][k];
					   transposeMatrix[i+2][k] = transposeMatrix[i+2][k-1];
					   transposeMatrix[i+2][k-1] = temp;
					   
					    temp = transposeMatrix[i+1][k];
					   transposeMatrix[i+1][k] = transposeMatrix[i+1][k-1];
					   transposeMatrix[i+1][k-1] = temp;
				   }
			   }
			  }			   
	       } 
	   
	   return transposeMatrix ;
   }
   /**
    * Method check the transpose matrix or original matrix is same or not.
    * @return If matrix is same then return true else false
    */
   public boolean symmetric()
   {
	   int [][] transposeMatrix = transpose();
	   int length = sparseMatrix.length;
	   int counter = 0;
	   for(int index = 0; index < length; index++ )
	   {
		   if(sparseMatrix[0][index] == transposeMatrix[0][index] && sparseMatrix[1][index] == transposeMatrix[1][index] && sparseMatrix[2][index] == transposeMatrix[2][index])
		   {
			   counter++;
		   }
	   }
	   
	   if(counter == length)
	   {
		   return true;
	   }
	   return  false;
   }
   
   
   public static void main(String[] args) throws Exception
   {
	   int arr[][] = new int[][] { { 1,0,0,0 }, { 0, 2, 0, 0 },
	   { 0, 0, 3, 0 }, { 0, 0, 0, 4 } };

	   for (int i = 0; i < arr.length; i++) {
	   for (int j = 0; j < arr[0].length; j++)
	   System.out.print(arr[i][j] + "  ");

	   System.out.println();
	   }
	   System.out.println("-----------------------");
	   SparseMatrix matrix = new SparseMatrix(arr);
	   for(int i=0 ; i<matrix.sparseMatrix.length; i++)
	   {
	   for(int j=0; j<matrix.sparseMatrix[0].length; j++)
	   {
		   System.out.print( matrix.sparseMatrix[i][j]+"  ");
		   }
	   System.out.println();
		   	  
	  }
	 int[][] transposematrix =   matrix.transpose();
	 System.out.println("-----------------------Transpose -----------");
	 for(int i=0 ; i<transposematrix.length; i++)
	   {
	   for(int j=0; j<transposematrix[0].length; j++)
	   {
		   System.out.print( transposematrix[i][j]+"  ");
		   }
	   System.out.println();
		   	  
	   
	  }
	 System.out.println(matrix.symmetric());
   }
}
