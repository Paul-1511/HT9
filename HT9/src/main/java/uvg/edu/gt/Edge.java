package uvg.edu.gt;

import java.util.*;
import java.io.*;

class Edge {
    public String source;
    public String destination;
    public int cost;

    public Edge(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}
