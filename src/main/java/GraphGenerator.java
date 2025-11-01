import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.io.*;

public class GraphGenerator {
    public static void main(String[] args) throws Exception {
        generateGraphs();
    }

    public static void generateGraphs() throws Exception {
        generateGraph("data/small1.json", 8, 12, true);
        generateGraph("data/small2.json", 10, 15, false);
        generateGraph("data/small3.json", 7, 10, true);

        generateGraph("data/medium1.json", 15, 25, true);
        generateGraph("data/medium2.json", 20, 35, false);
        generateGraph("data/medium3.json", 18, 30, true);

        generateGraph("data/large1.json", 30, 60, true);
        generateGraph("data/large2.json", 40, 80, false);
        generateGraph("data/large3.json", 50, 100, true);
    }

    public static void generateGraph(String filename, int n, int edges, boolean hasCycles) {
        Map<String, Object> graph = new HashMap<>();
        graph.put("n", n);
        graph.put("source", 0);
        graph.put("weight_model", "edge");

        List<Map<String, Object>> edgeList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < edges; i++) {
            int u = rand.nextInt(n);
            int v = rand.nextInt(n);
            int w = rand.nextInt(10) + 1;
            if (!hasCycles && u == v) {
                v = (v + 1) % n;
            }

            Map<String, Object> edge = new HashMap<>();
            edge.put("u", u);
            edge.put("v", v);
            edge.put("w", w);
            edgeList.add(edge);
        }
        graph.put("edges", edgeList);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filename), graph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}