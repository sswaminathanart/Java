import java.util.*;

public class Dijkstar1 {
    public static void main(String args[]) {
        Dijkstar1 d = new Dijkstar1();
        Graphss g = new Graphss();

        g.adjList.put("A", new Vertex1("A"));
        g.adjList.put("B", new Vertex1("B"));
        g.adjList.put("C", new Vertex1("C"));
        g.adjList.put("D", new Vertex1("D"));
        g.addEdge("A", "B", 10.0);
        g.addEdge("A", "C", 20.0);
        g.addEdge("B", "A", 10.0);
        g.addEdge("B", "C", 5.0);
        g.addEdge("B", "D", 16.0);
        g.addEdge("C", "A", 20.0);
        g.addEdge("C", "B", 5.0);
        g.addEdge("C", "D", 20.0);
        g.addEdge("D", "B", 16.0);
        g.addEdge("D", "C", 20.0);
        calculatemindistance(g.adjList.get("A"));
        System.out.println("My Graphs "+g.adjList.size());
        for(Map.Entry<String,Vertex1> m :g.adjList.entrySet()){
            System.out.println(m.getValue());
        }
    }
    public static void calculatemindistance(Vertex1 start){
        PriorityQueue<Vertex1> pq = new PriorityQueue<>();
        Map<String,Vertex1> minDistance = new HashMap<>();
        pq.add(start);
        start.minDistance = 0.0;
        minDistance.put(start.lablel,start);
        while (!pq.isEmpty()){
            Vertex1 curr = pq.poll();
            for(Edgee nxt : curr.neighbours){
                Double newDistance = curr.minDistance + nxt.weight;
                if(newDistance< nxt.target.minDistance){
                    pq.remove(nxt.target);
                    nxt.target.minDistance = newDistance;
                    minDistance.put(nxt.target.lablel,nxt.target);
                    nxt.target.path = curr.path;
                    nxt.target.path.add(curr);
                    pq.add(nxt.target);
                }
            }
        }

    }
}
    class Vertex1 implements Comparable<Vertex1>{
        String lablel;
        List<Edgee> neighbours;
        Double minDistance = Double.POSITIVE_INFINITY;
        List<Vertex1> path;
        Vertex1(String l){
            lablel = l;
            neighbours = new ArrayList<>();
            path = new LinkedList<>();
        }
        public int compareTo(Vertex1 other){
            return Double.compare(this.minDistance,other.minDistance);
        }
        @Override
        public String toString(){
            String str = "Node "+lablel +" ->[";
            for(Edgee e : neighbours){
                str += "(Node "+e.target.lablel+",Weight "+e.weight
                        + ",Min Distance "+e.target.minDistance +")\n\t\t";
            }
            str += "]";
            return str;
        }
    }


class Edgee {
    Vertex1 target;
    Double weight;
    Edgee(Vertex1 v,Double d){
        target = v;
        weight = d;
    }

}
class Graphss{
    Map<String,Vertex1> adjList;
    Graphss(){
        adjList = new HashMap<>();
    }
    public void addEdge(String source,String traget,Double weight){
        Vertex1 sourceV = adjList.get(source);
        Vertex1 targetV = adjList.get(traget);
        Edgee newEdge = new Edgee(targetV,weight);
        sourceV.neighbours.add(newEdge);
    }
}