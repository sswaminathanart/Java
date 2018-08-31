import java.util.*;

public class CloneGraph {

    static class Vertex{
        int label;
        Vector<Vertex> neighbors;
        Vertex(int l){
            label = l;
            neighbors = new Vector<>();
        }
        @Override
        public String toString(){
           String str =label + "--> [" ;
           for(Vertex v : neighbors){
               str += v.label +",";
           }
           str += "]";
           return str;
        }

    }
    static class Graph{
        Vector<Vertex> v;
        Graph(){
            v= new Vector<>();
        }
    }

    public static Graph clone( Graph g){
        Graph cloneg = new Graph();
        Map<Integer,Vertex> seen = new HashMap<>();
        for(int i=0;i<g.v.size();++i){
            cloneg.v.add(clonev(g.v.get(i),seen));
        }

        return cloneg;
    }
    public static Vertex clonev(Vertex curr,Map<Integer,Vertex> seen){
        if(seen.containsKey(curr.label)) return seen.get(curr.label);
        else
        {
            Vertex v = new Vertex(curr.label);
            seen.put(v.label,v);
            for(Vertex nei : curr.neighbors){
                v.neighbors.add(clonev(nei,seen));
            }
            return v;
        }
    }
    public static void main(String args[]){
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
        v1.neighbors.add(v2);
        v1.neighbors.add(v3);
        v2.neighbors.add(v1);
        v2.neighbors.add(v3);
        v3.neighbors.add(v1);
        v3.neighbors.add(v2);
        v3.neighbors.add(v4);
        v3.neighbors.add(v5);
        v4.neighbors.add(v2);
        v4.neighbors.add(v3);
        v4.neighbors.add(v6);
        v5.neighbors.add(v3);
        v5.neighbors.add(v6);
        v5.neighbors.add(v7);
        v5.neighbors.add(v8);
        v6.neighbors.add(v4);
        v6.neighbors.add(v5);
        v6.neighbors.add(v9);
        v7.neighbors.add(v4);
        v7.neighbors.add(v5);
        v7.neighbors.add(v9);
        v7.neighbors.add(v10);
        v8.neighbors.add(v5);
        v8.neighbors.add(v9);
        v8.neighbors.add(v11);
        v9.neighbors.add(v7);
        v9.neighbors.add(v8);
        v9.neighbors.add(v6);
        v10.neighbors.add(v7);
        v11.neighbors.add(v8);
        Graph g= new Graph();
        g.v.add(v1);
        g.v.add(v2);
        g.v.add(v3);
        g.v.add(v4);
        g.v.add(v5);
        g.v.add(v6);
        g.v.add(v7);
        g.v.add(v8);
        g.v.add(v9);
        g.v.add(v10);
        g.v.add(v11);
        for(int i=0;i<g.v.size();i++){
            System.out.println(g.v.get(i));
        }
        Graph clone_g = clone(g);
        System.out.println("Copy   ");
        for(int i=0;i<clone_g.v.size();i++){
            System.out.println(clone_g.v.get(i));
        }
        dfs(g);
        int distance = bfs(g.v.get(1),g.v.get(8));
        System.out.println("Distance "+ distance);

        /* for(int i=1;i<=11;i++){
            adjList.put(i,new Vertex(i));
        }


        addEdge(10,7);
        addEdge(11,8);
        for(int i=1;i<=11;i++){
            System.out.println(adjList.get(i));
        }
        Map<Integer,Vertex> cloneadjList =clone(adjList);*/
    }
    public static int bfs(Vertex start,Vertex target){
        Queue<Vertex> q = new LinkedList<>();
        HashMap<Integer,Integer> distMap = new HashMap<>();
        ((LinkedList<Vertex>) q).add(start);
        distMap.put(start.label,0);
        while (!q.isEmpty()){
            Vertex curr =  q.poll();
            if(curr.label == target.label){
                return distMap.get(curr.label);
            }
            for(Vertex nxt : curr.neighbors){
                if(!distMap.containsKey(nxt.label)){
                    distMap.put(nxt.label,distMap.get(curr.label)+1);
                    ((LinkedList<Vertex>) q).add(nxt);
                }

            }
        }
        return -1;
    }
    public static void dfs(Graph g){
        Set<Integer> seen = new HashSet<>();
        for(Vertex curr : g.v){
            if(!seen.contains(curr.label)){
                explore(curr,seen);
            }
        }
        for (Integer i: seen){
            System.out.println(i);
        }
    }
    public static void explore(Vertex curr,Set<Integer> seen){
        seen.add(curr.label);
        for(Vertex nxt : curr.neighbors){
            if(!seen.contains(nxt.label)){
                explore(nxt,seen);
            }
        }
    }

}
