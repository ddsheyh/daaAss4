import graph.Graph;
import graph.scc.SCC;
import graph.dag.DAGShortestPath;
import graph.topological.TopologicalSort;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(new java.io.File("tasks.json"), Map.class);

        int n = (Integer) data.get("n");
        List<Map<String, Object>> edges = (List<Map<String, Object>>) data.get("edges");
        int source = (Integer) data.get("source");

        Graph graph = new Graph(n);
        for (Map<String, Object> edge : edges) {
            int u = (Integer) edge.get("u");
            int v = (Integer) edge.get("v");
            int w = (Integer) edge.get("w");
            graph.addEdge(u, v, w);
        }

        System.out.println("  SCC  ");
        List<List<Integer>> components = SCC.findSCC(graph);
        System.out.println("Components: " + components);
        System.out.println("  Topological Sort  ");
        List<Integer> topoOrder = TopologicalSort.topologicalSort(graph);
        System.out.println("Topological order: " + topoOrder);
        System.out.println("  Shortest path from" +source);
        int[] shortest = DAGShortestPath.shortestPath(graph, source);
        System.out.println("Shortest: " + Arrays.toString(shortest));
        System.out.println("  Longest path from" + source);
        int[] longest = DAGShortestPath.longestPath(graph, source);
        System.out.println("Longest: " + Arrays.toString(longest));
    }
}
