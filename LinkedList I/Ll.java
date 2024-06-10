public class Ll{

    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
            
    public void addFir(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }

        newNode.next=head;

        head=newNode;
        size++;
    }
    public void addLas(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;      
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }
    public static void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public int sizeLL(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void addMiddle(int data,int idx){
        Node newNode=new Node(data);
        Node temp=head;
        if(idx==0){
            addFir(data);
            return;
        }
        for(int i=1;i<idx;i++){
            temp=temp.next;
        }
        Node q=temp.next;
        temp.next=newNode;
        newNode.next=q;
        size++;
    }
    // public int delFir(){
    //     if(head==0){
    //         System.out.println("Linked list is empty");
    //         return Integer.MIN_VALUE;
    //     }else if(head==1){
    //         int val=head.data;
    //         head=tail=null;
    //         size=0;
    //         return val;
    //     }
    //     int d=head.data;
    //     head=head.next;
    //     size--;
    //     return d;
    // }
    // public int delLst(){
    //     if(head==0){
    //         System.out.println("Linked list is empty");
    //         return Integer.MIN_VALUE;
    //     }else if(head==1){
    //         int val=head.data;
    //         head=tail=null;
    //         size=0;
    //         return val;
    //     }
    //     Node temp=head;
        
    //     for(int i=0;i<size-2;i++){
    //         temp=temp.next;
    //     }
    //     int val=temp.data;
    //     temp.next=null;
    //     tail=temp;
    //     size--;
    //     return val;
    // }
    public int search(int key){

        int i=0;
        Node temp=head;
        // while(temp.data==key){
        //     temp=temp.next;
        //     i++;
        // }
        // return i;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int help(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=help(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSea(int key){
        int dx=help(head,key);
        return dx;
    }
    public void revLL(){
        if(head==null){
            System.out.print("The ll is empty");
        }
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean ispa(Node head){
        if(head==null && head.next!=null){
            return true;
        }
        Node mid=findMid(head);
        Node prev=null;
        Node temp=mid;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        Node rightHead=prev;
        Node leftHead=head;
        while(rightHead!=null){
            if(rightHead.data!=leftHead.data){
                return false;
            }
            rightHead=rightHead.next;
            leftHead=leftHead.next;
        }
        return true;
    }
    public static void main(String args[]){
        Ll ll=new Ll();
        // ll.addFir(2);
        // ll.addFir(3);
        // ll.addFir();
        ll.addLas(1);
        ll.addLas(2);
        ll.addLas(1);
        
        // ll.addMiddle(10,0);
        print();
        // ll.delFir();
        print();
        ll.revLL();
        print();
        System.out.println(ll.ispa(head));
        // System.out.print(ll.recSea(4));
    }
}