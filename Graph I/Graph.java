import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d, int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int v){
        for (int i = 0; i <v ; i++) {
            graph[i]=new ArrayList<>();
        }
        // vertex 0
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        // vertex 1
        graph[1].add(new Edge(1,3,1));
        graph[1].add(new Edge(1,0,1));
        // vertex 2
        graph[2].add(new Edge(2,4,1));
        graph[2].add(new Edge(2,0,1));
        // vetex 3
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        // vertex 4
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        // vertex 5
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }
    public static void bfs(ArrayList<Edge> graph[],int v){
        boolean arr[]=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int curr= q.remove();
            if(!arr[curr]){
                System.out.print(curr +" ");
                arr[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if(!vis[graph[curr].get(i).dest]){
                dfs(graph,graph[curr].get(i).dest,vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge> graph[],int src,int des,boolean vis[]){
        if(src==des){
            return true;
        }
        vis[src]=true;
        for (int i = 0; i < graph[src].size(); i++) {
            if(!vis[graph[src].get(i).dest] && hasPath(graph,graph[src].get(i).dest ,des,vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph,v);
//        bfs(graph,v);
//        dfs(graph,0,new boolean[v]);
        if(hasPath(graph,0,6,new boolean[v])){
            System.out.println("The given nodes are connected");
        }else{
            System.out.println("The given nodes are not connected");
        }

    }
}
