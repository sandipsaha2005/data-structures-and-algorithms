import java.util.*;

public class prime{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number :");
        int num=sc.nextInt();
        
        if(num<=1){
            System.out.println("The number is not a prime number !");
            
        }else{
            boolean isPrime=true;
            for(int i=2;i<=Math.sqrt(num);i++){ //(int)(num/2)+1
                if(num%i==0){
                    isPrime=false;
                }
                
            }
            if(isPrime){
                System.out.println("The number is a prime number !");
            }else{
                System.out.println("The number is not a prime number !");
            }
        }


        
        
    }
}
