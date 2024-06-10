import java.util.*;
public class Pra{
    public static void quickSort(int arr[],int si,int ei){
        if(si>ei){
            return;
        }
        int pivotIdx=part(arr,si,ei);
        quickSort(arr,si,pivotIdx-1);
        quickSort(arr,pivotIdx+1,ei);
    }
    public static int part(int arr[],int si,int ei){
        int i=-1;
        int p=arr[ei];
        int j=0;
        for(j=0;j<ei;j++){
            if(arr[j]<p){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=p;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int frequ(int arr[]){  // bruteforce approach
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }
    public static int moores(int arr[]){   // using moore's voting algorithm
        int elem=arr[0];
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                count=1;
                elem=arr[i];
            }else if(elem==arr[i]){
                count++;
            }else{
                count--;
            }
        }
        int freq=0;
        for(int i=0;i<arr.length;i++){
            if(elem==arr[i]){
                freq++;
            }
        }
        if(freq>arr.length/2){
            return elem;
        }
        return -1;
    }
    public static void moveZeroes(int[] nums) {
        int arr[]=new int[nums.length+1];
        int i=0;
        int j=0;
        while(i<nums.length){
            if(nums[i]!=0){
                arr[j]=nums[i];
                j++;
            }
            i++;
        }
        for(i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
    public static int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1))/2;
        for(int i = 0; i < nums.length; i++) {
            sum-=nums[i];
        }
        return sum;
    }
    public static void main(String args[]){
        // int arr[]={4 3 8 4 6 5};
        int arr[]={0,2,3};
        System.out.print(missingNumber(arr));
        // moveZeroes(arr);
        // int arr2[]={3,3,4};
        // quickSort(arr,0,arr.length-1);
        // printArr(arr);
        // System.out.print(moores(arr2));
        // frequ(arr2);
    }
}