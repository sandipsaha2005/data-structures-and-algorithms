import java.util.*;
public class conditional{
    public static void main(String args[] ){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your income :");
        int a=sc.nextInt();
        if(a<500000){
            System.out.println("You don't have to pay any kind of tax to government !");
        }else if(a>=500000 && a<1000000){
            int tax= (int) (a*0.2);
            System.out.println("Your tax amount is :"+ tax);
        }else{
            int tax=(int) (a*0.3);
            System.out.println("You tax amount is :"+ tax);
        }





        // System.out.print("Enter the number :");
        // int b=sc.nextInt();
        // if(a>b){
        //     System.out.println("A is the largest value !");
        // }else{
        //     System.out.println("B is the largest value !");
        // }
        // if(a>=18){
        //     System.out.println("You can drive you can vote !");
        // }else{
        //     System.out.println("You are under age !");
        // }






    }
}

