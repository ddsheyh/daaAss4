package graph.dag;

import graph.Graph;
import graph.topological.TopologicalSort;
import java.util.*;

public class DAGShortestPath {
    public static int[] shortestPath(Graph graph, int source) {
        int n = graph.n;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        try {
            List<Integer> topoOrder = TopologicalSort.topologicalSort(graph);

            for (int u : topoOrder) {
                if (dist[u] != Integer.MAX_VALUE) {
                    for (int v : graph.adj.get(u)) {
                        int weight = graph.weights.get(u + "," + v);
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Warning: " + e.getMessage());
            for (int u = 0; u < n; u++) {
                if (dist[u] != Integer.MAX_VALUE) {
                    for (int v : graph.adj.get(u)) {
                        int weight = graph.weights.get(u + ", "+v);
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                        }
                    }
                }
            }
        }
        return dist;
    }

    public static int[] longestPath(Graph graph, int source) {
        int n = graph.n;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[source] = 0;

        try {
            List<Integer> topoOrder = TopologicalSort.topologicalSort(graph);
            for (int u : topoOrder) {
                if (dist[u] != Integer.MIN_VALUE) {
                    for (int v : graph.adj.get(u)) {
                        int weight = graph.weights.get(u + ", " + v);
                        if (dist[u] + weight > dist[v]) {
                            dist[v] = dist[u] + weight;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Warning: " + e.getMessage());
            for (int u = 0; u < n; u++) {
                if (dist[u] != Integer.MIN_VALUE) {
                    for (int v : graph.adj.get(u)) {
                        int weight = graph.weights.get(u + ", "+ v);
                        if (dist[u] + weight > dist[v]) {
                            dist[v] = dist[u] + weight;
                        }
                    }
                }
            }
        }
        return dist;
    }
}