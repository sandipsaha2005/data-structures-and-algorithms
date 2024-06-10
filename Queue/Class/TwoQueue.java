import java.util.LinkedList;
import java.util.Queue;

class TQS{
    static Queue<Integer> q1=new LinkedList<>();
    static Queue<Integer> q2=new LinkedList<>();
    public static boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }
    public static void push(int data){
        if(!q1.isEmpty()){
            q1.add(data);
        }else{
            q2.add(data);
        }
    }
    public static int pop(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }
        int top=-1;
        if(!q1.isEmpty()){
            while (!q1.isEmpty()){
                top=q1.remove();
                if(q1.isEmpty()){
                    break;
                }else{
                    q2.add(top);
                }
            }
        }else {
            while (!q2.isEmpty()){
                top=q2.remove();
                if(q2.isEmpty()){
                    break;
                }else {
                    q1.add(top);
                }
            }
        }
        return top;
    }
    public static int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }
        int top=-1;
        if(!q1.isEmpty()){
            while (!q1.isEmpty()){
                top=q1.remove();
                q2.add(top);
            }
        }else {
            while (!q2.isEmpty()){
                top=q2.remove();
                q1.add(top);
            }
        }
        return top;
    }
}
public class TwoQueue {
    public static void main(String args[]){
        TQS stk=new TQS();
        stk.push(10);
        stk.push(11);
        stk.push(12);
        stk.push(13);
        stk.push(14);
        stk.push(10);

        while (!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }
}