package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Class to used insert image using batch technique. 
 */
public class BatchImageInserts
{
	int productId;
	public BatchImageInserts(int numId)
    {
		productId = numId;
	}
	
	public void batchInsert() 
	{
		PreparedStatement statement = null;
		Connector connector = new Connector("storefront");
		Connection connection = null;
		
		try 
		{
			connection = connector.connectedToDataBase();
			
			String query  = new Query().BatchImageInserts();
			
			statement = connection.prepareStatement(query);
			
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
				connection.close();
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
