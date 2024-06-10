import java.util.*;
import java.util.Queue;

public class JCFQueue {
    public static void rev(int arr[]){
        int n=arr.length;
        for (int i = 0; i < arr.length/2; i++) {
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
    }
    public static void main(String args[]){
//        Queue<Integer> q=new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        System.out.print('[');
//        while(!q.isEmpty()){
//            System.out.print(q.peek()+" ");
//            q.remove();
//        }
//        System.out.println(']');
        int arr[]={1,2,3};
        rev(arr);
//        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}

