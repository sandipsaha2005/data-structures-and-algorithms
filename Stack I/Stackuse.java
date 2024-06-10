// import java.util.ArrayList;
import java.util.*;

public class Stackuse {
    // static class  stk {         // Stack implementaion using arraylist.
    //     static ArrayList<Integer> list=new ArrayList<>();
        
    //     public static boolean isEmpty(){
    //         return list.size()==0;
    //     }
    //     public static void push(int data){
    //         list.add(data);
    //     }
    //     public static int pop(){
    //         int top=list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }
    //     public static int peek(){
    //         return list.get(list.size()-1);
    //     }
    // }




    // static class  Node {     // Stack implementation using linkedlist
    //     int data;
    //     Node next;
    //     Node (int data){
    //         this.data=data;
    //         this.next=null;
    //     }
        
    // }
    // static class  stk {
    //     static Node head=null;

    //     public static boolean isEmpty(){
    //         return head==null;
    //     }
    //     public static void push(int data){
    //         Node newNode=new Node(data);
    //         if(isEmpty()){
    //             head=newNode;
    //             return;
    //         }
    //         newNode.next=head;
    //         head=newNode;
    //     }
    //     public static int pop(){
    //         if(isEmpty()){
    //             System.out.println("List is empty");
    //             return -1;
    //         }
    //         int top=head.data;
    //         head=head.next;
    //         return top;
    //     }
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("List is empty");
    //             return -1;
    //         }
    //         return head.data;
    //     }
        
    // }
    


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(0);
        s.push(2);
        s.pop();
        // while (!stk.isEmpty()) {
        //     System.out.print(stk.peek() + " ");
        //     stk.pop();
        // }
    }


    
    
}