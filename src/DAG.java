import java.util.ArrayList;

public class DAG {

	
	int vertices;
	int edges;
	ArrayList<Integer> adjacencyList;
	int[] outdegree;
	int[] indegree;
	
	boolean[] visitedVert;
	boolean[] stack;
	boolean isCyclic;
	
	public DAG(int vertices) {
		
		
	}
	
	public void addEdge(int v, int w) {
		
		
	}
	
	int checkVertex(int v) {
		
		return 0;
	}
	
	int indegree(int v) {
		
		return 0;
	}
	
	int outdegree(int v) {
		
		return 0;
	}
	
	public void findLoops(int v) {
		
		
	}
	
	public DAG reverseDAG() {
		DAG reverse = new DAG(vertices);
		
		return reverse;
	}
	
	
	
}
