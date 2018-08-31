import java.util.*;

public class Dijkstar {
    public static void main(String args[]){
        Dijkstar d = new Dijkstar();
        Graphs g = new Graphs();
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
class Edge{
    final Vertex target;
    Double weight;
    public Edge(Vertex target,Double weight ){
        this.target = target;
        this.weight = weight;
    }
}
class Vertex implements Comparable<Vertex>{
    final String label;
    List<Edge> neighbours;
    List<Vertex> path;
    double minDistance = Double.POSITIVE_INFINITY;
    public Vertex(String label){
        this.label = label;
        neighbours = new ArrayList<>();
        path = new LinkedList<>();
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
class Graphs{
    Map<String,Vertex> adjList;
    Graphs(){
        adjList = new HashMap<>();
    }
    public void addEdge(String source,String target,Double weight){
        Edge newEdge = new Edge(adjList.get(target),weight);
        adjList.get(source).neighbours.add(newEdge);
    }
}