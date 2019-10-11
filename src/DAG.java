import java.util.ArrayList;

public class DAG {

	
	int vertices;
	int edges;
	ArrayList<Integer>[] adjacencyList;
	int[] outdegree;
	int[] indegree;
	
	boolean[] visitedVert;
	boolean[] stack;
	boolean isCyclic;
	
	public DAG(int vertices) {
		if(vertices > 0) {
			
			this.vertices = vertices;
			this.edges = 0;
			
			adjacencyList =(ArrayList<Integer>[]) new ArrayList[vertices];
			
			indegree = new int[vertices];
			visitedVert = new boolean[vertices];
			stack = new boolean[vertices];
			
			for(int i=0; i < vertices; i++) 
				adjacencyList[i] = new ArrayList<Integer>();	
		}
		
	}
	
	boolean checkVertex(int v) {
		if(v < 0 || v >= vertices) return false;
		return true;	
	}
	
	public void addEdge(int v, int w) {
		if(checkVertex(v) && checkVertex(w)) {
			adjacencyList[v].add(w);
			indegree[w]++;
			edges++;
		}
		else {
			System.out.println("vertex number out of range: Enter a number between 0 and "+(vertices-1));
			
		}
		
	}

	
	int indegree(int v) {
		if(checkVertex(v)) {
			return indegree[v];
		}
		return -1;
	}
	
	int outdegree(int v) {
		if(checkVertex(v)) {
			return adjacencyList[v].size();
		}
		return -1;
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adjacencyList[v];
	}
	
	public void findLoop(int v) {
		visitedVert[v] = true;
		stack[v] = true;
		
		for(int w : adj(v)) {
			if(visitedVert[w] = false) {
				findLoop(w);
			}
			else if(stack[w]) {
				isCyclic = true;
				return;
			}
			
			
		}
		stack[v] = false;
		
	}
	
	public DAG reverse()
	{
		DAG reverse = new DAG(vertices);
		for(int v = 0; v <vertices; v++)
		{
			for(int w : adj(v))
			{
				reverse.addEdge(w, v);
			}		
		}
		return reverse;
	}
	
	
}
