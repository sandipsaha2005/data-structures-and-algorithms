import java.util.*;
public class ass{
    public static int average(int x,int y,int z){
        int avg=(x+y+z)/3;
        return avg;
    }

    public static void palindrome(int x){
        int org=x;
        int rev_num=0;
        while(x>0){
            int dig=x%10;
            rev_num=(rev_num*10)+dig;
            x/=10;
        }
        System.out.println("The reversed number is :"+rev_num);
        if(org==rev_num){
            System.out.println("The number is palindrome !");
        }else{
            System.out.println("The number is not a palindrome !");
        }
    }

    public static void sumOfDig(int x){
        int sum=0;
        while(x>0){
            int dig=x%10;
            sum+=dig;
            x/=10;
        }
        System.out.print("The sum is :" +sum);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        // int a=24;
        // int b=23;
        // int c=25;
        // int avg=average(a,b,c);
        // System.out.println("The average of those numbers is "+ avg);

        System.out.print("Enter the number :");
        int num=sc.nextInt();
        sumOfDig(num);

    }
}