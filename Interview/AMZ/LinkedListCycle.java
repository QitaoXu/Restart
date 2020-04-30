package Interview.AMZ;

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next; 

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public boolean hasCycle(ListNode head) {
        // write your code here
        
        if (head == null || head.next == null)
            return false;
        
        ListNode slow = head, fast = head; 
        
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next; 
            
            if (slow == fast)
                return true;
        }
        
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        // write your code here
        
        if (head == null || head.next == null)
            return null; 
            
        ListNode slow = head, fast = head; 
        
        while (fast != null && fast.next != null) {
            
            slow = slow.next; 
            fast = fast.next.next; 
            
            if (slow == fast)
                break;
        }
        
        if (slow != fast) // No cycle
            return null;
        
        slow = head; 
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        
        if (headA == null || headB == null) 
            return null;
            
        ListNode node = headA; 
        
        while (node.next != null) {
            
            node = node.next;
        }
        
        node.next = headB; 
        
        ListNode slow = headA, fast = headA; 
        
        while (fast != null && fast.next != null) {
            
            slow = slow.next; 
            fast = fast.next.next; 
            
            if (slow == fast)
                break;
        }
        
        if (slow != fast) 
            return null;
            
        slow = headA; 
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next; 
        }
        
        node.next = null;
        return slow;
        
    }
    
}