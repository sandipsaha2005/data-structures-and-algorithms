import java.util.*;
public class Graph {
    static class Edge{
        int src;
        int dest;
        int w;
        Edge(int src,int dest,int w){
            this.src=src;
            this.dest=dest;
            this.w=w;
        }
    }
    public static void createGraph (ArrayList<Edge> arr[],int len){
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new ArrayList<>();
        }
        // for vertex 0
        arr[0].add(new Edge(0,1,4));

        arr[1].add(new Edge(1,2,4));
        arr[1].add(new Edge(1,0,4));

    }
    public static void BFS(ArrayList<Edge> Graph[]){
        int v=Graph.length;
//        System.out.println(v);
        Boolean vis[]=new Boolean[v];
        for (int i = 0; i < vis.length; i++) {
            vis[i]=false;
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(0); //0
        while(!q.isEmpty()){
            int currItem=q.remove();// 0
            if(!vis[currItem]){
                System.out.print(currItem+"->");
                vis[currItem]=true;
                for (int i = 0; i < Graph[currItem].size(); i++) {
                    // Edge e=Graph[currItem].get(i)
                    q.add(Graph[currItem].get(i).dest);
                }
            }
        }
    }
    public static void DFS(ArrayList<Edge> Graph[]){
        Stack<Integer> stk=new Stack<>();
        boolean vis[]=new boolean[Graph.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i]=false;
        }
        stk.add(0);
        while (!stk.isEmpty()){
            int curr=stk.pop();
            if(!vis[curr]){
                System.out.print(curr + "->");
                vis[curr]=true;
                for (int i=0;i<Graph[curr].size();i++){
                    stk.add(Graph[curr].get(i).dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> Graph[],int curr,boolean vis[]){
        System.out.print(curr +"->");
        vis[curr]=true;
        for (Edge edge: Graph[curr]){
            if(!vis[edge.dest]){
                dfs(Graph, edge.dest,vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge> Graph[],int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for (int i = 0; i < Graph[src].size(); i++) {
            if(!vis[Graph[src].get(i).dest] && hasPath(Graph,Graph[src].get(i).dest, dest,vis)){
                return true;
            }
        }
        return false;
    }
    public static boolean hasPathToThatNode(ArrayList<Edge> Graph[],int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for (int i = 0; i < Graph[src].size(); i++) {
            if (!vis[Graph[src].get(i).dest] && hasPathToThatNode(Graph,Graph[src].get(i).dest,dest,vis)){
                return true;
            }
        }
        return false;
    }
    public static void bfsUtil(ArrayList<Edge> Graph[],boolean vis[]){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int curr=queue.remove();
            if(!vis[curr]){
                System.out.println(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < Graph[curr].size(); i++) {
                    queue.add(Graph[curr].get(i).dest);
                }
            }
        }
    };
    public static void bfsForDisconnectedGraph(ArrayList<Edge> Graph[]){
        boolean vis[]=new boolean[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if(!vis[i]){
                bfsUtil(Graph,vis);
            }
        }
    };
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        vis[curr]=true;
        for (Edge e:graph[curr]){
            int currItem=e.dest;

            if(!vis[currItem]  ){
                if(detectCycleUtil(graph,vis,currItem,curr)){
                    System.out.println("filan fir");
                    return true;
                }

            }
            else if(vis[currItem] && currItem != parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> arr[]=new ArrayList[v];
        Edge data[]={new Edge(0, 1, 5), new Edge(0, 1, 5),new Edge(1, 2, 1),new Edge(1, 3, 3),new Edge(2, 1, 1),new Edge(2, 3, 1),new Edge(2, 4, 2),new Edge(3, 1, 3),new Edge(3, 2, 1)};
        createGraph(arr,v);
        boolean vis[]=new boolean[v];
        for (int i = 0; i < vis.length; i++) {
            vis[i]=false;
        }
//        if(hasPathToThatNode(arr,0,10,vis)){
//            System.out.println();
//        }else{
//            System.out.println("No thre is not path exitst");
//        }
        if(detectCycle(arr)){
            System.out.println("There is cycle in this Graph");
        }else{
            System.out.println("There is no cycle present in this Graph");
        }
//        BFS(arr);
//        System.out.println();
//        dfs(arr,0,vis);

//        System.out.println( hasPath(arr,0,4,vis));
    }

}