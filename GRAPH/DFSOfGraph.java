/*
 * You are given a connected undirected graph. Perform a Depth First Traversal
 * of the graph.
 * Note: Use the recursive approach to find the DFS traversal of the graph
 * starting from the 0th vertex from left to right according to the graph.
 * 
 * 
 * Example 1:
 * 
 * Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
 * 
 * Output: 0 2 4 3 1
 * Explanation:
 * 0 is connected to 2, 3, 1.
 * 1 is connected to 0.
 * 2 is connected to 0 and 4.
 * 3 is connected to 0.
 * 4 is connected to 2.
 * so starting from 0, it will go to 2 then 4,
 * and then 3 and 1.
 * Thus dfs will be 0 2 4 3 1.
 * Example 2:
 * 
 * Input: V = 4, adj = [[1,3], [2,0], [1], [0]]
 * 
 * Output: 0 1 2 3
 * Explanation:
 * 0 is connected to 1 , 3.
 * 1 is connected to 0, 2.
 * 2 is connected to 1.
 * 3 is connected to 0.
 * so starting from 0, it will go to 1 then 2
 * then back to 0 then 0 to 3
 * thus dfs will be 0 1 2 3.
 * 
 * Expected Time Complexity: O(V + E)
 * Expected Auxiliary Space: O(V)
 * 
 * 
 * Constraints:
 * 1 ≤ V, E ≤ 10^4
 */

package GRAPH;

import java.util.ArrayList;

/**
 * DFSOfGraph
 */
public class DFSOfGraph {

  public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
    if (visited[node] == true) {
      return;
    }
    visited[node] = true;
    list.add(node);
    for (Integer it : adj.get(node)) {
      if (visited[it] == false) {
        dfs(it, visited, adj, list);
      }
    }
  }

  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    boolean[] visited = new boolean[V];
    ArrayList<Integer> list = new ArrayList<>();
    dfs(0, visited, adj, list);
    return list;
  }
}

/*
 * Time Complexity:
 * Initialization of visited[]:
 * 
 * You initialize a boolean array visited[] of size V (the number of vertices),
 * which takes O(V) time.
 * DFS Traversal:
 * 
 * DFS visits every vertex once and processes each vertex’s adjacency list
 * (edges) exactly once.
 * For each vertex, the algorithm checks all its neighbors (adjacent vertices).
 * If a vertex hasn’t been visited, it recurses on that vertex. This is
 * equivalent to exploring all edges connected to each vertex once.
 * For V vertices, the DFS explores each edge connected to them. This results in
 * processing E edges in total, where E is the number of edges in the graph.
 * Thus, the DFS function’s time complexity can be understood as:
 * 
 * O(V) for visiting all vertices.
 * O(E) for exploring all edges.
 * The overall time complexity is O(V + E).
 * 
 * Space Complexity:
 * Visited Array:
 * 
 * The boolean array visited[] is of size V (number of vertices), taking O(V)
 * space.
 * Recursion Stack:
 * 
 * DFS is implemented recursively, meaning that for each recursive call, the
 * function adds a new stack frame to the call stack.
 * In the worst case (a path-like graph), the recursion depth can go as deep as
 * V. Therefore, the recursion stack could take O(V) space in the worst case.
 * Adjacency List:
 * 
 * The adjacency list representation of the graph requires space to store the
 * graph structure.
 * The space required to store the adjacency list is proportional to the number
 * of vertices and edges, which is O(V + E).
 * Result List:
 * 
 * The list list used to store the DFS traversal of the graph also takes O(V)
 * space because it stores all the vertices visited during the traversal.
 * Overall Space Complexity:
 * The overall space complexity is the sum of:
 * 
 * O(V) for the visited[] array.
 * O(V) for the recursion stack in the worst case.
 * O(V + E) for storing the adjacency list.
 * Thus, the total space complexity is O(V + E).
 * 
 * Summary for Interviews:
 * Time Complexity: O(V + E) — for visiting all vertices and processing all
 * edges.
 * Space Complexity: O(V + E) — for the visited[] array, recursion stack,
 * adjacency list, and the result list.
 */