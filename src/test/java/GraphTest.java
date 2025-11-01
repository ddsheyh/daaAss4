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
        assertTrue(components.size() >= 2);
    }

    @Test
    public void testTopologicalSort() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);

        List<Integer> order = TopologicalSort.topologicalSort(graph);
        assertEquals(4, order.size());
        assertTrue(order.contains(0));
        assertTrue(order.contains(1));
        assertTrue(order.contains(2));
        assertTrue(order.contains(3));
    }

    @Test
    public void testShortestPath() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(0, 2, 10); // Длинный путь

        int[] dist = DAGShortestPath.shortestPath(graph, 0);

        assertEquals(0, dist[0]); // Расстояние до себя
        assertEquals(2, dist[1]); // 0→1
        assertTrue(dist[2] == 5); // 0→1→2
    }
}