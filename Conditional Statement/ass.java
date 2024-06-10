import java.util.*;

public class ass{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the year :");
        int n=sc.nextInt();
        if(n%4==0 && n%100!=0 || n%400==0){
            System.out.println("The year is a leap year !");
        }else{
            System.out.println("The year is not leap year !");
        }

        // if(n>=0){
        //     System.out.println("The number is a positive number !");
        // }else{
        //     System.out.println("The number is a negative number !");
        // }

    }
}
