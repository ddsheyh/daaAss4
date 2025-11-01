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
        Graph transposed = transpose(graph);

        Arrays.fill(visited, false);
        List<List<Integer>> components = new ArrayList<>();

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(transposed, node, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private static void dfs1(Graph graph, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph.adj.get(node)) {
            if (!visited[neighbor]) {
                dfs1(graph, neighbor, visited, stack);
            }
        }
        stack.push(node);
    }
    private static void dfs2(Graph graph, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.adj.get(node)) {
            if (!visited[neighbor]) {
                dfs2(graph, neighbor, visited, component);
            }
        }
    }
    private static Graph transpose(Graph graph) {
        Graph transposed = new Graph(graph.n);
        for (int u = 0; u< graph.n; u++) {
            for (int v : graph.adj.get(u)) {
                transposed.addEdge(v, u, graph.weights.get(u +", " +v));
            }
        }
        return transposed;
    }
}
