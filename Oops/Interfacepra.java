import java.util.*;
public class Interfacepra{
     public static String reverseStr(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<n;i +=2*k){
            int start=i;
            int end=Math.min(i + k - 1, n - 1);;
            while(start<end){
                char temp=sb.charAt(start);
                sb.setCharAt(start,sb.charAt(end));
                sb.setCharAt(end,temp);
                start++;
                end--;
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        // King k=new King();
        // k.moves();
        // String s = "abcdefg";
        // reverseStr(s,2);
        // System.out.println(reverseStr(s,2));
        Bear b=new Bear("Brown");
        b.bloodType();
        b.legs();
        System.out.println(b.color);
    }
    
}


// interface
interface Chess{
    void moves();
}
class Queen implements Chess{
    public void moves(){
        System.out.println("queens move");
    }
}
class King implements Chess{
    public void moves(){
        System.out.println("Kings move");
    }
}
class Rook implements Chess{
    public void moves(){
        System.out.println("Rooks move");
    }
}


// multiple inheritance
interface Herbivore {
    void bloodType();
}
interface Carnivore{
    void legs();
}
class Bear implements Herbivore,Carnivore{
    String color;
    Bear(String newclr){
        this.color=newclr;
    }
    public void bloodType(){
        System.out.println("Worm blooded");
    }
    
    public void legs(){
        System.out.println("4 legs");
    }
}