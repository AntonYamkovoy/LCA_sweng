import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DAGTesting {

	@Test
	public void DAG_illegal_test() {
		DAG graph;
		Exception exception = assertThrows(Exception.class, () -> new DAG(-1));
		assertEquals("vertices < 0", exception.getMessage());
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
	
	@Test void test_addEdge() {
		DAG graph = new DAG(14);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 6);
		graph.addEdge(3, 5);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		
		graph.addEdge(-1, 1);
		graph.addEdge(-2, 20); // errors due to checking in function
		
	}
	
	@Test
	void cycleTest_DAG() {
		
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 1);
		
		graph.findLoop(1);
		
		assertTrue(graph.isCyclic);
		
	}

	@Test
	void cycleTest_DAG_error() {
		
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 1);
		
		graph.findLoop(0);
		
		//assertTrue(graph.isCyclic);
		
	}
	

	@Test
	void cycleTest_DAG_acyclic() {
		
		DAG graph = new DAG(14);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 6);
		graph.addEdge(3, 5);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		
		graph.findLoop(1);
		
		//assertTrue(graph.isCyclic);
		
	}
	
	@Test void reverse_DAG_test() {
		DAG graph = new DAG(10);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 6);
		graph.addEdge(3, 5);
		
		graph.reverse();
	
		
	}
	
	@Test void reverse_basecase_test() {
		DAG graph = new DAG(1);
		graph.reverse();
	
		
	}
	
	
	@Test void DAG_LCA_simple_1() {
	DAG graph = new DAG(16);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		int result_1 = graph.dagLCA(1, 5, 8);
		assertEquals(2,result_1);

		int result_2 = graph.dagLCA(1, 4, 2);
		assertEquals(1,result_2);
		
		int result_3 = graph.dagLCA(1, 4, 7);
		assertEquals(1,result_3);
		
		int result_4 = graph.dagLCA(1, 5, 2);
		assertEquals(2,result_4);
		
	}
	
	
	@Test void DAG_LCA_self_node() {
		DAG graph = new DAG(16);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		int result = graph.dagLCA(1, 5, 2);
		assertEquals(2,result);
		
	}
	
	
	@Test void DAG_LCA_loop() {
		DAG graph = new DAG(16);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		int result = graph.dagLCA(1, 5, 2);
		assertEquals(-1,result); // -1 error return expected as there is a cycle inside the graph
		
	}
	
	
	@Test void DAG_LCA_no_loops_no_vertex() {
		DAG graph = new DAG(16);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		int result = graph.dagLCA(1, 5, 9);
		assertEquals(-1,result);
		
	}
	
	@Test void DAG_LCA_negative() {
		DAG graph = new DAG(4);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		
		int result = graph.dagLCA(1, 2, -5);
		assertEquals(-1,result);
		
	}
	
	@Test void DAG_LCA_empty_dag() {
		DAG graph = new DAG(16);
		
		
		int result = graph.dagLCA(1, 5, 9);
		assertEquals(-1,result);
		
		assertEquals(-1,graph.dagLCA(1,2, 0));
		assertEquals(-1,graph.dagLCA(1,-1, -1));
		
		
	}
	
	@Test void DAG_LCA_Multiple_null() {
		DAG graph = new DAG(16);
		int[] targets = {1,2,3};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(-1,result);
		
	}
	
	@Test void DAG_LCA_Multiple_base() {
		DAG graph = new DAG(4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		
		int[] targets = {2,3};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(1,result);
		
	}
	
	
	@Test void DAG_LCA_Multiple_normal_1() {
		DAG graph = new DAG(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		
		
		int[] targets = {5,3,4};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(3,result);
		
	}
	
	
	@Test void DAG_LCA_Multiple_loop() {
		DAG graph = new DAG(16);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		
		int[] targets = {7,8,1};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(-1,result);
		
	}
	
	@Test void DAG_LCA_Multiple_many_but_some_valid_inputs() {
		DAG graph = new DAG(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);

		
		int[] targets = {1,2,3,4,5,6};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(1,result);
		
		int[] targets2 = {6,5,4,3,2,1};
		int result2= graph.MultipleDagLCA(1,targets);
		assertEquals(1,result2);
		
		// function will ignore inputs that aren't in the graph if there are too many
		
	}
	
	
	@Test void DAG_LCA_Multiple_invalid_targets() {
		DAG graph = new DAG(16);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		
		
		int[] targets = {10,12,13};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(-1,result);
		
	}
	
	
	@Test void DAG_LCA_Multiple_invalid_root() {
		DAG graph = new DAG(6);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		
		
		
		int[] targets = {2,3};
		int result = graph.MultipleDagLCA(4,targets);
		assertEquals(-1,result);
		
		int result2 = graph.MultipleDagLCA(3,targets);
		assertEquals(-1,result2);
		
	}
	
	@Test void DAG_LCA_Multiple_straight_line() {
		DAG graph = new DAG(14);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		
		
		
		int[] targets = {8,7};
		int result = graph.MultipleDagLCA(8,targets);
		assertEquals(-1,result);
		
	}
	
	
	@Test void DAG_LCA_Multiple_s1() {
		DAG graph = new DAG(14);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(2,4);
		graph.addEdge(2,5);
		graph.addEdge(3,6);
		graph.addEdge(3,7);
		
		
		
		int[] targets = {6,7,4,5};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(1,result);

	}
	
	
	@Test void DAG_LCA_Multiple_s2() {
		DAG graph = new DAG(14);
		
		graph.addEdge(1, 3);
		graph.addEdge(1,4);
		graph.addEdge(1,5);
		graph.addEdge(5,2);
		
		
		
		int[] targets = {2,3};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(1,result);

	}
	
	@Test void DAG_LCA_Multiple_s2_loop() {
		DAG graph = new DAG(14);
		
		graph.addEdge(1, 3);
		graph.addEdge(1,4);
		graph.addEdge(1,5);
		graph.addEdge(5,1);
		
		
		
		int[] targets = {2,3};
		int result = graph.MultipleDagLCA(1,targets);
		assertEquals(-1,result);

	}
	

}
