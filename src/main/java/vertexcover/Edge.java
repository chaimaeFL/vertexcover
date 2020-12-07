package vertexcover;

public class Edge {
    private String id;
    private Vertice v1;
    private Vertice v2;

    public Edge(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
        if (v1.getId() < v2.getId())
            this.id = "id_" + v1.getId() + "_" + v2.getId();
        else
            this.id = "id_" + v2.getId() + "_" + v1.getId();
    }

    public Vertice getV1() {
        return v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public String getId() {
        return id;
    }
}
