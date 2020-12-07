package vertexcover;

public class Main {
    public static void main(String[]args) throws Exception {
        System.out.println("start program");
        // create new instance of Parser
        Parser parseCodierung = new Parser();
        // parse and convert to graph structure
        parseCodierung.parse();

        Graph graph = parseCodierung.getGraph();
        int k = parseCodierung.getK();
        // create new Instance of printResult
        PrintResult printResult = new PrintResult();
        printResult.printGraph(graph, k);

        // search cover vertex
        CoverVertex coverVertex = new CoverVertex(graph, k);
        coverVertex.startSearch();

        int arr[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 22};
        int r = 3;
        int n = arr.length;
        //coverVertex.printCombination(arr, n, r);
    }
}
