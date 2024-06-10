import java.util.*;
public class multiDimenArray{

    public static boolean search(int arr[][],int key){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    System.out.print("The element found at the index of :(" + i +","+j+")");
                    return true;
                }
            }  
        }
        return false;
    }
    public static void printArr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
   public static void spiral_Print(int arr[][]) {
    int sr = 0;
    int sc = 0;
    int er = arr.length - 1;
    int ec = arr[0].length - 1;

        while (sr <= er && sc <= ec) {
            // Print top row
            for (int j = sc; j <= ec; j++) {
                System.out.print(arr[sr][j] + " ");
            }
            sr++;

            // Print rightmost column
            for (int i = sr; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }
            ec--;

            // Print bottom row
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    System.out.print(arr[er][j] + " ");
                }
                er--;
            }

            // Print leftmost column
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    System.out.print(arr[i][sc] + " ");
                }
                sc++;
            }
        }
    }
    public static int dSum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==j){
                    sum+=arr[i][j];
                }else if(i+j==arr.length-1){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    public static void optDsum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-i-1){
                sum+=arr[i][arr.length-1-i];
            }
        }
        System.out.println(sum);
    }
    public static void rowWise(int arr[][],int key){ // O(nlogn)
        for(int i=0;i<arr.length;i++){
            int start=0;
            int end=arr.length-1;
            for(int j=0;j<arr[0].length;j++){
                int mid=(start+end)/2;
                
                if(arr[i][mid]==key){
                    System.out.print("the element found at index of ("+i+","+mid+")");
                    return;
                }else if(arr[i][mid]>key){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        System.out.print("The element is not present in this matrix");
    }
    public static void stairCaseRT(int arr[][],int key){ // O(n+m) taking right top element;
        int row=0, column=arr[0].length-1;
        while(row<arr.length && column>=0){
            if(arr[row][column]==key){
                System.out.print("The element is found at index of :("+row+","+column+")");
                return;
            }else if(arr[row][column]>key){
                column--;
            }else{
                row++;
            }
        }
        System.out.print("The element is not present in this matrix");
    }
    public static void stairCaseLB(int arr[][],int key){ // taking left bottom element'
        int row=arr.length-1,column=0;
        while(row>=0 && column<arr[0].length){
            if(arr[row][column]==key){
                System.out.print("The element is present at index of :("+row+","+column+")");
                return;
            }else if(arr[row][column]>key){
                row--;
            }else{
                column++;
            }
        }
        System.out.print("The element is not present");
    }
    // write a function to get the samllest and the largest element in multidimendional array 
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,15,16,17}
        };
        // int arr2[][]={
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9},
        // };
        // System.out.println(optDsum(arr));
        stairCaseLB(arr,8);
    }
    
}














        // int matrix[][]=new int[3][3];
        // int n=matrix.length , m=matrix[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         // System.out.print("Enter :");
        //         matrix[i][j]=sc.nextInt();
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // search(matrix,5);


