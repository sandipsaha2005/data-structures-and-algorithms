import java.util.*;

public class DivCon{
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j <=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void quickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pivot=part(arr,si , ei);
        quickSort(arr,si,pivot-1);
        quickSort(arr,pivot+1,ei);
    }
    public static int part(int arr[],int si,int ei){
        int i=si-1;
        int j=si;
        int pivot=arr[ei];
        while(j<ei){
            if(arr[j]<pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp; 
            }
            j++;
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static int rotaArr(int arr[],int si,int ei,int target){
        int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }else if (arr[si]<arr[mid]){ // you are in line 2
            if(arr[si]<=target && target<=arr[mid]){
                return rotaArr(arr,si,mid,target);
            }else{
                return rotaArr(arr,mid+1,ei,target);
            }

        }else{ // you are in line 1
            if(arr[mid]<=target && target<=arr[ei]){
                return rotaArr(arr,mid+1,ei,target);
            }else{
                return rotaArr(arr,si,mid,target);
            }
        }
        
    }
    public static int ite(int arr[],int target){
        /// write the code in iterator for leetcode;
    }
    public static void main(String args[]){
        int arr[]={4,5,6,7,0,1,2,3};
        System.out.print(rotaArr(arr,0,arr.length-1,3));
        // quickSort(arr,0,arr.length-1);
        // printArr(arr);
    }
}
