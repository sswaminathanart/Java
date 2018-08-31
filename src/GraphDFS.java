import java.util.*;

public class GraphDFS {
    static Map<Integer,Vertex> adjList = new HashMap<>();
    static class Vertex{
        int label;
        Set<Vertex> neighbours;
        Vertex(int l){
            label = l;
            neighbours = new HashSet<>();
        }
        @Override
        public String toString(){
            String s = label +"--->" ;
            for(Vertex v : neighbours){
                s = s+ v.label + " ";
            }
            return  s;
        }

    }
    public static void main(String args[]){
        for(int i=1;i<=11;i++) {
            adjList.put(i, new Vertex(i));
        }
            addEdge(1,2);
            addEdge(1,3);
            addEdge(2,1);
            addEdge(2,3);
            addEdge(2,4);
            addEdge(3,1);
            addEdge(3,2);
            addEdge(3,4);
            addEdge(3,5);
            addEdge(4,2);
            addEdge(4,3);
            addEdge(4,6);
            addEdge(5,3);
            addEdge(5,6);
            addEdge(5,7);
            addEdge(5,8);
            addEdge(6,4);
            addEdge(6,5);
            addEdge(6,9);
            addEdge(7,4);
            addEdge(7,5);
            addEdge(7,9);
            addEdge(7,10);
            addEdge(8,5);
            addEdge(8,9);
            addEdge(8,11);
            addEdge(9,6);
            addEdge(9,7);
            addEdge(9,8);
            addEdge(10,7);
            addEdge(11,8);
        for(Map.Entry<Integer,Vertex> m: adjList.entrySet()){
            System.out.println(m.getValue());
        }
        dsf(adjList);

    }
    public static void dsf(Map<Integer,Vertex> adjList){
        Set<Integer> seen = new HashSet<>();
        for(Map.Entry<Integer,Vertex> curr : adjList.entrySet()){
            if(!seen.contains(curr.getKey())){
                List<Integer> comp = new ArrayList<>();
                explore(curr.getValue(),comp,seen);
                for(Integer i : comp)
                System.out.println(i);
            }

        }
    }
    public static void explore(Vertex v,List<Integer> comp,Set<Integer> seen){
        seen.add(v.label);
        comp.add(v.label);
        for(Vertex nei:v.neighbours){
            if(!seen.contains(nei.label)){
                explore(nei,comp,seen);
            }
        }
    }
    public static void addEdge(int u,int v){
        Vertex temp = adjList.get(u);
        temp.neighbours.add(adjList.get(v));

    }

}

