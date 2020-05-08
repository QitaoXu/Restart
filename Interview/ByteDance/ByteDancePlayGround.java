package Interview.ByteDance;

public class ByteDancePlayGround {

    public static void main(String[] args) {

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy; 

        int[] vals = {9, 4, 3, 2, 5}; 

        for (int val : vals) {

            node.next = new ListNode(val);
            node = node.next;
        }

        SortLinkedList sll = new SortLinkedList();
        dummy.next = sll.sortLinkedList(dummy.next);

        node = dummy.next; 

        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
 }