import java.util.*;
public class sorting{
    public static void bbl(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void selection(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertion(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0  && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void counting(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);   // getting largest element of the array 
        }

        int bucket[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }


        int j=0;
        for(int i=0;i<bucket.length;i++){
            while(bucket[i]>0){
                arr[j]=i;
                j++;
                bucket[i]--;
            }
        }

    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[]={3,2,7,5,6,1};
        counting(arr);
        // Arrays.sort(arr);
        printArr(arr);
    }
}