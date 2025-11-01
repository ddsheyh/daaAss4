package graph.scc;

import graph.Graph;
import java.util.*;

public class SCC {
    public static List<List<Integer>> findSCC(Graph graph) {
        int n = graph.n;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(graph, i, visited, stack);
            }
        }
    }
}
