import java.util.*;

class Dqueue{
    static Stack<Integer> stk1=new Stack<>();
    static Stack<Integer> stk2=new Stack<>();
    public static boolean isEmpty(){
        return stk1.isEmpty();
    }
    public static void enQueue(int data){ // 0(n)
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }

        stk1.push(data);

        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
    }
    public static int deQueue(){  // 0(1)
        if(isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }
        return stk1.pop();
    }
    void display(){
        while (!stk1.isEmpty()){
            System.out.print(stk1.pop()+" ");
        }
        System.out.println();
    }
}

public class TowStk {
    public static void main(String args[]){
        Dqueue q=new Dqueue();
        q.enQueue(12);
        q.enQueue(23);
        q.enQueue(34);
        q.enQueue(45);
        q.enQueue(56);
        q.enQueue(67);
        q.enQueue(78);
        q.enQueue(89);
        q.deQueue();
        q.deQueue();
        q.display();


    }
}

