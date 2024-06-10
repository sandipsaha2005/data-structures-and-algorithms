import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class MultiDimen{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(13);
        list1.add(9);
        list1.add(11);
        list1.add(7);
        list1.add(15);
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        list2.add(12);
        list2.add(14);

        list.add(list1);
        list.add(list2);
        // System.out.println(list);

        ArrayList<Integer> currList=list.get(0);
        currList.add(1);
        currList.set(3,15);
        Collections.sort(currList);

        ArrayList<Integer> newList=new ArrayList<>();
        for(int i=0;i<10;i++){
            System.out.print("Enter the number :");
            int num=sc.nextInt();
            newList.add(num);
        }
        System.out.print(newList);
        // System.out.print(currList);
        // for(int i=0;i<list.size();i++){
        //     ArrayList<Integer> currList=list.get(i);
        //     for(int j=0;j<currList.size();j++){
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.out.println();
        // }


    }
}