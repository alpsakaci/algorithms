package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {

	public char label;
	public boolean wasVisited;

	public Vertex(char label) {
		this.label = label;
		wasVisited = false;
	}

}

class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;

		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
	}

	public void addVertex(char label) {
		vertexList[nVerts++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
				return i;
		}

		return -1;
	}

	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);

		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());

			if (v == -1) {
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.add(0);
		int v2;

		while (!queue.isEmpty()) {
			int v1 = queue.poll();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.add(v2);
			}
		}

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}

	public void minSpanningTree() {
		Stack<Integer> stack = new Stack<Integer>();
		vertexList[0].wasVisited = true;
		stack.push(0);

		while (!stack.isEmpty()) {
			int currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);

			if (v == -1) {
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				stack.push(v);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		}

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}

}

public class GraphApp {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);

		System.out.print("DFS Visits: ");
		graph.dfs();
		System.out.println();
		System.out.print("BFS Visits: ");
		graph.bfs();
		System.out.println();
		
		System.out.print("Minimum spanning tree: ");
		graph.minSpanningTree();
		System.out.println();

	}

}
