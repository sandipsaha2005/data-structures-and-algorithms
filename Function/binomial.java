import java.util.*;

public class binomial {
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static int bino(int n, int r) {
        int ans = fact(n) / (fact(r) * fact(n - r));
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            boolean prime = true; 
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
            return prime; 
        }
    }

    public static void printPrimes(int range) {
        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Uncomment the following lines if you want to use the binomial function
        // System.out.print("Enter the first number :");
        // int n = sc.nextInt();
        // System.out.print("Enter the second number :");
        // int r = sc.nextInt();
        // int ans = bino(n, r);
        // System.out.println("The answer is: " + ans);

        System.out.print("Enter the range :");
        int range = sc.nextInt();
        printPrimes(range);
    }
}
