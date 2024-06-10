import java.util.*;
public class arr{
    public static void subArrSum(int arr[]){ //bruteforce approach
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            
            for(int j=i+1;j<=arr.length;j++){
                int sum=0;
                for(int k=i;k<j;k++){
                    sum+=arr[k];
                    if(sum>max){
                        max=sum;
                    }
                }
            } 
        }
        System.out.print("the maximum sub array sum is :"+ max); 
    }

    public static void subarrSum(int arr[]){
        int prefSum[] = new int[arr.length];
        int max=Integer.MIN_VALUE;
        int currentSum=0;
        prefSum[0]=arr[0];

        // calculating the prefix sum array ..
        for(int i=1;i<arr.length;i++){
            prefSum[i]=prefSum[i-1]+arr[i];
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                currentSum= i==0 ? prefSum[j] : prefSum[j]-prefSum[i-1]; 
                if(currentSum>max){
                    max=currentSum;
                }
            }
        }
        System.out.print("The maximum sub array sum is :"+ max);
    }

    public static void kadans(int arr[]){
        int max=Integer.MIN_VALUE;
        int cs=0;

        for(int i=0;i<arr.length;i++){
            cs+=arr[i];
            if(cs<0){
                cs=0;
            }
            max=Math.max(cs,max);
        }
        System.out.print("The maximun is :"+max);
    }

    public static void main(String args[]){
        
        int arr[]={1,-2,6,-1,3};
        kadans(arr);
    }
}