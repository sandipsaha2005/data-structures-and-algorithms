import java.util.List;

public class LinkedList {
    /**
     * InnerLinkedList
     */
    public class ListNode {
        int data;
        ListNode next;
        
    }
    public boolean isCycle(ListNode head){   // floyed cycle finding algorithm
        ListNode slow=head;
        ListNode fast=head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void updateLl(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        boolean isCy=false;
        while (fast!=null && fast.next!=null) {
            slow =slow.next;
            fast= fast.next.next;
            if(fast == slow){
                isCy=true;
            }
        }
        ListNode prev=null;
        if(isCy){
            slow=head;
            
            while (slow==fast) {
                slow=slow.next;
                prev=fast;
                fast=fast.next.next;
            }
        }
        prev.next=null;
    }
    public static void main(String[] args) {
        
    }
}