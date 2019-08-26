package graphQuestion;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	GraphImplimentation graphObj;
	List<Integer> listOfReachable;
	List<Edge> list;

	@Before
	public void iniTialize() {
		graphObj = new GraphImplimentation(4);
	}

	int[] listToArrayForTest(List<Edge> list) {
		int array[] = new int[list.size()];
		int i = 0;
		for (Edge edgeList : list) {
			array[i] = edgeList.getWeight();
			i++;
		}
		System.out.println("--"+Arrays.toString(array));
		return array;
	}

	@Test
	public void testisConnected() {

		graphObj.addEdge(0, 1, 3);
		graphObj.addEdge(0, 2, 5);
		graphObj.addEdge(0, 3, 2);
		graphObj.addEdge(1, 2, 9);
		graphObj.addEdge(2, 3, 9);
		assertEquals(true, graphObj.isConnected());
	}

	@Test
	public void testisConnected1() {

		graphObj.addEdge(0, 1, 2);
		graphObj.addEdge(1, 2, 5);
		graphObj.addEdge(3, 3, 6);
		graphObj.addEdge(2, 2, 9);
		graphObj.addEdge(1, 1, 4);
		assertEquals(false, graphObj.isConnected());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReachable() {

		graphObj.addEdge(0, 1, 4);
		graphObj.addEdge(0, 2, 5);
		graphObj.addEdge(0, 3, 6);
		graphObj.addEdge(1, 2, 9);
		graphObj.addEdge(2, 3, 4);
		Integer []listOfReachable = graphObj.reachable(0);
		assertEquals(new Integer[] {0, 1, 2,3}, (listOfReachable));
	}

	@Test
	public void testminimumSpanningTree() {

		graphObj.addEdge(0, 1, 4);
		graphObj.addEdge(0, 2, 3);
		graphObj.addEdge(1, 2, 1);
		graphObj.addEdge(1, 3, 2);
		graphObj.addEdge(2, 3, 4);
		list = graphObj.minimumSpanningTree();
		assertArrayEquals(new int[] { 1,2,3}, this.listToArrayForTest(list));
	}

	
	@Test
	public void shortestPathTest() {
		graphObj.addEdge(0, 1, 4);
		graphObj.addEdge(0, 2, 5);
		graphObj.addEdge(0, 3, 6);
		graphObj.addEdge(1, 2, 9);
		graphObj.addEdge(2, 3, 4);
		int shortestPathWeight = graphObj.shortestPath(0, 2);
		assertEquals(5, shortestPathWeight);
	}

	@Test
	public void shortestPathTest2() {

		graphObj.addEdge(0, 1, 4);
		graphObj.addEdge(0, 2, 3);
		graphObj.addEdge(1, 2, 1);
		graphObj.addEdge(1, 3, 2);
		graphObj.addEdge(2, 3, 4);
		int shortestPathWeight = graphObj.shortestPath(0, 2);
		assertEquals(3, shortestPathWeight);
	}
}