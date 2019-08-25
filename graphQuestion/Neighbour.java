package graphQuestion;

/**
 *Represent neighbour vertexes of vertex.
 */
public class Neighbour 
{
	private int neighbourVertex;
	private int edgeWeight;

	/**
	 * Constructor to initialize neighbour vertex.
	 * @param vertex neighbour vertex.
	 * @param edgeWeight edge weight of neighbour vertex.
	 */
	Neighbour(int vertex, int edgeWeight)
	{
		this.neighbourVertex = vertex;
		this.edgeWeight = edgeWeight;
	}

	/**
	 * Method to return neighbour vertex.
	 */
	public int getNeighbourVertex() 
	{
		return this.neighbourVertex;
	}

	/**
	 * Method to return edge weight.
	 */
	public int getEdgeWeight() 
	{
		return this.edgeWeight;
	}
}