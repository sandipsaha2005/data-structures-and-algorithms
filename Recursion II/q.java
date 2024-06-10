import java.util.*;
public class q{
    public static int tiling(int n){
        if(n==0 || n==1){
            return 1;
        }
        int vertical=tiling(n-1);

        int horizontal=tiling(n-2);
        return vertical+horizontal;
    }
    public static String removeDuplicate(String str,int n,StringBuilder sb,boolean map[]){
        //base case
        if(n==str.length()){
            return sb.toString();
        }
        //to do
        char chrr=str.charAt(n);
        if(map[chrr-'a']==true){
            return removeDuplicate(str,n+1,sb,map);
        }else{
            map[chrr-'a']=true;
            sb.append(chrr);
            return removeDuplicate(str,n+1,sb,map);
        }
    }
    public static String removeDuplicateIte(String str){
        StringBuilder sb=new StringBuilder("");
        boolean map[]=new boolean[25];
        int n=0;
        while(n!=str.length()){
            char chrr=str.charAt(n);
            if(map[chrr-'a']==true){
                n++;
            }else{
                sb.append(chrr);
                map[chrr-'a']=true;
                n++;
            }
        }
        return sb.toString();
    }
    public static String findSmallestLexicographical(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    public static int friendsPairing(int n){
        if(n==1 || n==2){
            return n;
        }else{
            return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);
        }
    }
    public static void binStr(int n,int lst,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binStr(n-1,0,str+"0");
        if(lst==0){
            binStr(n-1,1,str+"1");
        }
    }
    public static void main(String args[]){
        // System.out.println(removeDuplicate("saaandip",0,new StringBuilder(""),new boolean[25]));
        // System.out.println(removeDuplicateIte("cbacdcbc"));
        // System.out.println(findSmallestLexicographical("cbad"));
        // System.out.println(friendsPairing(3));
        binStr(3,0,"");

    }
}