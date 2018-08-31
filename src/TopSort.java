import java.util.*;

public class TopSort {
    static Map<Integer,Vertex> adjList =new HashMap<>();
    static class Vertex{
        int label;
        List<Vertex> neighbors;
        Vertex(int l){
            label = l;
            neighbors = new ArrayList<>();
        }
        @Override
        public  String toString(){
            String s = label +"-->[";
            for(Vertex v : neighbors){
                s += v.label +",";
            }
            s += "]";
            return s;
        }

    }
    static void addEdge(int u,int v){
        adjList.get(u).neighbors.add(adjList.get(v));
    }
    static int bsf(Vertex start,Vertex target){
        Queue<Vertex> q = new LinkedList<>();
        Map<Integer,Integer> distanceMap = new HashMap<>();
        ((LinkedList<Vertex>) q).add(start);
        distanceMap.put(start.label,0);
        while (!q.isEmpty()){
            Vertex curr = q.poll();
            if(curr.label == target.label)
                return distanceMap.get(curr.label);
            for(Vertex nxt : curr.neighbors){
                if(!distanceMap.containsKey(nxt.label)){
                    ((LinkedList<Vertex>) q).add(nxt);
                    distanceMap.put(nxt.label,distanceMap.get(curr.label)+1);
                }
            }
        }
        return -1;
    }
    static List<Integer> bsfPath(Vertex start,Vertex target){
        Queue<Vertex> q = new LinkedList<>();
        Map<Integer,Integer> distanceMap = new HashMap<>();
        Map<Integer,Vertex> prev = new HashMap<>();
        ((LinkedList<Vertex>) q).add(start);
        distanceMap.put(start.label,0);
        while (!q.isEmpty()){
            Vertex curr = q.poll();
            if(curr.label == target.label)
                return buildPath(prev,target);
            for(Vertex nxt : curr.neighbors){
                if(!distanceMap.containsKey(nxt.label)){
                    ((LinkedList<Vertex>) q).add(nxt);
                    distanceMap.put(nxt.label,distanceMap.get(curr.label)+1);
                    prev.put(nxt.label,curr);
                }
            }
        }
        return null;
    }
    static List<Integer> buildPath(Map<Integer,Vertex>  prev,Vertex target){
        List<Integer> path = new LinkedList<>();
        Vertex curr = target;
        while(prev.get(curr.label) != null){
            path.add(curr.label);
            curr = prev.get(curr.label);
        }
        path.add(curr.label);
        Collections.reverse(path);
        return path;
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
        for(int i=1;i<=11;i++){
            System.out.println(adjList.get(i));
        }
        int i = bsf(adjList.get(1),adjList.get(8));
        System.out.println("Distance between "+adjList.get(1)+" and "+adjList.get(8)+" is "+i);
        List<Integer> path=  bsfPath(adjList.get(1),adjList.get(8));
        System.out.println();
        for(Integer k : path){
            System.out.print(k +" -->  ");
        }
    }


}
