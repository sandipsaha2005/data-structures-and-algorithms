import java.util.*;
public class Assigment {
    public static int splitString(String str){
        int count=0;
        int balance=0;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch=='L'){
                balance++;
            }else{
                balance--;
            }

            if(balance==0){
                count++;
            }
        }
        return count;
    }
    public static boolean isEven(int n){
        return n%2==0;
    }
    public static void kthOdd(int l,int r,int k){
        int sr=l;
        int er=r;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = sr; i < er; i++) {
            if(!isEven(i)){
                list.add(i);
            }
        }

        

    }
    public static void main(String args[]){
//        String str="RLRRLLRLRL";
//        System.out.println(splitString(str));
        int L = -10, R = 10, K = 8;
//        int L = -3, R = 3, K = 1;
        kthOdd(L, R,K);
    }
}
