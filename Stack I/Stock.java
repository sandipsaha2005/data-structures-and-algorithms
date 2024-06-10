import java.util.*;
public class Stock {
    public static void stockSpanner(int price[],int span[]){
        Stack<Integer> stk=new Stack<>();
        span[0]=1;
        stk.push(0);
        for (int i = 1; i < price.length; i++) {
            int curr=price[i];
            while (!stk.isEmpty() && curr>price[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                span[i]=i+1;
            }else {
                int prevHigh=stk.peek();
                span[i]=i-prevHigh;
            }
            stk.push(i);
        }
    }
    public static int[] nextGtr(int arr[]){ // 6 8 0 1 3   // brute force
        int arr2[]=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int curr=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>curr){

                    arr2[i]=arr[j];
                    break;
                }else {
                    arr2[i]=-1;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] +" ");
        }
        return arr2;
    }
    public static void main(String args[]){
//        int st[]={100,80,60,70,60,85,100};
//        int span[]=new int[st.length];
//        stockSpanner(st,span);
//        for (int i = 0; i < span.length; i++) {
//            System.out.print(span[i]+" ");
//        }
        int arr[]={6,8,0,1,3};
        nextGtr(arr);

    }
}
