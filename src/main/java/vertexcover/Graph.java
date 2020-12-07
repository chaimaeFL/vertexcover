package vertexcover;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SortVertices implements Comparator<Vertice>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Vertice a, Vertice b)
    {
        return a.getId() - b.getId();
    }
}

public class Graph {
    private Set<Vertice> vertices = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Set<Edge> getEdges() {
        return edges;
    }

    public List<Vertice> getVertices() {
        List<Vertice> vertices = new ArrayList<>(this.vertices);
        Collections.sort(vertices, new SortVertices());
        return vertices;
    }

    public void addEdge(Edge edge) {
        boolean isExists = this.edges.stream().anyMatch(item -> item.getId().equals(edge.getId()));
        if (!isExists) {
            this.edges.add(edge);
            if (!this.vertices.stream().anyMatch(item -> item.getId() == (edge.getV1().getId()))) {
                this.vertices.add(edge.getV1());
            }
            if (!this.vertices.stream().anyMatch(item -> item.getId() == (edge.getV2().getId()))) {
                this.vertices.add(edge.getV2());
            }
        }
    }

    public List<Edge> getEdgesFromVertex(Vertice vertice) {
        List<Edge> collect = this.edges.stream().filter(item -> vertice.getId() == item.getV1().getId() ).collect(Collectors.toList());
        return collect;
    }
}
