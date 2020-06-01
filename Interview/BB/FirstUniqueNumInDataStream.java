package Interview.BB;
import java.util.*;

public class FirstUniqueNumInDataStream {
    
    DataStream ds;

    public FirstUniqueNumInDataStream(int[] nums) {
        
        this.ds = new DataStream();
        
        for (int num : nums) {
            this.ds.add(num);
        }
    }
    
    public int showFirstUnique() {
        
        return this.ds.getFirstUnique();
    }
    
    public void add(int value) {
        
        this.ds.add(value);
    }

    class ListNode {
    
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    class DataStream {
        
        ListNode head, tail;
        Map<Integer, ListNode> numToPrev;
        Set<Integer> duplicates;
        
        public DataStream() {
            
            this.head = new ListNode(-1);
            this.tail = this.head;
            this.numToPrev = new HashMap<Integer, ListNode>();
            this.duplicates = new HashSet<Integer>();
            
        }
        
        private void remove(int number) {
            
            ListNode prev = numToPrev.get(number);
            prev.next = prev.next.next;
            numToPrev.remove(number);
            
            
            if (prev.next != null) {
                
                numToPrev.put(prev.next.val, prev);
            }
            
            else {
                
                tail = prev;
            }
        }
        
        public void add(int number) {
            
            if (duplicates.contains(number))
                return;
            
            if (numToPrev.containsKey(number)) {
                
                remove(number);
                duplicates.add(number);
            }
            
            else {
                
                ListNode node = new ListNode(number);
                tail.next = node;
                numToPrev.put(node.val, tail);
                tail = tail.next;
            }
        }
        
        public int getFirstUnique() {
            
            if (head.next != null)
                return head.next.val;
            
            return -1;
        }
    }
}
