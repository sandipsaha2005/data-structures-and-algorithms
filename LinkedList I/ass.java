import java.util.*;
public class ass{
    public static boolean ispa(ArrayList<Integer> list){
        int s=0;
        int l=list.size()-1;
        while(s<=l){
            if(list.get(s)!=list.get(l)){
                return false;
            }
            s++;
            l--;
        }
        return true;
    }
    

public static void main(String args[]){
        ArrayList<Integer> mylist=new ArrayList<>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(3);
        mylist.add(2);
        mylist.add(1);
        mylist.add(2);
        System.out.println(ispa(mylist));

    }
}