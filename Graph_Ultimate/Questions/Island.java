import java.util.Arrays;

public class Island {
    public static void dfs(int graph[][],boolean vis[][],int i,int j){
        vis[i][j]=true;


    }
    public static void main(String[] args) {
        int arr[][]={
                {0,1,1,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {1,1,0,1}
        };

        int max=0;
        int finalMax=max;
        int subarr[]={1,2,3,3,2,2};
        for (int i = 0; i < subarr.length; i++) {
            for (int j = 0; j < subarr.length; j++) {
//                int res=subarr[i];
//                System.out.print(subarr[i]);
                for (int k = i; k<j; k++) {

//                    res= res & subarr[k] ;
                    System.out.print(subarr[k]+",");
                }

//                System.out.println("The and is "+res);
                System.out.println();
//                finalMax=Math.max(max,res);
//                if(res==finalMax){
//                    System.out.println("Final"+res);
//                }
            }
        }


//        boolean vis[][]=new boolean[arr.length][arr[0].length];
//        for (int i = 0; i < vis.length; i++) {
//            for (int j = 0; j < vis[0].length; j++) {
//                vis[i][j]=false;
//            }
//        }
//
//        int count=0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if(!vis[i][j]){
//                    dfs(arr,vis,i,j);
//                    count++;
//                }
//            }
//        }
        
    }
}
