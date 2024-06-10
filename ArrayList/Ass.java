import java.util.*;
public class Ass{
    public static boolean isMono(ArrayList<Integer> arr){
        
        for(int i=0;i<arr.size()-1;i++){
            int j=i+1;
            if(arr.get(i)>arr.get(j)){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> lonely (ArrayList<Integer> arr){
        ArrayList<Integer> newArr=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            int check=1;
            int elem=arr.get(i);
            for(int j=i+1;j<arr.size();j++){
                if(elem==arr.get(j)){
                    check++;
                }
            }
            if(check==1){
                newArr.add(arr.get(i));
            }
        }
        return newArr;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(6);
        // System.out.print(isMono(list));
        System.out.print(lonely(list));
    }
}