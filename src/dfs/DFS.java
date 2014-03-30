package dfs;

/* 
 * @author Namik Karovic
 * DFS class implements the depth first search
 */
import java.util.LinkedList;
import java.util.List;

public class DFS {
	int maxNodes = 10;// maximum number of nodes
	node nodeList[];// holds all the nodes
	int matrix[][];// adjacency matrix
	int nodeTotal;// total number of nodes
	List<node> queue;// queue implementation
	int timer;// node timer

	// default constructor
	public DFS() {
		nodeList = new node[this.maxNodes];
		matrix = new int[10][10];
		nodeTotal = 0;
		queue = new LinkedList<node>();
		timer = 0;
	}

	// custom number of nodes constructor
	public DFS(int customNodeNumber) {
		maxNodes = customNodeNumber;
		nodeList = new node[this.maxNodes];
		matrix = new int[maxNodes][maxNodes];
		nodeTotal = 0;
		queue = new LinkedList<node>();
		timer = 0;
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

	// returns the discovery time of the given node
	public int getDTime(int n) {
		return nodeList[n].dTime;
	}

	// returns the end time of the given node
	public int getETime(int n) {
		return nodeList[n].eTime;
	}

	// breadth first search algorithm
	// startIndex parameter is the position of the first node
	public void dfs(int startIndex) {

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

			timer++;
			int adjPosition;// adjPosition will hold positions of adjacent nodes
			// while loop checks if there are any adjacent nodes of alphaNode
			while ((adjPosition = getAdj(tempIndex)) != -1) {
				// betaNode stores adjacent nodes
				node adjNode = nodeList[adjPosition];
				adjNode.discovered = true;// discover the adj node
				adjNode.dTime = timer;// increase the adj node's distance
				adjNode.parent = alphaNode;// update the adj node's parent
				dfs(adjPosition);// continue checking the adjacent node
				adjNode.eTime = timer + 1;
			}// end while
		}// end while

	}// end bfs

	// main method to be called when using DFS
	public void dfsTest(int source) {
		for (int i = source; i < nodeList.length; i++) {
			if (nodeList[i].discovered == false)
				dfs(i);
		}
	}

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
		int dTime;// discovery time
		node parent;// node's parent
		int eTime;// end time

		// defalut constructor
		public node(char Name) {
			name = Name;
			discovered = false;
			dTime = 0;
			eTime = 0;
			parent = null;
		}

	}// end node class
}// end BFS class

