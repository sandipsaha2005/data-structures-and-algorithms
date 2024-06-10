import java.util.*;
public class ass{

    public static int check(int arr[]){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]==arr[i]){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int stockSellBuy(int arr[]){
        int maxprofit=0;
        int buyPrice=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(buyPrice<arr[i]){
                int profit=arr[i]-buyPrice;
                maxprofit=Math.max(maxprofit,profit);  //7, 1, 5, 3, 6,  4
            }else{
                buyPrice=arr[i];
            }
        }

        return maxprofit;
    }

    public static int trappedRainWater(int arr[]){
        int trapped=0;
        int n=arr.length;
        int leftMx[]=new int[n];
        int rightMx[]=new int[n];

        leftMx[0]=arr[0];
        for(int i=1;i<n;i++){
            if (leftMx[i-1] < arr[i]) {
                leftMx[i] = arr[i];
            }else{
                leftMx[i]=leftMx[i-1];
            }
        }
        rightMx[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(rightMx[i+1]<arr[i]){
                rightMx[i]=arr[i];
            }else{
                rightMx[i]=rightMx[i+1];
            }
        }

        for(int i=0;i<n;i++){
            int minv=Math.min(rightMx[i],leftMx[i]);
            trapped+=(minv-arr[i])*1;
        }
        return trapped;
    }

    public static void printf(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int nums[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(trappedRainWater(nums));
        int nums1[] = {1, 2, 3, 4};
        int nums2[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        // System.out.print(check(nums2));
        // for(int i=0;i<nums.length;i++){
        //     System.out.print(nums[i]+" ");
        // }
        // System.out.println(check(nums1));
        // System.out.println(check(nums2));

        // int prices[] = {7, 6, 4,  3, 1};
        // System.out.print(stockSellBuy(prices));
    }
}