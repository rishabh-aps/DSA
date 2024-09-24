/*
 * Given a directed graph. The task is to do Breadth First Traversal of this
 * graph starting from 0.
 * Note: One can move from node u to node v only if there's an edge from u to v.
 * Find the BFS traversal of the graph starting from the 0th vertex, from left
 * to right according to the input graph. Also, you should only take nodes
 * directly or indirectly connected from Node 0 in consideration.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * V = 5, E = 4
 * adj = {{1,2,3},{},{4},{},{}}
 * 
 * 
 * Output:
 * 0 1 2 3 4
 * Explanation:
 * 0 is connected to 1 , 2 , 3.
 * 2 is connected to 4.
 * so starting from 0, it will go to 1 then 2
 * then 3. After this 2 to 4, thus bfs will be
 * 0 1 2 3 4.
 * Example 2:
 * 
 * Input:
 * V = 3, E = 2
 * adj = {{1,2},{},{}}
 * 
 * Output:
 * 0 1 2
 * Explanation:
 * 0 is connected to 1 , 2.
 * so starting from 0, it will go to 1 then 2,
 * thus bfs will be 0 1 2.
 */

package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * BFSOfGraph
 */
public class BFSOfGraph {

  public void bfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
    Queue<Integer> queue = new ArrayDeque<>();
    visited[node] = true;
    queue.add(node);
    while (!queue.isEmpty()) {
      node = queue.poll();
      list.add(node);
      for (Integer it : adj.get(node)) {
        if (visited[it] == false) {
          visited[it] = true;
          queue.add(it);
        }
      }
    }
  }

  // Function to return Breadth First Traversal of given graph.
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    boolean[] visited = new boolean[V];
    ArrayList<Integer> list = new ArrayList<>();
    bfs(0, visited, adj, list);
    return list;
  }
}

/*
 * Time Complexity:
 * Initialization of visited[]: Initializing the visited[] array takes O(V)
 * time, where V is the number of vertices. This is because you need to mark all
 * nodes as unvisited initially.
 * 
 * Traversal of the graph: The BFS function uses a queue to explore each vertex
 * and its adjacent vertices:
 * 
 * Each vertex is added to the queue exactly once when it’s discovered (since it
 * gets marked as visited immediately after being added).
 * For each vertex, all its adjacent vertices are explored, meaning each edge
 * (connecting two vertices) is processed exactly once.
 * Thus, the loop inside BFS runs V times for the vertices, and each vertex
 * explores all its adjacent vertices, leading to O(E) for processing all the
 * edges.
 * 
 * Overall Time Complexity: Since BFS explores all vertices and edges, the
 * overall time complexity is O(V + E), where V is the number of vertices and E
 * is the number of edges.
 * 
 * Space Complexity:
 * visited[] array: This array stores whether each vertex has been visited or
 * not, and it takes O(V) space.
 * 
 * Queue for BFS: In the worst case, the queue could store all the vertices at
 * once, which would also take O(V) space.
 * 
 * Adjacency list (adj): The adjacency list represents the graph, and its space
 * requirement depends on the number of vertices and edges. The space needed for
 * the adjacency list is O(V + E) because each vertex stores its list of
 * adjacent vertices.
 * 
 * List to store BFS result: The result list list stores all the vertices
 * visited during the BFS traversal, which takes O(V) space.
 * 
 * Overall Space Complexity:
 * The space complexity of the algorithm is dominated by the space needed for
 * the visited[] array, the queue, the adjacency list, and the result list.
 * Therefore, the overall space complexity is O(V + E).
 * 
 * In summary:
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */