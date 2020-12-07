package vertexcover;

import java.util.List;
import java.util.Set;

public class PrintResult {
    public void printGraph(Graph graph, int k) {
        System.out.println("Anzahl Knoten Überdeckung: " + k);
        System.out.println("Graph besteht aus folgende Knoten: ");
        graph.getVertices().forEach(vertice -> System.out.println("Knoten: " + vertice.getId()));
        System.out.println("Und aus folgende Kanten:");
        graph.getEdges().forEach(edge -> {
            System.out.println(edge.getV1().getId() + "------" + edge.getV2().getId());
        });
    }

    public void printCoverVertex(Set<List<Edge>> allCoverVertex) {
        System.out.println("Alle Mögliche Knoten Überdeckung: ");
        allCoverVertex.forEach(edges -> {
            edges.forEach(edge -> System.out.println(edge.getV1()));
        });
    }
}
