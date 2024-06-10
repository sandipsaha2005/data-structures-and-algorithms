
import java.util.*;

import static java.lang.Math.pow;

public class Assigmnet {
    public static int DecToBin(int n){
        int p=0;
        int bin=0;
        while (n>0){
            int lastDig=n%2;
            bin += lastDig * Math.pow(10, p);
            n/=2;
            p++;
        }
        return bin;
    }
    public static void revQueue(Queue<Integer> q,int k){
        Stack<Integer> s=new Stack<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<k;i++){
            s.push(q.remove());
        }
        while (!q.isEmpty()){
            q2.add(q.remove());
        }
        while (!s.isEmpty()){
            q.add(s.pop());
        }
        while (!q2.isEmpty()){
            q.add(q2.remove());
        }

    }
    public static void getBinary(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(DecToBin(i) + " ");
        }
    }

    public static void main(String args[]){
        int n=5;
//        System.out.println(DecToBin(n));
//        getBinary(n);
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        revQueue(q,n);
        for(Integer item:q){
            System.out.print(item + " ");
        }
    }

}

class Job{
    char job_id;
    int deadline;
    int profit;
    Job(char ji,int d,int p){
        this.job_id=ji;
        this.deadline=d;
        this.profit=p;
    }
}



