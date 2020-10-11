package graphs;

class DirectedGraph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private char sortedArray[];

	public DirectedGraph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;

		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}

		sortedArray = new char[MAX_VERTS];
	}

	public void addVertex(char label) {
		vertexList[nVerts++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++)
			adjMat[row][col] = adjMat[row + 1][col];
	}

	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++)
			adjMat[row][col] = adjMat[row][col + 1];
	}

	public void deleteVertex(int deleteVertex) {
		if (deleteVertex != nVerts - 1) {
			for (int i = deleteVertex; i < nVerts - 1; i++)
				vertexList[i] = vertexList[i + 1];

			for (int row = deleteVertex; row < nVerts - 1; row++)
				moveRowUp(row, nVerts);

			for (int col = deleteVertex; col < nVerts - 1; col++)
				moveColLeft(col, nVerts - 1);
		}
		nVerts--;
	}

	public int noSuccessors() {
		boolean isEdge;

		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				if (adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge)
				return row;
		}

		return -1;
	}

	public void topologicalSort() {
		int numberOfVertices = nVerts;

		while (nVerts > 0) {
			int currentVertex = noSuccessors();
			if (currentVertex == -1) {
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			sortedArray[nVerts - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex);
		}

		System.out.print("Topologically sorted order: ");
		for (int i = 0; i < numberOfVertices; i++) {
			System.out.print(sortedArray[i]);
		}
		System.out.println();
	}

}

public class TopologicalSort {

	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph();

		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('H');
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);

		graph.topologicalSort();
	}

}
