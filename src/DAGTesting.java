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
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		
		assertEquals(1, graph.indegree(4));
		assertEquals(2, graph.outdegree(4));
		assertEquals(5, graph.edges);
		assertEquals(10, graph.vertices);

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

}
