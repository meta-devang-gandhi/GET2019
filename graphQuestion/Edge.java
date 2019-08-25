package graphQuestion;

import java.util.Comparator;

/**
 *Represent an edge of graph.
 */
public class Edge implements Comparator<Edge>
{	
	private int vertex1;
	private int vertex2;
	private int weight;
	
	/**
	 *Initialize edge attributes.
	 * @param vertex1 
	 * @param vertex2
	 * @param weight 
	 */
	public Edge(int vertex1, int vertex2,int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	/**
	 * Method to return vertex 1.
	 */
	public int getVertex1() 
	{
		return vertex1;
	}

	/**
	 *Method to return vertex 2. 
	 */
	public int getVertex2()
	{
		return vertex2;
	}

	/**
	 * Method to return weight of edge.
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * Comparator for sorting edge collection based on edge's weight
	 */
	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.getWeight() - e2.getWeight();
		}
	};

	@Override
	public int compare(Edge o1, Edge o2) 
	{
		return 0;
	}
}