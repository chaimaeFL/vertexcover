package vertexcover;

import javax.rmi.CORBA.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private int k;
    private Graph graph = new Graph();
    public void parse() throws Exception {
        BufferedReader buffread = new BufferedReader(new FileReader("codierung-string.txt"));
        String codingString;
        try {
            codingString = buffread.readLine();
            String kString = buffread.readLine();
            this.k = Integer.parseInt(kString);
            System.out.println("Coding String: " + codingString);
            String regEx = "\\{[v?V]?[0-1]*,[v?V]?[0-1]*\\}";
            Pattern pattern = Pattern.compile(regEx);
            Matcher m = pattern.matcher(codingString);
            while(m.find()) {
                String edgeString = m.group();
                pattern = Pattern.compile("[v?V]?[0-1]*,[v?V]?[0-1]*");
                Matcher matcher = pattern.matcher(edgeString);
                if (matcher.find()) {
                    String group = matcher.group();
                    String[] split = group.split(",");
                    int id1 = Utils.convertToInteger(split[0]);
                    int id2 = Utils.convertToInteger(split[1]);
                    Vertice vertice1 = new Vertice(id1);
                    Vertice vertice2 = new Vertice(id2);
                    Edge edge = new Edge(vertice1, vertice2);
                    vertice1.addEdge(edge);
                    vertice2.addEdge(edge);
                    graph.addEdge(edge);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            buffread.close();
        }
    }

    public int getK() {
        return k;
    }

    public Graph getGraph() {
        return graph;
    }
}
