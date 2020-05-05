package Interview.AMZ;

public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next; 

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curt = head;
        
        while (curt != null) {
            
            ListNode nextTemp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = nextTemp;
        }
        
        return prev;
    }
}