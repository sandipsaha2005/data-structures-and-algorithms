import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Provinces {
    public static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

        graph[7].add(new Edge(7,8));
        graph[7].add(new Edge(7,9));

        graph[8].add(new Edge(8,7));
        graph[8].add(new Edge(8,9));

        graph[9].add(new Edge(9,7));
        graph[9].add(new Edge(9,8));
    }
    public static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr){
//        System.out.println(curr);
        vis[curr]=true;
        for (Edge e: graph[curr]) {
            int currItem=e.dest;
            if(!vis[currItem]){
                dfs(graph,vis,currItem);
            }
        }
    }

    public static int noOfProvinces(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        int count=0;
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                System.out.println(i);
                dfs(graph,vis,i);
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int n=10;
        ArrayList<Edge> arr[]=new ArrayList[n];
        createGraph(arr);
        boolean visArr[]=new boolean[100];
        System.out.println("The number of Provinces are :"+noOfProvinces(arr));
//        dfs(arr,visArr,0);
    }
}
