import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Basicgraph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < v; i++) {
            graph[i]=new ArrayList<>();
        }
        // 0 th vertex
        graph[0].add(new Edge(0,1,1));
        // 1 th vertex
        graph[1].add(new Edge(1,0,2));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,1));

        // 2 th vetex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,1));

        // 3 th vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,2,1));

        // 4 th vertex
        graph[4].add(new Edge(4,2,1));
    }
    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()){
            int curr=q.remove();

            if(!vis[curr]){
                System.out.print(curr +" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest); // adding all the neighbour of that vertex;
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr, boolean vis[]){
        System.out.print(curr +" ");
        vis[curr]=true;
        for (int i = 0; i <graph[curr].size() ; i++) {
            if(!vis[graph[curr].get(i).dest]){
                dfs(graph,graph[curr].get(i).dest,vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src]=true;
        for (int i = 0; i < graph[src].size(); i++) {
            if(!vis[graph[src].get(i).dest] && hasPath(graph,graph[src].get(i).dest,dest,vis )){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];


//        for (int i = 0; i < graph[2].size(); i++) {
//            Edge e= graph[2].get(i);
//            System.out.println(e.src+"->"+e.dest);
//        }
//        boolean visited[]=new boolean[v];
        createGraph(graph,v);
//        bfs(graph);
//        dfs(graph,0,new boolean[v]);

        System.out.println( hasPath(graph, 1,0,new boolean[v]));
    }
}
