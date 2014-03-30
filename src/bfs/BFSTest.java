package bfs;
/*
 * @author Namik Karovic
 * BFSTest tests the BFS class
 */

public class BFSTest {
	public static void main(String args[]) {
		//test is an instance of BFS with maxNodes=8
		BFS test=new BFS(8);
		//add 8 nodes
		test.addNode('a');//0
		test.addNode('b');//1
		test.addNode('c');//2
		test.addNode('d');//3
		test.addNode('e');//4
		test.addNode('f');//5
		test.addNode('g');//6
		test.addNode('h');//7
		//add edges
		test.addEdge(0, 1);//ab
		test.addEdge(0, 2);//ac
		test.addEdge(0, 3);//ad
		test.addEdge(2, 1);//cb
		test.addEdge(4, 2);//ec
		test.addEdge(3, 4);//de
		test.addEdge(6, 4);//ge
		test.addEdge(5, 6);//gf
		test.addEdge(4, 7);//eh
		//run the algorithm
		test.bfs(5);//node 5=f
		System.out.println();
		//get the distance of node 3=d
		System.out.println(test.getDistance(3));
	}
}
