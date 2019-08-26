package graphQuestion;

import java.util.List;

/**
 * It is an interface of graph.
 *
 */
public interface IGraph 
{
    //Method to check whether graph is connected or not.
	boolean isConnected();
	
	//Method to return nodes which are reachable from a particular vertex.
	Integer[] reachable(int node);
	
	//Method to find minimum spanning tree of graph.
	List<Edge> minimumSpanningTree();
	
	//Method to find shortest distance between 2 vertex of graph
	int shortestPath(int vertex1, int vertex2);
}