import java.util.*;

public class GraphTopologicalSort {
    static Map<String,Vertex> adjList = new HashMap<>();
    static class Vertex{
        String label;
        Set<Vertex> neighbours;
        Vertex(String l){
            label = l;
            neighbours = new HashSet<>();
        }
        @Override
        public String toString(){
            String str = label+"--> [";
            int i = 1;
            for(Vertex v: neighbours){
                if(i != neighbours.size())str += v.label+",";
                else str += v.label;
                i++;
            }
            str += "]";
            return str;
        }
    }
    public static void addEdge(String u,String v){
        Vertex vertex = adjList.get(u);
        vertex.neighbours.add(adjList.get(v));
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
        addEdge("e","h");
        addEdge("b","f");
        addEdge("f","b");
        for(Map.Entry<String,Vertex> m : adjList.entrySet()){
            System.out.println(m.getValue());
        }
        topologicalSort(adjList);
    }
    public static void topologicalSort(Map<String,Vertex> adjList){
        Set<String> seen = new HashSet<>();
        Stack<String> topSort = new Stack<>();
        boolean b=false;
        for(Map.Entry<String,Vertex> curr : adjList.entrySet()){
            if(!seen.contains(curr.getKey())){
                b=explore(curr.getValue(),seen,topSort);
            }
        }
        while (!topSort.isEmpty() && b){
            System.out.println(topSort.pop());
        }

    }
    public static boolean explore(Vertex curr,Set<String> seen,Stack<String> topSort){
        seen.add(curr.label);
        topSort.push(curr.label);
        boolean flag= true;
        for(Vertex nei : curr.neighbours){
            if(!seen.contains(nei.label ) && flag){
                explore(nei,seen,topSort);
            }
            else {
                System.out.println("Topological Sort Not Possible");
                flag =false;
                return flag;

            }
            if(!flag) break;
        }
        return flag;
    }


}
