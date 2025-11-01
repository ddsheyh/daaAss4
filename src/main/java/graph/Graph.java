package graph;

import java.util.*;

public class Graph {
    public int n;
    public List<List<Integer>> adj;
    public Map<String, Integer> weights;

    public Graph(int n) {
        this.n = n;
        this.adj = new ArrayList<>();
        this.weights = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v, int w) {
        adj.get(u).add(v);
        weights.put(u + ", " +v,w);
    }
}
