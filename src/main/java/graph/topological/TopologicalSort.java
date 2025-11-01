package graph.topological;

import graph.Graph;
import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(Graph graph) {
        int n = graph.n;
        int[] indegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v :graph.adj.get(u)) {
                indegree[u]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : graph.adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return result;
    }
}
