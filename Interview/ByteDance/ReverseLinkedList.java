package Interview.ByteDance; 

public class ReverseLinkedList {

    class ListNode {

        int val;
        ListNode next; 

        public ListNode(int val) {
            this.val = val; 
            this.next = null;
        }
    }

    public ListNode reverseListRecursive(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode node = reverseListRecursive(head.next);
        
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseListIterative(ListNode head) {
        
        if (head == null || head.next == null)
            return head; 
        
        
        ListNode prev = null;
        ListNode curt = head;
        
        while (curt != null) {
            
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        
        return prev;
        
    }
}