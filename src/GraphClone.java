import java.util.HashSet;
import java.util.Set;

public class GraphClone {
    static class Vertex {
        int label;
        Set<Vertex> neighbours;

        Vertex(int l) {
            label = l;
            neighbours = new HashSet<>();
        }

        @Override
        public String toString() {
            String str = label + "--> [";
            int i = 1;
            for (Vertex v : neighbours) {
                if (i != neighbours.size())
                    str += v.label + ",";
                else str += v.label;
                i++;
            }
            str += "]";
            return str;
        }
    }

    static class Graph {
        Set<Vertex> adjList;

        Graph() {
            adjList = new HashSet<>();
        }
    }

    public static void main(String args[]) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(9);
        Vertex v10 = new Vertex(10);
        Vertex v11 = new Vertex(11);
        v1.neighbours.add(v2);
        v1.neighbours.add(v3);
        v2.neighbours.add(v1);
        v2.neighbours.add(v3);
        v3.neighbours.add(v1);
        v3.neighbours.add(v2);
        v3.neighbours.add(v4);
        v3.neighbours.add(v5);
        v4.neighbours.add(v2);
        v4.neighbours.add(v3);
        v4.neighbours.add(v6);
        v5.neighbours.add(v3);
        v5.neighbours.add(v6);
        v5.neighbours.add(v7);
        v5.neighbours.add(v8);
        v6.neighbours.add(v4);
        v6.neighbours.add(v5);
        v6.neighbours.add(v9);
        v7.neighbours.add(v4);
        v7.neighbours.add(v5);
        v7.neighbours.add(v9);
        v7.neighbours.add(v10);
        v8.neighbours.add(v5);
        v8.neighbours.add(v9);
        v8.neighbours.add(v11);
        v9.neighbours.add(v7);
        v9.neighbours.add(v8);
        v9.neighbours.add(v6);
        v10.neighbours.add(v7);
        v11.neighbours.add(v8);
        Graph g = new Graph();
        g.adjList.add(v1);
        g.adjList.add(v2);
        g.adjList.add(v3);
        g.adjList.add(v4);
        g.adjList.add(v5);
        g.adjList.add(v6);
        g.adjList.add(v7);
        g.adjList.add(v8);
        g.adjList.add(v9);
        g.adjList.add(v10);
        g.adjList.add(v11);
        for (Vertex v : g.adjList) {
            System.out.println(v);

        }
        Graph clone = cloneTheGraph(g);
        System.out.println("Copy...");
        for (Vertex v : clone.adjList) {
            System.out.println(v);

        }
    }

    public static Graph cloneTheGraph(Graph g) {
        Graph graphClone = new Graph();
        Set<Vertex> seen = new HashSet<>();
        for (Vertex v : g.adjList) {
            graphClone.adjList.add(cloneTheVertex(v, seen));
        }
        return graphClone;
    }

    public static Vertex cloneTheVertex(Vertex v, Set<Vertex> seen) {
        if (seen.contains(v)) return v;

        Vertex vertex = new Vertex(v.label);
        seen.add(v);
        for (Vertex nei : v.neighbours) {
            vertex.neighbours.add(cloneTheVertex(nei, seen));
        }

        return vertex;

    }

}
