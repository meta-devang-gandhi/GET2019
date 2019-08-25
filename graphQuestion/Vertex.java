package graphQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Represent the vertex of graph.
 */
public class Vertex
{	
	private List<Neighbour> neighbours = new LinkedList<Neighbour>();

	/**
	 *Method to add neighbour vertex.
	 * @param vertex neighbour vertex.
	 * @param edgeWeight edge weight of neighbour vertex.
	 */
	public void addNeighbour(int vertex, int edgeWeight) 
	{
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}

	/**
	 * Method to return list of neighbour vertex.
	 */
	public List<Neighbour> getNeighbourList() 
	{
		return this.neighbours;
	}
}