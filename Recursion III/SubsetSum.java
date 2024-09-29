import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {

    static void subsetSum(int arr[], int idx, ArrayList<Integer> li, int sum){
        if(idx==arr.length){
            li.add(sum);
            return;
        }
        subsetSum(arr,idx+1,li,sum+arr[idx]);
        subsetSum(arr,idx+1,li,sum);
    }
    public static void main(String[] args) {
        int arr[]={3,1,4};
        ArrayList<Integer> li=new ArrayList<>();
        li.toArray();
        System.out.println(li);
        ArrayList<Integer> list=new ArrayList<>();
        subsetSum(arr,0,list,0);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
