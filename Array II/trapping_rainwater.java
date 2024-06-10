import java.util.*;  
public class trapping_rainwater{

    public static int trapped(int arr[],int n){
        int trappedW=0;
        int leftMx[]=new int[n];
        leftMx[0]=arr[0];
        for(int i=1;i<n;i++){
            leftMx[i]=Math.max(leftMx[i-1],arr[i]);
        }

        int rightMx[]=new int[n];
        rightMx[n-1]=arr[arr.length-1];
         for(int i=n-2;i>=0;i--){
            rightMx[i]=Math.max(arr[i],rightMx[i+1]);
        }

        for(int i=0;i<n;i++){
            int high=Math.min(leftMx[i],rightMx[i]);
            if(arr[i]<high){
                trappedW+=high-arr[i];
            }
        }

        return trappedW*1;
    }


    /*public static int maxWater(int[] arr, int n) 
    { 
  
        // To store the maximum water 
        // that can be stored 
        int res = 0; 
  
        // For every element of the array 
        // except first and last element 
        for (int i = 1; i < n - 1; i++) { 
  
            // Find maximum element on its left 
            int left = arr[i]; 
            for (int j = 0; j < i; j++) { 
                left = Math.max(left, arr[j]); 
            } 
  
            // Find maximum element on its right 
            int right = arr[i]; 
            for (int j = i + 1; j < n; j++) { 
                right = Math.max(right, arr[j]); 
            } 
  
            // Update maximum water value 
            res += Math.min(left, right) - arr[i]; 
        } 
        return res; 
    } */

    public static int stock(int arr[]){
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;    // take is as greater so that we can define the prices of those days

        for(int i=0;i<arr.length;i++){
            if(buyPrice<arr[i]){
                int profit=arr[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }else{
                buyPrice=arr[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]){
        // int arr[]={0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(trapped(arr,arr.length));
        int prices[]={7,1,5,3,6,4};
        // System.out.print(stock(prices));

    }
}