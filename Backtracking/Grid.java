public class Grid{
    // public static void mergeArr(int arr1[],int arr2[]){
    //     int len1=arr1.length;
    //     int len2=arr2.length;
    //     int arr[]=new int[len1+len2];
    //     int i=0;
    //     int j=0;
    //     int k=0;
    //     for(i=0,j=0, k=0;i<len1 &&j<len2;k++){
    //         if(arr1[i]>arr2[j]){
    //             arr[k]=arr2[j];
    //             j++;
    //         }else{
    //             arr[k]=arr1[i];
    //             i++;
    //         }
    //     }
    //     while(i<len1){
    //         arr[k]=arr1[i];
    //         i++;
    //         k++;
    //     }
    //     while(j<len2){
    //         arr[k]=arr2[j];
    //         k++;
    //         j++;
    //     }
    //     printArr(arr);
    // }
    public static int uniqueWays(int i,int j,int row,int column){
        if(i==row-1 && j==column-1){
            return 1;
        }else if(i==row || j==column){
            return 0;
        }

        int fir=uniqueWays(i+1,j,row,column);
        int sec=uniqueWays(i,j+1,row,column);
        return fir+sec;
    }
    // public static int iteWays(int row,int column){
    //     uniqueWays();
    // }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int fact(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res = res * i;
        }
        return res;
    }
    public static int linGrid(int m,int n){
        int no=fact(m + n-2);
        int mu=fact(n-1) * fact(m-1);
        int res=no/mu;
        return res;
    }
    public static void rotateNine(int arr[][]){
        int n=arr.length-1;
        int newarr[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                newarr[j][n-i]=arr[i][j];
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=newarr[i][j];
            }
        }
    }
    public static void main(String args[]){
        int n=10;int m=10;
        // int way=uniqueWays(0,0,n,m);
        // System.out.print(way);
        int arr[][]={
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        rotateNine(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        // System.out.println(linGrid(n,m));
        
    }
}