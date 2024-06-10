
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        Node next=null;
    }
}
class Queue{
    static Node head=null;
    static Node tail=null;
    public void enQueue(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public int deQueue(){
        if(head==null){
            System.out.println("The queue is empty");
            return -1;
        }
        int data= head.data;
        if(head==tail){
            head=tail=null;
        }else{
            head=head.next;
        }
        return data;
    }
    public int peek(){
        if(head==null){
            System.out.println("The queue is empty");
            return -1;
        }
        return head.data;
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
}
public class QueueLL {
    public static void main(String args[]){
        Queue cq=new Queue();
        cq.enQueue(1);
        cq.enQueue(2);
        cq.enQueue(3);
        cq.enQueue(4);
        cq.enQueue(5);
        cq.enQueue(6);
        cq.deQueue();
        while (!cq.isEmpty()){
            System.out.print(cq.peek()+" ");
            cq.deQueue();
        }
    }
}

