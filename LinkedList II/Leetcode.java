

public class Leetcode {

    static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        } 
    }

    public static Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        // System.out.println("added");
    }

    public  void display() {
        Node curr = head;
        // System.out.println("loop ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void zigZag(){
        
            Node slow=head;
            Node fast=head;
            while (fast!=null && fast.next!=null) {
                slow=slow.next;
                fast=fast.next.next;
            }
        Node mid=slow;
        Node tempRh=mid.next;
        mid.next=null;
        
            // reversing 
            Node prev=null;
            Node curr=tempRh;
            Node next;
            while (curr!=null) {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
        
        Node left=head;
        Node right=prev;
        Node nextl=null;
        Node nextr=null;
        while (left!=null && right !=null) {
            nextl=left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;

            right=nextr;
            left=nextl;
        }
        
    }


    public static void main(String[] args) {
        Leetcode ll = new Leetcode();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.display();
        ll.zigZag();
        ll.display();
    }
}
