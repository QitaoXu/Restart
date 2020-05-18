package Interview.ByteDance;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        
        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        head = dummy; 
        
        while (head.next != null) {
            
            head = reverseNextK(head, k);
        }
        
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode head, int k) {
        
        ListNode next = head; 
        
        for (int i = 0; i < k; i++) {
            
            if (next.next == null)
                return next;
            
            next = next.next;
        }
        
        ListNode prev = head;
        ListNode curt = head.next; 
        ListNode n1 = head.next;
        
        for (int i = 0; i < k; i++) {
            
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt; 
            curt = temp;
        }
        
        head.next = prev;
        n1.next = curt;
        return n1;
        
    }
}