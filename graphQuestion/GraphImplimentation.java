package graphQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 *It perform graph's operation.
 */
public class GraphImplimentation implements IGraph 
{

	private int numberOfVertices;
	private Vertex vertices[];
	private LinkedList<Edge> edgeList;
	
	 /**
	 *Constructor to initialize a graph.
	 * @param numberOfVertices number of vertices in graph.
	 */
	public GraphImplimentation(int numberOfVertices)
	{
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();
		for(int index = 0; index < numberOfVertices; index++)
		{
			vertices[index]=new Vertex();
		}
	}
	
	/**
	 *Method to return number of vertices.
	 */
	public int getNumberOfVertices() 
	{
		return numberOfVertices;
	}

	/**
	 *Method to return edge list.
	 */
	public LinkedList<Edge> getEdgeList() 
	{
		return edgeList;
	}

	/**
	 *Method to add edges in undirected graph 
	 * @param source
	 * @param destination
	 * @param weight weight of edge.
	 */
	public void addEdge(int source, int destination,int weight) 
	{
		edgeList.add(new Edge(source, destination, weight));
		this.vertices[source].addNeighbour(destination, weight);
		this.vertices[destination].addNeighbour(source, weight);
	}

	/**
	 *Method to check whether graph is connected or not.
	 * @return 
	 */
	@Override
	public boolean isConnected() 
	{	
		return  (this.numberOfVertices <= 0) ?  false: this.dfs(0).size() == this.getNumberOfVertices();
	}
	
	/**
	 *Method to return nodes which are reachable from a particular vertex.
	 * @param vertex whose reachable nodes to be return.
	 * @return reachable nodes array.
	 */
	@Override
	public Integer[] reachable(int vertex) 
	{
		Set<Integer> visitedVertex = this.dfs(vertex);
		Integer[] reachableNode = visitedVertex.toArray(new Integer[0]);
		Arrays.sort(reachableNode);
		
		return reachableNode;
	}

	/**
	 *Method to find minimum spanning tree of graph.
	 * @return List of edges which are in minimum spanning tree.
	 */
	@Override
	public List<Edge> minimumSpanningTree() 
	{
		List<Edge> minimumSpanningTreeEdges = new ArrayList<Edge>();
		Collections.sort(this.edgeList, Edge.sortByWeight);
		HashMap<Integer, Integer> parentVertices = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < this.numberOfVertices; i++) 
		{
			parentVertices.put(i, i);
		}
		
		int index = 0;
		
		for(Edge edge : this.getEdgeList()) 
		{
			if(index > this.getNumberOfVertices() - 1)
			{
				break;
			}
			else if(isCycle(parentVertices, edge.getVertex1(), edge.getVertex2()) == false) 
			{
				minimumSpanningTreeEdges.add(edge);
			}
		}
		
		return minimumSpanningTreeEdges;
	}
	
	/**
	 *Method to find shortest distance between 2 vertex of graph
	 * @param source vertex
	 * @param destination vertex.
	 * @return distance of shortest path.
	 */
	public int shortestPath(int source, int destination) 
	{
		int dist[] = this.dijkstra(source);
		return dist[destination];
	}
	
	/**
	 *Method for depth first traversal of graph.
	 * @param source vertex
	 * @return visited vertex set.
	 */
	private Set<Integer> dfs(int source)
	{
		Stack<Integer> dfsStack = new Stack<Integer>();
		Set<Integer> visitedVertex = new HashSet<Integer>();
		dfsStack.push(source);
		
		while (dfsStack.isEmpty() == false) 
		{
			int vertex = dfsStack.pop();
			if(visitedVertex.contains(vertex)) 
			{
				continue;
			}
			
			visitedVertex.add(vertex);
			for(Neighbour neighbour : this.vertices[vertex].getNeighbourList()) 
			{
				dfsStack.push(neighbour.getNeighbourVertex());
			}
		}
		
		return visitedVertex;
	}
	
	/**
	 * It is a method to check cycle.
	 * @param parentVertices parent vertices list
	 * @param v1 vertex one
	 * @param v2 vertex second
	 * @return boolean value
	 */
	private boolean isCycle(HashMap<Integer, Integer> parentVertices,int v1,int v2)
	{
		int parent1 = parent(parentVertices,v1);
		int parent2 = parent(parentVertices,v2);
		if(parent1 == parent2)
		{
			return true;
		}
		
		parentVertices.put(parent1, parent2);
		return false;
	}
	
	/**
	 * It is a method to find parent of vertex.
	 * @param parentVertices list of parent vertices
	 * @param vertex vertex whose parent to be find.
	 * @return parent vertex.
	 */
	private int parent(HashMap<Integer, Integer> parentVertices,int vertex) 
	{
		
		while(parentVertices.get(vertex) != vertex)
		{
			vertex = parentVertices.get(vertex);
		}
		return vertex;
	}

	/**
	 *Method to implement dijkstra algorithm to find shortest path.
	 * @param source 
	 * @return distance of all nodes from source vertex. 
	 */
	private int[] dijkstra(int source) 
	{
		int dist[] = new int[this.getNumberOfVertices()];
		for(int i=0; i < this.getNumberOfVertices(); i++) 
		{
			dist[i] = Integer.MAX_VALUE;
		}
		
		Set<Integer> visited = new HashSet<Integer>();
		dist[source] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(this.getNumberOfVertices(), Pair.sortPairByWeight);
		pq.add(new Pair(0, source));
		
		while(!pq.isEmpty())
		{
			Pair pair = pq.peek();
			pq.remove();
			
			if(visited.contains(pair.getVertex())) 
			{
				continue;
			}
			
			visited.add(pair.getVertex());
			
			for(Neighbour neighbour : this.vertices[pair.getVertex()].getNeighbourList())
			{
				if(dist[neighbour.getNeighbourVertex()] > dist[pair.getVertex()] + neighbour.getEdgeWeight())
				{
					dist[neighbour.getNeighbourVertex()] = dist[pair.getVertex()] + neighbour.getEdgeWeight();
					pq.add(new Pair(dist[neighbour.getNeighbourVertex()], neighbour.getNeighbourVertex()));
				}
			}
		}
		
		return dist;
	}	
}