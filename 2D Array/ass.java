import java.util.*;
public class ass{
    public static int counter(int arr[][], int key) {
    int count = 0;
    int row = 0;
    int column = arr[0].length - 1;
        while (row < arr.length && column >= 0) {
            if (arr[row][column] == key) {
                count++;
                column--;
                // row++;
            } else if (arr[row][column] > key) {
                column--;
            } else {
                row++;
            }
        }
        return count;
    }
    public static int secondRow(int arr[][]){
        int row=1;
        int sum=0;
        for(int i=0;i<arr[0].length;i++){
            sum+=arr[row][i];
        }
        return sum;
    }
    public static void transposeMat(int arr[][]){ // not for 2 x 3 matrix
        int trans[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                trans[j][i]=arr[i][j];
            }
        }
        printArr(trans);
    }

    public static void printArr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){

        int arr[][]={ {1,4,9},{11,4,3},{2,2,3} };
        int matrix[][]={
            {11,12,13},
            {21,22,23}
        };
        printArr(matrix);
        transposeMat(matrix);
        // printArr(arr);
        // System.out.print(counter(arr,7));
        // System.out.print(secondRow(arr));
    }
}