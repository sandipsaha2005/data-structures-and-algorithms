import java.util.*;
public class string{
    public static void character(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
    public static boolean palindrome(String str){
        boolean res=true;
        // for(int i=0,j=str.length()-1;i<str.length();i++,j--){
        //     if(str.charAt(i)!=str.charAt(j)){
        //         res=false;
        //         return res;
        //     }
        // }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                res=false;
                return false;
            }
        }
        return res;
    }
    public static float getPath(String str){
        int x=0,y=0;
        for(int i=0;i<str.length();i++){
            char d=str.charAt(i);
            if(d=='N'){
                y++;
            }else if(d=='S'){
                y--;
            }else if(d=='w'){
                x--;
            }else if(d=='E'){
                x++;
            }else{
                System.out.print("Please enter right direction !");
            }
        }
        int xs=x*x;
        int ys=y*y;
        return (float)Math.sqrt(xs+ys);
    }
    public static String substr(String str,int si,int ei){
        String sub="";
        for(int i=si;i<ei;i++){
            sub+=str.charAt(i);
        }
        return sub;
    }
    public static String toUPP(String str){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String toUpperFirstChar(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == ' ' && i < str.length() - 1) {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String compression(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void rev(char a[]){
        StringBuilder sb=new StringBuilder("");
        
        for(int i=0;i<a.length();i++){
            
        }
        

    }
    public static void main(String args[]){
        char a[]={'a','b','c','d'};
        rev(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }





        Scanner sc=new Scanner(System.in);
        String str="sandip";
        String str2=new String("sandip");
        // String name=sc.next();
        // System.out.println(name);
        // System.out.print("Enter the whole sentence :");
        // String sentence=sc.nextLine();
        // System.out.println(sentence);
        // character(str);
        // System.out.print(palindrome(str));
        // String dir="WNEENESENNN";
        // System.out.print(getPath(dir));
        // System.out.print(substr(dir,0,3));


        // String fruits[]={"sandip","susnata","chayan","babu"};
        // String largest=fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //     if(largest.compareTo(fruits[i])<0){
        //         largest=fruits[i];
        //     }
        // }
        // System.out.print(largest);


        // StringBuilder sb=new StringBuilder("");
        // for(char ch='a';ch<='z';ch++){
        //     sb.append(ch);
        // }
        // System.out.print(sb);
        // String name="hey i am sandip saha from murshidabad";
        // System.out.print(toUpperFirstChar(name));




        // String comp="aaabbbcccdeeeef";
        // System.out.print(compression(comp));
    }
}