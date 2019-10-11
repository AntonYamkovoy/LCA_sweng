import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

class DAGTesting {

	@Test
	public void DAG_illegal_test() {
	  
	    assertThrows(IllegalArgumentException.class, () -> {
	    DAG graph = new DAG(-1);
	});
	}
	
	
	
	@Test
	void DAG_init_test_2() {
		DAG graph = new DAG(1);
		
		
	}
	
	@Test
	void DAG_init_test_3() {
		DAG graph = new DAG(8);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
	
		
		assertEquals(2, graph.indegree(4));
		assertEquals(0, graph.outdegree(4));
		assertEquals(4, graph.edges);
		assertEquals(8, graph.vertices);

	}
	@Test
	void DAG_init_test_4() {
		DAG graph = new DAG(14);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 6);
		graph.addEdge(3, 5);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		
		assertEquals(2, graph.indegree(7));
		assertEquals(3, graph.outdegree(1));
		assertEquals(7, graph.edges);
		assertEquals(14, graph.vertices);

	}
	
	@Test 
	void test_Indegree() {
		
		DAG graph = new DAG(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		assertEquals(1,graph.indegree(2)); // valid vertex
		assertEquals(-1,graph.indegree(9)); //invalid vertex
		
	}
	
	@Test 
	void test_outdegree() {
		
		DAG graph = new DAG(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		assertEquals(1,graph.outdegree(2)); // valid vertex
		assertEquals(-1,graph.outdegree(9)); //invalid vertex
		
	}


}
