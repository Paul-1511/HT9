package uvg.edu.gt;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test
    void testDijkstra() {
        Graph graph = new Graph();
        graph.addEdge("Pueblo Paleta", "Aldea Azalea", 100);
        graph.addEdge("Aldea Azalea", "Ciudad Safiro", 150);
        graph.addEdge("Pueblo Paleta", "Ciudad Safiro", 800);
        graph.addEdge("Ciudad Lavanda", "Aldea Fuego", 300);

        Map<String, Integer> distances = graph.dijkstra("Pueblo Paleta");

        assertEquals(0, ((Map<?, ?>) distances).get("Pueblo Paleta"));
        assertEquals(100, distances.get("Aldea Azalea"));
        assertEquals(250, distances.get("Ciudad Safiro"));
        assertEquals(Integer.MAX_VALUE, distances.get("Ciudad Lavanda"));
        assertEquals(Integer.MAX_VALUE, distances.get("Aldea Fuego"));
    }
}
