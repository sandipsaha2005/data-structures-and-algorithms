import java.util.*;    
import java.util.Arrays;    
public class ass{
    public static int countVow(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }
    public static boolean checkAna(String str1,String str2){
        if(str1.length()!=str2.length()){
            System.out.print("The strings are not anagram");
            return false;
        }else{
            int n=str1.length();
            int count=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(str1.charAt(i)==str2.charAt(j)){
                        count++;
                    }
                }
            }
            // System.out.println(count);
            if(count==n){
                return true;
            }else{
                System.out.println("The strings are not anagram");
                return false;
            }
        }
    }
    public static void chekcAnagram(String str1,String str2){
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        if(str1.length()==str2.length()){
            char str1Arr[]=str1.toCharArray();
            char str2Arr[]=str2.toCharArray();
            Arrays.sort(str1Arr);
            Arrays.sort(str2Arr);
            if(Arrays.equals(str2Arr,str1Arr)){
                System.out.print("The strings are anagram");
            }else{
                System.out.print("The strings are not anagram");
            }
        }
    }
    public static boolean anagramL(String str1,String str2){
        int f1[]=new int[26];

        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            f1[Character.toLowerCase(ch)-97]++;
        }

        int f2[]=new int[26];

        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            f2[Character.toLowerCase(ch)-97]++;
        }

        if(Arrays.equals(f1,f2)){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // String str=sc.next();
        // System.out.print(str);
        String n="Agentleman";
        String m="elegantman";
        // chekcAnagram(n,m);
        System.out.print(anagramL(n,m));

    }
}