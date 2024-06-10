import java.util.ArrayList;
public class Arraylist{
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        //add
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        // System.out.print(list);

        // get
        // System.out.print(list.get(2));

        // delete
        // list.remove(2);

        // set
        // list.set(2,10);

        // contains

        // System.out.print(list.contains(2));

        // size
        // System.out.print(list.size());
        System.out.println(list);
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }
}