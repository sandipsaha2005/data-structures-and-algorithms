import java.util.*; 
public class Rec{
    public static void pri(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        pri(n-1);
    }
    public static void inc(int n){
        
        if(n==1){
            System.out.println(n);
            return;
        }
        inc(n-1);
        System.out.println(n);
    }
    public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr,i+1);
    }
    public static int firstOcc(int arr[],int key,int i){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            System.out.println("The element has been found");
            return i;
        }
        return firstOcc(arr,key,i+1);
    }
    public static int lastOcc(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOcc(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static int power(int x,int y){
        if(y==0){
            return 1;
        }else if(y==1){
            return x;
        }else{
            return x* power(x,y-1);
        }
    }
    public static int optPower(int x,int y){
        if(y==0){
            return 1;
        }
        int halfAns=optPower(x,y/2);
        int ans=halfAns * halfAns;
        if(y% 2 !=0){
            ans = x * ans;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int arr[]={1,4,3,4,9,5,6,5};

        // int n=sc.nextInt();
        // inc(n);
        System.out.println(optPower(2,20));
    }
}