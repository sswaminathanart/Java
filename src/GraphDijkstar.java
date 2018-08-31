import java.util.*;

public class GraphDijkstar {
    static class Vertex implements Comparable<Vertex>{
        String label;
        Set<Edge> neighbours;
        Set<Vertex> path;
        double minDistance = Double.POSITIVE_INFINITY;
        Vertex(String l){
            label = l;
            neighbours = new HashSet<>();
            path = new HashSet<>();
        }
        public int compareTo(Vertex other){
            return Double.compare(this.minDistance,other.minDistance);
        }
        @Override
        public String toString(){
            String str = "Node "+label +" ->[";
            for(Edge e : neighbours){
                str += "(Node "+e.target.label+",Weight "+e.weight
                        + ",Min Distance "+e.target.minDistance +")\n\t\t";
            }
            str += "]";
            return str;
        }
    }
    static class Edge{
        Vertex target;
        Double weight;
        Edge(Vertex t,Double w){
            target = t;
            weight = w;
        }
    }
    static class Graph{
        Map<String,Vertex> adjList;
        Graph(){
            adjList = new HashMap<>();
        }
        public void addEdge(String source,String traget,Double weight){
            Edge newEdge = new Edge(adjList.get(traget),weight);
            adjList.get(source).neighbours.add(newEdge);
        }
    }
    public static void main(String args[]){
        Graph g = new Graph();
        g.adjList.put("A",new Vertex("A"));
        g.adjList.put("B",new Vertex("B"));
        g.adjList.put("C",new Vertex("C"));
        g.adjList.put("D",new Vertex("D"));
        g.addEdge("A","B",10.0);
        g.addEdge("A","C",20.0);
        g.addEdge("B","A",10.0);
        g.addEdge("B","C",5.0);
        g.addEdge("B","D",16.0);
        g.addEdge("C","A",20.0);
        g.addEdge("C","B",5.0);
        g.addEdge("C","D",20.0);
        g.addEdge("D","B",16.0);
        g.addEdge("D","C",20.0);
        calculatemindistance(g.adjList.get("A"));
        System.out.println("My Graphs "+g.adjList.size());
        for(Map.Entry<String,Vertex> m :g.adjList.entrySet()){
            System.out.println(m.getValue());
        }




    }
    /*public static void calculatemindistance(Vertex source){
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);
        source.minDistance = 0.0;
        while (!priorityQueue.isEmpty()){
            Vertex curr = priorityQueue.poll();
            for(Edge edge : curr.neighbours){
                Double newminDistance = curr.minDistance + edge.weight;
                if(newminDistance<edge.target.minDistance){
                    priorityQueue.remove(edge.target);
                    edge.target.minDistance =newminDistance;
                    edge.target.path=curr.path;
                    priorityQueue.add(edge.target);
                }
            }
        }

    }*/
    public static void calculatemindistance(Vertex start){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        start.minDistance = 0;
        pq.add(start);
        while (!pq.isEmpty()){
            Vertex curr = pq.poll();
            for(Edge e : curr.neighbours){
                Double minDistance =  curr.minDistance + e.weight;
                if(e.target.minDistance > minDistance){
                    pq.remove(e.target);
                    e.target.minDistance = minDistance;
                    e.target.path = curr.path;
                    e.target.path.add(curr);
                    pq.add(e.target);
                }
            }
        }

    }
}
