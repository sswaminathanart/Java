import java.util.*;

public class TopologicalSort {
    static HashMap<String,Vertex> adjList = new HashMap<>();
    static Map<String,Integer> inDegree = new HashMap<>();
     static class Vertex{
        String label;
        List<Vertex> neighbors;
        public  Vertex(String str){
            label =str;
            neighbors = new ArrayList<>();
        }
        @Override
        public String toString(){
            String str = label+"--> [";
            for(Vertex v: neighbors){
                str += v.label+",";
            }
            str += "]";
            return str;
        }
    }
    public static void addEdge(String a,String b){
        Vertex v=adjList.get(a);
        v.neighbors.add(adjList.get(b));
    }
    public static List<Vertex>  topSort(HashMap<String,Vertex> adjList){
        List<Vertex> stack = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        for(Map.Entry<String,Vertex> curr : adjList.entrySet()){
            if(!visited.contains(curr.getValue()))
            explore(curr.getValue(),stack,visited);
        }
        return stack;
    }
    public static void explore(Vertex curr,List<Vertex> stack, Set<Vertex> visited){
        visited.add(curr);
        for(Vertex nxt:curr.neighbors){
            if(!visited.contains(nxt)){
                explore(nxt,stack,visited);
            }
            else
            {
                System.out.println("Not possible");
                stack = null;
                return;
            }
        }
        stack.add(0,curr);
    }
    public static void main(String args[]){
        adjList.put("a",new Vertex("a"));
        adjList.put("b",new Vertex("b"));
        adjList.put("c",new Vertex("c"));
        adjList.put("d",new Vertex("d"));
        adjList.put("e",new Vertex("e"));
        adjList.put("f",new Vertex("f"));
        adjList.put("g",new Vertex("g"));
        adjList.put("h",new Vertex("h"));
        addEdge("a","b");
        addEdge("b","c");
        addEdge("c","e");
        for(Map.Entry<String,Vertex> e: adjList.entrySet()) {
            inDegree.put(e.getKey(),e.getValue().neighbors.size());
            System.out.println(e.getValue());
        }
        for(Map.Entry<String,Integer> e : inDegree.entrySet()){
            System.out.println(e.getKey() +" ====> "+ e.getValue());
        }
        List<Vertex>  d=topSort(adjList);
        System.out.println("Top Sort");
         for (Vertex v : d) {
                System.out.println(v);
            }
        }



}
