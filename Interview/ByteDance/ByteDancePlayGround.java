package Interview.ByteDance;

public class ByteDancePlayGround {

    public static void main(String[] args) {

        // ListNode dummy = new ListNode(-1);
        // ListNode node = dummy; 

        // int[] vals = {9, 4, 3, 2, 5}; 

        // for (int val : vals) {

        //     node.next = new ListNode(val);
        //     node = node.next;
        // }

        // SortLinkedList sll = new SortLinkedList();
        // dummy.next = sll.sortLinkedList(dummy.next);

        // node = dummy.next; 

        // while (node != null) {
        //     System.out.print(node.val + "->");
        //     node = node.next;
        // }

        // System.out.println("");

        // int[][] matrix = {{1, 2, 4, 5}, {2, 7, 5, 4}};
        // LargestPathSumInMatrix lps = new LargestPathSumInMatrix();
        // System.out.println(lps.largestPathSumInMatrix(matrix));

        // MyMinHeap minHeap = new MyMinHeap(10);
        int[] nums = {0, 2, 1, 7, 5};

        // for (int num : nums) {
        //     minHeap.add(num);
        // }

        // while (!minHeap.isEmpty()) {
        //     System.out.println(minHeap.poll());
        // }

        MyStack stack = new MyStack(5);
        for (int num : nums) {
            stack.push(num);
            stack.printStack();
        }

        
        System.out.println(stack.pop());
        stack.printStack();
        
        stack.push(3);
        stack.printStack();

        stack.push(6);
        stack.printStack();
    }
 }