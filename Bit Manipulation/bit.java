public class bit{
    public static void evenOdd(int n){
        int bitMask=1;
        if((n & bitMask)==0){
            System.out.print("The number is even !");
        }else{
            System.out.print("The number is not even !");
        }
    }
    public static void ith_bit(int n,int i){
        int bitMask=(1<<i);
        int final_val=(n&bitMask);
        if(final_val!=0){
            System.out.print("The ith bit is :"+1);
        }else{
            System.out.print("The ith bit is :"+0);
        }
    }
    public static int setIthBit(int n,int i){
        int bitMask=(1<<i);
        int final_val=(n | bitMask);
        return final_val;
    }

    public static int clearBit(int n,int i){
        int bitMask=1<<i;
        int final_val=(n ^ bitMask);
        return final_val;
    }
    public static int clearBitApna(int n,int i){
        int bitMask=~(1<<i);
        int final_val=(n & bitMask);
        return final_val;
    }
    public static int updatebit(int n,int i,int newBit){
        // if(newBit!=0){
        //     return setIthBit(n,i);
        // }else{
        //     return clearBit(n,i);
        // }

        // another approach

        n=clearBit(n,i);
        int bitMask=newBit<<i;
        return n | bitMask;
    }
    public static int clearLastIthBit(int n,int i){
        // int bitMask=((-1)<<i);
        int bitMask=~0<<i;
        return n & bitMask;
    }
    public static int clearRange(int n,int i,int j){
        int a=((~0)<<j+1);
        int b=(1<<i)-1;
        int bitMask=a | b;
        return n & bitMask;
    }
    public static int bitCounter(int n){
        int count=0;
        while(n>0){
            if((n & 1)!=0){
                count++;  
            }
            n=n>>1;
        }
        return count;
    }
    public static int power(int x,int y){
        int ans=1;
        while(y>0){
            if((y & 1)!=0){
                ans=ans*x;
            }
            x=x*x;
            y=y>>1;
        }
        return ans;
    }
    public static int myPow(int n,int m){
        int ans=1;
        while(n>0){
            if((m & 1)!=0){    // checking LSB 1 or 0;
                ans=ans*n;
            }
            n=n*n;
            m=m>>1;           
        }
        return ans;
    }
    public static void main(String args[]){


        // System.out.print(6>>2);
        // System.out.print(checkAna(n,m));
        // evenOdd(4);
        // ith_bit(10,2);
        // System.out.print(setIthBit(10,2));
        // System.out.print(updatebit(10,2,1));
        // System.out.print(bitCounter(10));
        System.out.print(myPow(2,10));
    }
}