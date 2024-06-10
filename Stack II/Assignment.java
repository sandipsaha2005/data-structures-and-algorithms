import org.w3c.dom.ls.LSOutput;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        Node next=null;
    }
}
class LinkedList{
    private Node head;
    LinkedList(){
        this.head=null;
    }
    public void add(int data){
        Node newNode=new Node(data);
        Node temp=head;
        if(head==null){
            head=newNode;
        }else{
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public void addFirst(int data){
        Node newNode =new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void display(){
        Node temp=head;
        System.out.print('[');
        while (temp!=null){
            System.out.print(temp.data+" , ");
            temp=temp.next;
        }
        System.out.print(']');
        System.out.println();
    }


}
public class Assignment {
    public static void main(String args[]){
//        LinkedList ll=new LinkedList();
//        ll.add(22);
//        ll.add(22);
//        ll.add(22);
//        ll.add(22);
//        ll.add(22);
//        ll.add(22);
//        ll.add(22);
//        ll.addFirst(21);
//
//        ll.display();
    }

}