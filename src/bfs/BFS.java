package bfs;

/* 
 * @author Namik Karovic
 * BFS class implements the breadth first search
 */
import java.util.LinkedList;
import java.util.List;

public class BFS {
	int maxNodes = 10;// maximum number of nodes
	node nodeList[];// holds all the nodes
	int matrix[][];// adjacency matrix
	int nodeTotal;// total number of nodes
	List<node> queue;// queue implementation

	// default constructor
	public BFS() {
		nodeList = new node[this.maxNodes];
		matrix = new int[10][10];
		nodeTotal = 0;
		queue = new LinkedList<node>();
	}

	// custom number of nodes constructor
	public BFS(int customNodeNumber) {
		maxNodes = customNodeNumber;
		nodeList = new node[this.maxNodes];
		matrix = new int[maxNodes][maxNodes];
		nodeTotal = 0;
		queue = new LinkedList<node>();
	}

	// add a new node with its name as method parameter
	public void addNode(char Name) {
		nodeList[nodeTotal] = new node(Name);
		nodeTotal++;
	}

	// adds an edge in adjacency matrix at the given positions
	public void addEdge(int parent, int child) {
		matrix[parent][child] = 1;
		matrix[child][parent] = 1;
	}

	// prints the node name at the given position
	public void printNode(int n) {
		System.out.print(nodeList[n].name);
	}
	
	// returns the distance of the given node
	public int getDistance(int n){
		return nodeList[n].d;
	}

	// breadth first search algorithm
	// startIndex parameter is the position of the first node
	public void bfs(int startIndex) {
		// all nodes are set to be undiscovered through node constructor
		// all node distances are set to 0 through node constructor
		nodeList[startIndex].discovered = true;// discover the initial node
		printNode(startIndex);// print the initial node
		queue.add(nodeList[startIndex]);// add the first node to the queue
		int tempIndex = startIndex;// tempIndex stores the current node's
									// position

		// while loop for checking if queue is empty
		while (!queue.isEmpty()) {
			// alphaNode holds the next node in queue
			// retrieve and remove the next node
			node alphaNode = queue.remove(0);

			// for loop for getting next node's position
			// !ineffective approach, should be implemented in a better way
			// author had no time to make a better solution
			for (int c = 0; c < nodeList.length; c++) {
				if (nodeList[c].equals(alphaNode)) {
					tempIndex = c;// tempIndex is now the position of alphaNode
					break;
				}
			}

			int adjPosition;// adjPosition will hold positions of adjacent nodes
			// while loop checks if there are any adjacent nodes of alphaNode
			while ((adjPosition = getAdj(tempIndex)) != -1) {
				// betaNode stores adjacent nodes
				node adjNode = nodeList[adjPosition];
				adjNode.discovered = true;// discover the adj node
				printNode(adjPosition);// print the adj node
				adjNode.d = alphaNode.d + 1;// increase the adj node's distance
				adjNode.parent = alphaNode;// update the adj node's parent
				queue.add(adjNode);// add the adj node to queue
			}// end while
		}// end while

	}// end bfs

	// getAdj method for finding adjacent nodes
	// checks all connections of the input parentIndex
	// return adjacent node's position if there are undiscovered adj nodes
	// return -1 if there are no undiscovered adj nodes
	public int getAdj(int parentIndex) {
		for (int childIndex = 0; childIndex < nodeTotal; childIndex++) {
			if (matrix[parentIndex][childIndex] == 1
					&& nodeList[childIndex].discovered == false) {
				return childIndex;
			}
		}
		return -1;
	}

	// node custom class for holding node information
	class node {
		char name;// node name
		boolean discovered;// discovered or undiscovered
		int d;// distance
		node parent;// node's parent

		// defalut constructor
		public node(char Name) {
			name = Name;
			discovered = false;
			d = 0;
			parent = null;
		}

	}// end node class
}// end BFS class

