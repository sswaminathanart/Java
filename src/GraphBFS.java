import java.util.*;

public class GraphBFS {
    static Map<Integer,Vertex> adjList = new HashMap<>();
    static class Vertex{
        int label;
        Set<Vertex> neighbours;
        Vertex(int l){
            label  = l;
            neighbours = new HashSet<>();
        }
        @Override
        public String toString(){
            String output =label +"--> [";
            for(Vertex v : neighbours){
                output = output + v.label + " , ";
            }
            output = output +"]";
            return output;
        }
    }

    static void addEdge(int u,int v){
        Vertex vertex = adjList.get(u);
        vertex.neighbours.add(adjList.get(v));
    }
    public static void main(String args[]){
        for(int i=1;i<=11;i++){
            adjList.put(i,new Vertex(i));
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
        int distance =bfs(adjList.get(1),adjList.get(10));
        System.out.println("Distance between 1 and 10 "+ distance);
    }
    public static int bfs(Vertex source,Vertex dest){
        Map<Integer,Integer> distanceMap = new HashMap<>();
        Map<Vertex,Vertex> path = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        List<Integer> pathList = new LinkedList<>();
        ((LinkedList<Vertex>) queue).add(source);
        distanceMap.put(source.label,0);
        while (!queue.isEmpty()){
            Vertex curr = queue.poll();
            if(curr.label== dest.label){
                pathList =buildPath(source,dest,path);
                for(Integer i : pathList){
                    System.out.print(i+"  ");
                }
                return distanceMap.get(curr.label);
            }
            for(Vertex nei : curr.neighbours){
                if(!distanceMap.containsKey(nei.label)){
                    ((LinkedList<Vertex>) queue).add(nei);
                    distanceMap.put(nei.label,distanceMap.get(curr.label)+1);
                    path.put(nei,curr);
                }
            }
        }
        return -1;
    }
    public static List<Integer> buildPath(Vertex source,Vertex des,Map<Vertex,Vertex> path){
        LinkedList<Integer> pathLst = new LinkedList<>();
        Vertex curr = des;
        while (path.get(curr)!= null){
            pathLst.add(0,curr.label);
            curr = path.get(curr);

        }
        pathLst.add(0,curr.label);

    return pathLst;
    }
}
