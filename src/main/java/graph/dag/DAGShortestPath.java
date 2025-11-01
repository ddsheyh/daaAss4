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

        List<Integer> topoOrder = TopologicalSort.topologicalSort(graph);
        for (int u : topoOrder) {
            if (dist[u] != Integer.MAX_VALUE) {
                for (int v : graph.adj.get(u)) {
                    int weight = graph.weights.get(u + ", "+v);
                    if (dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }
        return dist;
    }
    public static int[] longestPath(Graph graph, int source) {
        Graph negatedGraph = negateWeights(graph);
        int[] dist = shortestPath(negatedGraph, source);

        for (int i = 0; i<dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                dist[i] = -dist[i];
            }
        }
        return dist;
    }
    private static Graph negateWeights(Graph graph) {
        Graph negated = new Graph(graph.n);
        for (int u = 0; u < graph.n; u++) {
            for (int v : graph.adj.get(u)) {
                int originalWeight = graph.weights.get(u +", " +v);
                negated.addEdge(u, v, -originalWeight);
            }
        }
        return negated;
    }
}
