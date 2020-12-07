package vertexcover;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int id;
    private List<Edge> edges = new ArrayList<>();

    public Vertice(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge edge) {
        if (edge != null) {
            boolean anyMatch = this.edges.stream().anyMatch(item -> item.getId().equals(edge.getId()));
            if (!anyMatch) {
                this.edges.add(edge);
            }
        }
    }

    public List<Edge> getEdges() {
        return this.edges;
    }
}
