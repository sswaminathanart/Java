import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphIsCycle {
    static Map<Integer,Vertex> adjList = new HashMap<>();
    static Set<Vertex> whiteSet = new HashSet<>();
    static Set<Vertex> graySet = new HashSet<>();
    static Set<Vertex> blackSet = new HashSet<>();
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
    public static void addEdge(int u,int v){
        adjList.get(u).neighbours.add(adjList.get(v));

    }
    public static void main(String args[]){
        for(int i=1;i<=11;i++) {
            adjList.put(i, new Vertex(i));
        }
        addEdge(1,2);
        //addEdge(1,3);
        //addEdge(2,1);
        addEdge(2,3);
        addEdge(2,4);
        //addEdge(3,1);
        //addEdge(3,2);
        addEdge(3,4);
        addEdge(3,5);
        //addEdge(4,2);
        //addEdge(4,3);
        addEdge(4,6);
       // addEdge(5,3);
        addEdge(5,6);
        addEdge(5,7);
        addEdge(5,8);
       // addEdge(6,4);
        //addEdge(6,5);
        addEdge(6,9);
        addEdge(7,4);
        //addEdge(7,5);
        addEdge(7,9);
        addEdge(7,10);
        //addEdge(8,5);
        addEdge(8,9);
        addEdge(8,11);
       // addEdge(9,6);
        //addEdge(9,7);
        //addEdge(9,1);
        addEdge(10,9);
        //addEdge(11,1);
        for(Map.Entry<Integer,Vertex> m: adjList.entrySet()){
            System.out.println(m.getValue());
        }
        boolean b = isCycle(adjList);
        if(b==true)  System.out.println("Cycle");
        else System.out.println("Not Cycle");
        for(Vertex v : graySet){
            System.out.println(v);
        }
    }
    public static boolean isCycle(Map<Integer,Vertex> adjList){

        for(Map.Entry<Integer,Vertex> m : adjList.entrySet()){
            whiteSet.add(m.getValue());
        }
        while (!whiteSet.isEmpty()){
            Vertex curr = whiteSet.iterator().next();
            if(explore(curr)) return true;
        }
        return !graySet.isEmpty();
    }
    public static boolean explore(Vertex curr){
        moveVertex(whiteSet,graySet,curr);
        for (Vertex nei : curr.neighbours){
            if(blackSet.contains(nei)) continue;
            if(graySet.contains(nei)) return true;
            if(explore(nei)) return true;

        }
        moveVertex(graySet,blackSet,curr);
        return false;
    }
    public static void moveVertex(Set<Vertex> source,Set<Vertex> dest,Vertex curr){
        source.remove(curr);
        dest.add(curr);
    }
}
