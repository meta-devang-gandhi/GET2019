package graphQuestion;

import java.util.Comparator;

public class Pair implements Comparator<Pair>
{
	private int weight;
	private int vertex;

	/**
	 *Constructor to initialize pair attribute.
	 * @param weight
	 * @param vertex
	 */
	Pair(int weight, int vertex)
	{
		this.weight = weight;
		this.vertex = vertex;
	}

	/**
	 *Method to return edge weight.
	 */
	public int getWeight() 
	{
		return this.weight;
	}

	/**
	 * Method to return vertex.
	 */
	public int getVertex()
	{
		return  this.vertex;
	}
	
	public static final Comparator<Pair> sortPairByWeight = new Comparator<Pair>() 
	{
		@Override
		public int compare(Pair pair1, Pair pair2)
		{
			return pair1.getWeight() - pair2.getWeight();
		}
	};

	@Override
	public int compare(Pair o1, Pair o2) 
	{
		return 0;
	}

}
