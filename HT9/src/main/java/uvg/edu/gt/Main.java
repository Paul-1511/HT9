package uvg.edu.gt;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.loadFromFile("rutas.txt");
        Map<String, Integer> distances = graph.dijkstra("Pueblo Paleta");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("La distancia desde Pueblo Paleta hasta " + entry.getKey() + " es " + entry.getValue());
        }
    }
}
