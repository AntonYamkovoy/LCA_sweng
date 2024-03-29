import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {

	//adjacencyLists data structure
	int vertices;
	int edges;
	ArrayList<Integer>[] adjLists;
	int[] outdegree;
	int[] indegree;
	
	boolean[] visitedVert;
	boolean[] stack;
	boolean isCyclic;
	
	public DAG(int vertices) {
		if(vertices > 0) {
			
			this.vertices = vertices;
			this.edges = 0;
			
			adjLists =(ArrayList<Integer>[]) new ArrayList[vertices];
			
			indegree = new int[vertices];
			visitedVert = new boolean[vertices];
			stack = new boolean[vertices];
			
			for(int i=0; i < vertices; i++) 
				adjLists[i] = new ArrayList<Integer>();	
		}
		else {
			throw new IllegalArgumentException("vertices < 0");
		}
		
	}
	//checking for validity of vertices added/used
	boolean checkVertex(int v) {
		if(v < 0 || v >= vertices) return false;
		return true;	
	}
	//add edge taking in 2 edges
	public void addEdge(int v, int w) {
		if(checkVertex(v) && checkVertex(w)) {
			adjLists[v].add(w);
			indegree[w]++;
			edges++;
		}
		else {
			System.out.println("vertex number out of range: Enter a number between 0 and "+(vertices-1));
			
		}
		
	}

	//returns a valid value for indegree of a vertex
	int indegree(int v) {
		if(checkVertex(v)) {
			return indegree[v];
		}
		return -1;
	}
	//returns a valid value for indegree of a vertex
	int outdegree(int v) {
		if(checkVertex(v)) {
			return adjLists[v].size();
		}
		return -1;
	}
	
	//finds loop in a given dag for input vertex
	public void findLoop(int v) {
		visitedVert[v] = true;
		stack[v] = true;
		for(int w : adjLists[v]) {
			if(!visitedVert[w]) {
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
		for(int v = 0; v <vertices; v++) for(int w : adjLists[v]) reverse.addEdge(w, v);	
		return reverse;
	}
	
	
	public ArrayList<Integer> BFS(int source)
	{
		ArrayList<Integer> ordering = new ArrayList<Integer>();
		boolean visited[] = new boolean[vertices]; 
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		visited[source] = true;
		q.add(source);
		while(q.size() != 0)
		{
			source = q.poll(); 
			ordering.add(source);
			Iterator<Integer> i = adjLists[source].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
		}
		return ordering;
	}
	
	
	public int dagLCA(int root, int v, int w) {
		if(edges ==0) {
			return -1;
		}
		findLoop(root);
		if(isCyclic) {
			return -1;
		}
		if(root < 0) {
			return -1;
		}
		if(root > this.edges) {
			return -1;
		}
		findLoop(root);
		if(isCyclic || !checkVertex(v) || !checkVertex(w) || edges ==0) {
			return -1;
		}
		DAG reverse = reverse();
		ArrayList<Integer> path_0 = reverse.BFS(v);
		ArrayList<Integer> path_1 = reverse.BFS(w);
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		boolean resultFound = false;
		for(int i=0; i < path_0.size(); i++) {
			for(int j=0; j < path_1.size(); j++) {
				if(path_0.get(i) == path_1.get(j)) {
					intersection.add(path_0.get(i));
					resultFound = true;
				}
			}
		}
		if(resultFound) return intersection.get(0);
		else return -1;
		
		
		
		
	}
	
	public int MultipleDagLCA(int root, int[] targets) {
		if(root < 0) {
			return -1;
		}
		if(targets.length < 2) {
			return -1;
		}
		if(targets.length == 2) {
			return dagLCA(root,targets[0],targets[1]);
		}
		int result =0;
		int temp = dagLCA(root,targets[0],targets[1]);
		for(int i=2; i < targets.length; i++) {
			 result = dagLCA(root,temp,targets[i]);
			 if(result == root) {
				 return root;
			 }
			
		}
		return result;
		
	}
	
	
	
	
}
