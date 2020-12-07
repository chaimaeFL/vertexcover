package vertexcover;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoverVertex {
    private Set<List<Edge>> allCoverVertex = new HashSet<>();
    private Graph graph;
    private int currentPointer = 0;
    private int k;
    private List<int[]> allCombination = new ArrayList<>();
    private int getLengthVertices() {
        //return this.graph.getVertices().size();
        return 10;
    }

    public CoverVertex(Graph graph, int k) {
        this.graph = graph;
        this.k = k;
    }

    private boolean isMatch(List<Edge> edges1, List<Edge> edges2) {
        if (edges1.size() != edges2.size()) return false;
        boolean result = true;
        for(int i = 0; i< edges1.size(); i++) {
            result = result && edges1.get(i) == edges2.get(i);
        }
        return result;
    }

    public void addCoverVertex(List<Edge> edges) {
        if (!allCoverVertex.stream().anyMatch(coverVertex -> isMatch(coverVertex, edges))) {
            allCoverVertex.add(edges);
        }
    }

    private int[] initVerticesArray(int pointer) {
        int[] arr = new int[k];
        for (int i = 0; i< k; i++) {
            arr[i] = 0; //this.graph.getVertices().get(i).getId();
        }
        return arr;
    }

    private List<Vertice> selectNextVertices(int[] kArry) {
        List<Vertice> vertices = new ArrayList<>();
        List<Vertice> allVertices = graph.getVertices();

        return vertices;
    }

    private boolean isVertxCover(List<Edge> edges) {
        boolean result = false;

        return result;
    }

    public void startSearch() {
        boolean vertxCover = false;
        int[] kArray = initVerticesArray(0);
        while (!vertxCover) {
            List<Vertice> vertices = selectNextVertices(kArray);
            if (vertices == null) {
                break;
            }
            kArray = incrementKArray(kArray);
            if (kArray!= null) {
                int[] copiedArray = Arrays.copyOf(kArray, kArray.length);
                allCombination.add(copiedArray);
            } else {
                break;
            }
            printIndices(kArray);
            List<Edge> edges = getEdgesFromVertices(vertices);
            vertxCover = isVertxCover(edges);
        }
        List<int[]> reducedCombination = filterAllCombination();
        System.out.println("reduced Combination:");
        reducedCombination.forEach(this::printIndices);
    }

    private void printIndices(int[] kArray) {
        for (int h=0;h<kArray.length;h++){
            System.out.print(kArray[h] + " ");
        }
        System.out.println("");
    }

    int i =0;
    int j =1;
    private int[] incrementKArray(int[] kArray ) {
        if ((kArray[k -1- i] + 1) <= getLengthVertices() -1 - i) {
            kArray[k -1 -i] = kArray[k -1- i] + 1;
        } else {
            boolean shouldStop = true;
            for (int t=0; t< kArray.length; t++) {
                if (kArray[t] == getLengthVertices() -1 - i) {
                    shouldStop &= true;
                } else shouldStop= false;
            }
         if (shouldStop) {
             return null;
         }
            while (kArray[k-1 -j -i] +1 > getLengthVertices() -1 - i ) {
                j = j +1;
            }
            kArray[k-1 -j -i] = kArray[k -1 -j - i] + 1;
            for (int d =0; d <  j; d++) {
                kArray[k-d -1] = 0;
            }
            j = 1;

        }
        return kArray;
    }

    private List<Edge> getEdgesFromVertices(List<Vertice> vertices) {
        List<Edge> edges = new ArrayList<>();

        return edges;
    }

    private List<int[]> filterAllCombination() {
        List<int[]> filteredKarray = new ArrayList<>();
        List<int[]> finalFilteredKarray = filteredKarray;
        this.allCombination.forEach(item -> {
            if (!checkForDuplicates(item)) {
                int[] copiedArray = Arrays.copyOf(item, item.length);
                Arrays.sort(copiedArray);
                finalFilteredKarray.add(copiedArray);
            }
        });
        filteredKarray = removeDuplicates(filteredKarray);
        return filteredKarray;
    }

    private List<int[]> removeDuplicates(List<int[]> array)
    {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            boolean dupplicate = false;
            for (int j = i + 1; j < array.size(); j++) {
                if (Arrays.equals(array.get(i), array.get(j))) {
                    dupplicate = true;
                    break;
                }
            }
            if (!dupplicate)
                list.add(array.get(i));
        }
        return list;
    }

    private static <T> boolean checkForDuplicates(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }

        // no duplicate found
        return false;
    }

}
