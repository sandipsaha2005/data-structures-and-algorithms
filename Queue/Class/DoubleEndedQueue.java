import java.util.Deque;
import java.util.LinkedList;


class StackUsingDeque{
    static Deque<Integer> dq=new LinkedList<>();

    public void push(int data){
        dq.addLast(data);
    }
    public int pop(){
        return dq.removeLast();
    }
    public int peek(){
        return dq.getLast();
    }

}
class QueueUisngDeqeu{
    static Deque<Integer> dq=new LinkedList<>();
    public void add(int data){
        dq.addLast(data);
    }
    public int remove(){
        return dq.removeFirst();
    }
    public int peek(){
        return dq.getFirst();
    }
}

public class DoubleEndedQueue {

    public static void main(String args[]){
//        Deque<Integer> dq=new LinkedList<>();
//        dq.addFirst(1);
//        dq.add(3);
//        dq.add(4);
//        dq.addLast(2);
//        dq.removeFirst();
//        dq.removeLast();
//        System.out.println(dq);


        // StackUsingDeque sd=new StackUsingDeque();
        // sd.push(12);
        // sd.push(2);
        // sd.push(3);
        // System.out.println(sd.pop());
        // System.out.println(sd.peek());

        QueueUisngDeqeu qd=new QueueUisngDeqeu();
        qd.add(1);
        qd.add(2);
        qd.add(3);
        System.out.println(qd.remove());
        System.out.println(qd.peek());
    }
}
