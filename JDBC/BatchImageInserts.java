package JDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Class to used insert image using batch technique. 
 */
public class BatchImageInserts
{
	int productId;
	MethodClass methodObj = null;
	public BatchImageInserts(int numId)
    {
		productId = numId;
		methodObj = new MethodClass();
	}
	
	public void batchInsert() 
	{
		PreparedStatement statement = null;
		try 
		{
			String query  = Query.BatchImageInserts();
		     statement = methodObj.getConnection(query);
			int size = 9, row = 0;

			for (row = 0; row < size; row++) 
			{
				statement.setString(1, "Name" + row);
				statement.setInt(2, productId);

				statement.addBatch();

				if (row % 5 == 0)
				{
					statement.executeBatch();
				}
			}
			
			statement.executeBatch();
			System.out.println(row + " rows added");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch(Exception e)
		{
	    	e.printStackTrace();
	    }
		finally 
		{
			try 
			{
				statement.close();	
				methodObj.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		BatchImageInserts insertImage = new BatchImageInserts(7);
		insertImage.batchInsert();
    }
}
