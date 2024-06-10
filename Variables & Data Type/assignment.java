import java.util.*;

public class assignment {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        // average of three numbers

        // System.out.print("Enter the number a :");
        // int a=sc.nextInt();
        // System.out.print("Enter the number b :");
        // int b=sc.nextInt();
        // System.out.print("Enter the number c :");
        // int c=sc.nextInt();

        // int avg=(a+b+c)/3;
        // System.out.println("The average of those numbers are :"+avg);


        // area of a square
        // System.out.print("Enter the number a :");
        // int a=sc.nextInt();
        // int square=a*a;
        // System.out.println("The square of this number is :"+square);


        // input of three products and total bill
        System.out.print("Enter the price of pen :");
        float pen=sc.nextFloat();
        System.out.print("Enter the price of pencil :");
        float pencil=sc.nextFloat();
        System.out.print("Enter the price of eraser :");
        float eraser=sc.nextFloat();

        float totalCoastWithoutgst=pen+pencil+eraser;
        float gstPercentage=(float)0.18;
        float gstbill=totalCoastWithoutgst*gstPercentage;
        float finalBill=gstbill+totalCoastWithoutgst;
        System.out.println("The total bill is :"+finalBill);





    }
}
