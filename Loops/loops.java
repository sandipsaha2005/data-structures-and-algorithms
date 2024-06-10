import java.util.*;

public class loops{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int count=1;
        int n=sc.nextInt();
        // int sum=0;
        // while(count<=n){
        //     // System.out.println("New");
        //     sum+=count;
        //     count++;
        // }
        // System.out.println("The sum is :"+sum);
        // for(int i=0;i<4;i++){
        //     System.out.println("* * * *");
        // }
        int rev_num=0;
        while(n!=0){
            int dig=n%10;
            rev_num=(rev_num*10)+dig;
            n/=10;
        }
        System.out.println(rev_num);

    }
}

