import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphclass {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < v; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }
    public static void createGraph2(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < v; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

//        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        graph[2].add(new Edge(2,0,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));


    }
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) { // Check if the node has been visited before
                dfsUtil(graph, i, vis);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr +" ");
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if(!vis[graph[curr].get(i).dest]){
                dfsUtil(graph, graph[curr].get(i).dest,vis);
            }
        }
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean vis[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int curr= q.remove();
            if(!vis[curr]){
                System.out.print(curr +" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static boolean dfsForCycleDetection(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (dfsForCycleDetectionUtil(graph, visited, i, -1)) {
                    return true;
                    // returns true if any of the parts have a cycle
                }
            }
        }
        return false;

    }

    public static boolean dfsForCycleDetectionUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            // Here would be 3 cases
            if (!vis[graph[curr].get(i).dest]) {
                if( dfsForCycleDetectionUtil(graph, vis, graph[curr].get(i).dest, curr)){
                    return true;
                }

            } else if (vis[graph[curr].get(i).dest] && graph[curr].get(i).dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[]=new int[graph.length];
        for (int i=0;i<color.length;i++){
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while (!q.isEmpty()){
                    int curr= q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e=graph[curr].get(j);
                        if(color[e.dest]==-1){
                            int nextColor= color[curr] == 0 ? 1 : 0;
                            color[e.dest]=nextColor;
                            q.add(e.dest);
                        }else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,int vis[]){
//        System.out.print(curr +" ");
        vis[curr]=1;
        for (int i = 0; i < graph[curr].size(); i++) {
            if(vis[graph[curr].get(i).dest]==0){
                dfsUtil(graph, graph[curr].get(i).dest,vis);
            }
        }
    }
    public static int noOfProviences(ArrayList<Edge> graph[]){
        int vis[]=new int[graph.length];
        int count=0;
        for (int i = 0; i < graph.length; i++) {
            if(vis[i]==0){
                count++;
                dfsUtil(graph,i,vis);
            }
        }
        return count;
    }
    public static int emptySpot(int arr[]){
        int spot=0;
        for (int i = 0; i < arr.length; i+=2) {
            System.out.println(i);
            if(arr[i]==0){
                spot++;
            }
        }
        return spot;
    }

    public static void main(String[] args) {
        int v=7;
//        ArrayList<Edge> graph[]=new ArrayList[v];
//        createGraph(graph,v);
//        createGraph(graph,v);
//        dfs(graph);
//        bfs(graph);
//        System.out.println("The Number of Proviences the graph have is "+noOfProviences(graph));
//        while(true){
//            System.out.println(1);
//        }
        int arr[]={1,0,0,0,1};
        int arr2[]={1,0,0,0,1};
        System.out.println(emptySpot(arr));
    }
}
