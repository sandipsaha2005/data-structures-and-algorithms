import java.util.*;
public class switch_case{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number :");
        int a=sc.nextInt();
        System.out.print("Enter the number :");
        int b=sc.nextInt();
        System.out.print("Enter the opertor :");
        char opt=sc.next().charAt(0);


        switch(opt){
            case '+': System.out.println(a+b);
            break;
            case '-': System.out.println(a-b);
            break;
            case '*': System.out.println(a*b);
            break;
            case '/': System.out.println(a/b);
            break;
            default: System.out.println("undefined");
        }
    }
}

