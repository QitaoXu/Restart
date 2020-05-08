package Interview.ByteDance; 

class ListNode {

    int val;
    ListNode next; 

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SortLinkedList {

    public ListNode sortLinkedList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(middleNext);

        return mergeTwoSortedList(left, right);
    }

    private ListNode getMiddle(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1); 
        ListNode node = dummy; 

        while (l1 != null && l2 !=  null) {

            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val); 
                node = node.next;
                l1 = l1.next;
            }

            else {

                node.next = new ListNode(l2.val);
                node = node.next; 
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            node.next = new ListNode(l1.val);
            node = node.next; 
            l1 = l1.next;
        }

        while (l2 != null) {
            node.next = new ListNode(l2.val); 
            node = node.next; 
            l2 = l2.next;
        }

        return dummy.next;
    }

}