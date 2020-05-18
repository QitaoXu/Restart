package Interview.ByteDance;

public class ByteDancePlayGround {

    public static void main(String[] args) {

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy; 

        int[] vals = {9}; 

        for (int val : vals) {

            node.next = new ListNode(val);
            node = node.next;
        }

        MergeSortLinkedList sll = new MergeSortLinkedList();
        dummy.next = sll.sortLinkedList(dummy.next);

        node = dummy.next; 

        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.println("");

        String num1 = "1";
        String num2 = "2";

        AddStringsII asII = new AddStringsII();
        System.out.println(asII.addStringsII(num1, num2));

        // int[][] matrix = {{1, 2, 4, 5}, {2, 7, 5, 4}};
        // LargestPathSumInMatrix lps = new LargestPathSumInMatrix();
        // System.out.println(lps.largestPathSumInMatrix(matrix));

        // MyMinHeap minHeap = new MyMinHeap(10);
        // int[] nums = {0, 2, 1, 7, 5};

        // for (int num : nums) {
        //     minHeap.add(num);
        // }

        // while (!minHeap.isEmpty()) {
        //     System.out.println(minHeap.poll());
        // }

        // MyStack stack = new MyStack(5);
        // for (int num : nums) {
        //     stack.push(num);
        //     stack.printStack();
        // }

        
        // System.out.println(stack.pop());
        // stack.printStack();
        
        // stack.push(3);
        // stack.printStack();

        // stack.push(6);
        // stack.printStack();
    }
 }