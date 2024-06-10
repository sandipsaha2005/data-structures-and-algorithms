public class Backt{
    public static void updtArr(int arr[],int i,int val){
        if(i==5){
            printArr(arr);
            return;
        }
        arr[i]=val;
        updtArr(arr,i+1,val+1);
        arr[i]=arr[i]-2; // backtracking
    }
    public static void subsets(String str,int i,String ans){  // using string.
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        
        // for yes
        subsets(str,i+1,ans+str.charAt(i));
        // for no
        subsets(str,i+1,ans);
    }

    public static void subsetsSb(String str,int i, StringBuilder ans){  // using string builder.
        if(i==str.length()){
            System.out.print(ans.toString()+" ");
            return;
        }
        
        subsetsSb(str,i+1,ans.append(str.charAt(i)));
        ans.deleteCharAt(ans.length()-1);
        subsetsSb(str,i+1,ans);
    }
    public static void permutation(String str,StringBuilder perm){  // using string builder
        if(str.length()==0){
            System.out.print(perm.toString() +" ");
            return;
        }
        // first elem at first
        for(int i=0;i<str.length();i++){
            StringBuilder nperm=new StringBuilder(perm);
            char ch=str.charAt(i);
            nperm.append(ch);
            String nstr=str.substring(0,i)+str.substring(i+1);                // i want charAt(i) out from this string   str.deleteCharAt(i); this is for string builder
            permutation(nstr,nperm);
        }
    }
    public static String permutationStr(String str,String perm){
        if(str.length()==0){
            // System.out.print(perm+' ');
            return perm +" ";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            sb.append(permutationStr(newStr,perm+ch));   // storin all permutaions in a single string builder.
        }
        return sb.toString();
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void main(String args[]){
        int arr[]=new int[5];
        // updtArr(arr,0,1);

        // subsetsSb("abc",0,new StringBuilder());
        // permutation("abc",new StringBuilder());
        System.out.println(permutationStr("abc",""));
        // System.out.println();
        // printArr(arr);
    }
}