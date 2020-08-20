package GraphStructure;
/*
       0          7
     /   \       /
    1 --- 3 --- 5
    |  /  |      \
    2 --- 4       6 --- 8

--------------------------
DFS(0)
    0 1 3 5 7 6 8 4 2
BFS(0)
    0 1 2 3 4 5 6 7 8
DFS(0) - Recursive
    0 1 2 4 3 5 6 8 7
--------------------------
DFS(3)
    3 5 7 6 8 4 2 1 0
BFS(3)
    3 1 2 4 5 0 6 7 8
DFS(3) - Recursive
    3 1 0 2 4 5 6 8 7
--------------------------
 */

public class Test {
    public static void main(String[] args){
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        g.dfsR();
    }
}
