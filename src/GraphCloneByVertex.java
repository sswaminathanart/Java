import java.util.*;

public class GraphCloneByVertex {
   class GraphNode{
       int val;
       Set<GraphNode> neighbours;
       GraphNode(int v){
           val =v;
           neighbours = new HashSet<>();
       }
       @Override
       public String toString(){
           String str =val + "--> [" ;
           int i=1;
           for(GraphNode v : neighbours){
               if(i!= neighbours.size())
                   str += v.val +",";
               else str += v.val;
               i++;
           }
           str += "]";
           return str;
       }
   }
    public GraphNode buildGraph()
    {
        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        Set<GraphNode> v = new HashSet<>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new HashSet<>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new HashSet<>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new HashSet<>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }
    public void bfs(GraphNode source)
    {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);
        HashMap<GraphNode,Boolean> visit =
                new HashMap<GraphNode,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null)
            {
                Set<GraphNode> v = u.neighbours;
                for (GraphNode g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }
    public GraphNode cloneGraph(GraphNode source){
       Queue<GraphNode> queue = new LinkedList<>();
       Map<GraphNode,GraphNode> graphNodeMap = new HashMap<>();
       ((LinkedList<GraphNode>) queue).add(source);
       graphNodeMap.put(source,new GraphNode(source.val));
       while (!queue.isEmpty()){
           GraphNode curr = queue.poll();
           GraphNode currClone = graphNodeMap.get(curr);
           if(curr.neighbours != null){
               for(GraphNode nei : curr.neighbours){
                   GraphNode neiclon =graphNodeMap.get(nei);
                   if(neiclon == null){
                       queue.add(nei);
                       neiclon = new GraphNode(nei.val);
                       graphNodeMap.put(nei,neiclon);
                   }
                   currClone.neighbours.add(neiclon);
               }
           }
       }
       return graphNodeMap.get(source);
    }

    public GraphNode cloneTheGraph(GraphNode source) {
        Set<GraphNode> seen = new HashSet<>();
        GraphNode sourceclone = new GraphNode(source.val);
        sourceclone.neighbours.add(cloneTheVertex(source, seen));
        return sourceclone;

    }

    public GraphNode cloneTheVertex(GraphNode v, Set<GraphNode> seen) {
        if (seen.contains(v)) return v;
        GraphNode vertex = new GraphNode(v.val);
        seen.add(v);
        for (GraphNode nei : v.neighbours) {
            vertex.neighbours.add(cloneTheVertex(nei, seen));
        }
        return vertex;
    }
    public static void main(String args[])
    {
        GraphCloneByVertex graph = new GraphCloneByVertex();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        GraphNode newSource = graph.cloneTheGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}
