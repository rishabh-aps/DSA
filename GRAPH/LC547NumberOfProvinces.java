/*
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * Example 1:
 * 
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * 
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

package GRAPH;

import java.util.ArrayList;

/**
 * LC547NumberOfProvinces
 */
public class LC547NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {

    // Converting adjaceny matrix into adjaceny list
    int V = isConnected.length;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (isConnected[i][j] == 1 && j != i) {
          adj.get(i).add(j);
          adj.get(j).add(i);
        }
      }
    }

    boolean[] visited = new boolean[V];
    int provinceCount = 0;
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        dfs(i, visited, adj);
        provinceCount++;
      }
    }
    return provinceCount;

  }

  public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    if (visited[node] == true) {
      return;
    }
    visited[node] = true;
    for (Integer it : adj.get(node)) {
      if (visited[it] == false) {
        dfs(it, visited, adj);
      }
    }
  }
}

/*
 * Time Complexity:
 * Adjacency Matrix to List Conversion:
 * 
 * Converting the V x V adjacency matrix into an adjacency list takes O(V²).
 * DFS Traversal:
 * 
 * DFS visits every vertex once and explores all edges, which takes O(V + E). In
 * a dense graph, E can be O(V²).
 * Overall Time Complexity: O(V²) because V² dominates.
 * 
 * Space Complexity:
 * Adjacency List: Takes O(V + E), which is O(V²) in the worst case.
 * Visited Array: Takes O(V).
 * Recursion Stack: Takes O(V) in the worst case.
 * Overall Space Complexity: O(V²).
 */