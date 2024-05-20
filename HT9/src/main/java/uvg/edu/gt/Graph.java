package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Graph {
    public Map<String, List<Edge>> adjList = new HashMap<>();

    public void addEdge(String source, String destination, int cost) {
        Edge edge = new Edge(source, destination, cost);
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(edge);
        // Como las rutas son simétricas, agregamos la ruta inversa también
        Edge reverseEdge = new Edge(destination, source, cost);
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(destination).add(reverseEdge);
    }

    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String station : adjList.keySet()) {
            distances.put(station, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.add(new Edge(start, start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            for (Edge adjEdge : adjList.get(edge.destination)) {
                int newDistance = distances.get(edge.destination) + adjEdge.cost;
                if (newDistance < distances.get(adjEdge.destination)) {
                    distances.put(adjEdge.destination, newDistance);
                    pq.add(new Edge(adjEdge.source, adjEdge.destination, newDistance));
                }
            }
        }

        return distances;
    }

    public void loadFromFile(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String source = parts[0].trim().replace("\"", "");
            String destination = parts[1].trim().replace("\"", "");
            int cost = Integer.parseInt(parts[2].trim());
            addEdge(source, destination, cost);
        }
        br.close();
    }
}
