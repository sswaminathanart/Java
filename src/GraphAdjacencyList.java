import java.util.*;
public class GraphAdjacencyList {
    static HashMap <Integer,Vertex> adjlist = new HashMap<>();
  static class Vertex{
      int label;
      List<Vertex> neighbors;
      Vertex(int l){
          label = l;
          neighbors = new ArrayList<>();
      }

      @Override
      public String toString(){
          String output =label +"--> [";
          for(Vertex v : neighbors){
              output = output + v.label + " , ";
          }
          output = output +"]";
          return output;
      }
  }
  public static void addEdge(int u,int v){
        Vertex ve = adjlist.get(u);
        ve.neighbors.add(adjlist.get(v));
  }
  public static void dfs(HashMap <Integer,Vertex> adjlist){
      Set<Integer> seen = new HashSet<>();
      for(Map.Entry<Integer,Vertex> curr : adjlist.entrySet()){
          if(!seen.contains(curr.getValue().label)){
              List<Integer> comp =new ArrayList<>();
              explore(curr.getValue(),seen,comp);
              System.out.println();
              for(Integer i:comp){
                  System.out.print(i+"  ");
              }
          }
      }
  }
  public static void explore(Vertex curr,Set<Integer> seen,List<Integer> comp){
      seen.add(curr.label);
      comp.add(curr.label);
      for(Vertex nxt : curr.neighbors){
          if(!seen.contains(nxt.label)){
              explore(nxt,seen,comp);
          }
      }
  }
  public static List<Integer> bfs(Vertex start,Vertex dest){
      Queue<Vertex> q =new LinkedList<>();
      HashMap<Integer,Vertex> path = new HashMap<>();
      HashMap<Integer,Integer> dist = new HashMap<>();
      ((LinkedList<Vertex>) q).add(start);
      dist.put(start.label,0);
      while (!q.isEmpty()){
          Vertex curr =q.poll();
          if(curr.label == dest.label){
              for(Integer k: dist.keySet()){
                  System.out.println("\nVisited "+ k);

              }
              return build_path(path,dest);
          }
          for(Vertex nxt : curr.neighbors){
              if(!dist.containsKey(nxt.label)){
                  dist.put(nxt.label,dist.get(curr.label)+1);
                  ((LinkedList<Vertex>) q).add(nxt);
                  path.put(nxt.label,curr);
              }
          }
      }
      return null;
  }
  public static List<Integer> build_path(Map<Integer,Vertex> path,Vertex dest){
      List<Integer> lst = new ArrayList<>();
      Vertex cur =dest;
      while (path.get(cur.label)!= null){
          lst.add(cur.label);
          cur =path.get(cur.label);
      }
      lst.add(cur.label);
      // Collections.reverse(lst);
      return lst;
  }
  public static void main(String args[]){

      for(int i=1;i<=11;i++){
          adjlist.put(i,new Vertex(i));
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
          System.out.println(adjlist.get(i));
      }
      dfs(adjlist);
      List<Integer> oo= bfs(adjlist.get(1),adjlist.get(8));
      for(Integer k: oo){
          System.out.println("path" +k);
      }
  }

}
