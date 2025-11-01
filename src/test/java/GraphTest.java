import graph.Graph;
import graph.dag.DAGShortestPath;
import graph.scc.SCC;
import graph.topological.TopologicalSort;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class GraphTest {
    @Test
    public void testSCC() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 0, 1);
        graph.addEdge(3, 4, 1);

        List<List<Integer>> components = SCC.findSCC(graph);
        assertEquals(3, components.size());
    }

    @Test
    public void testTopologicalSort() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);

        List<Integer> order = TopologicalSort.topologicalSort(graph);
        assertEquals(4, order.size());
        assertTrue(order.indexOf(0) < order.indexOf(1));
    }

    @Test
    public void testShortestPath() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(0, 2, 6);

        int[] dist = DAGShortestPath.shortestPath(graph, 0);
        assertEquals(5, dist[2]);
    }
}