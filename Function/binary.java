public class binary{
    public static void binToDec(int n){
        int orgNum=n;
        int power=0;
        int dec=0;
        while(n>0){
            int lDig=n%10;
            dec=dec+(lDig * (int)Math.pow(2, power));
            n/=10;
            power++;
        }
        System.out.print("The binary of "+ orgNum +" is " + dec);
    }
    public static void decToBin(int n){
        int orgNum=n;
        int pow=0;
        int bin=0;
        while(n>0){
            int rem=n % 2;
            bin=bin + rem * (int)Math.pow(10,pow);
            pow++;
            n/=2;
        }
        System.out.print("The binary of "+ orgNum +" is " + bin);
    }

    public static void main(String args[]){
        int n=7;
        decToBin(n);
    }
}