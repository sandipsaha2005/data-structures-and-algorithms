import java.util.*;
public class ass{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        // int oddSum=0;
        // int evenSum=0;
        // int choice;
        // do{
        //     System.out.print("Enter the number :");
        //     int num=sc.nextInt();

        //     if(num % 2==0){
        //         evenSum+=num;
        //     }else{
        //         oddSum+=num;
        //     }
        //     System.out.print("Enter 1 to continue and 0 to stop :");
        //     choice=sc.nextInt();

        // }while(choice==1);

        // System.out.println("The summetion of even numbers is :" + evenSum);
        // System.out.println("The summetion of odd numbers is :" + oddSum);
        // System.out.print("Enter the number :");
        // int num=sc.nextInt();

        // factorial

        // int fact=1;
        // for(int i=1;i<=num;i++){   
        //     fact*=i;
        // }

        // System.out.print(fact);

        // multiplication table

        // for(int i=1;i<=10;i++){
        //     System.out.println(num * i);
        // }

        for(int i=1;i<=5;i++){
            for(int j=1;j<i;j++){
                System.out.print(" * ");
            }
            System.out.print("\n");
        }

    }
}

