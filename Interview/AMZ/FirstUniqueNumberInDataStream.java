package Interview.AMZ; 

import java.util.*;

public class FirstUniqueNumberInDataStream {

    class ListNode {
    
        int val; 
        ListNode next; 
        
        public ListNode(int val) {
            this.val = val; 
            this.next = null;
        }
    }
    
    class DataStream {
        
        ListNode dummy;
        ListNode tail; 
        Map<Integer, ListNode> numToPrev; 
        Set<Integer> duplicates;
        
        public DataStream () {
            
            this.dummy = new ListNode(-1);
            this.tail = this.dummy;
            this.numToPrev = new HashMap<>();
            this.duplicates = new HashSet<>();
        }
        
        public void remove(int num) {
            
            ListNode prev = numToPrev.get(num);
            prev.next = prev.next.next;
            numToPrev.remove(num); 
            
            if (prev.next != null) {
                numToPrev.put(prev.next.val, prev);
            }
            
            else {
                this.tail = prev;
            }
        }
        
        public void add(int num) {
            
            if (duplicates.contains(num)) 
                return; 
            
            if (numToPrev.containsKey(num)) {
                
                this.remove(num);
                duplicates.add(num);
                return;
            }
            
            this.tail.next = new ListNode(num);
            this.numToPrev.put(num, this.tail);
            this.tail = this.tail.next;
            
        }
        
        public int getFirstUniqueNum() {
            
            if (this.dummy.next != null) {
                
                return dummy.next.val;
            }
            
            return -1;
        }
    }
    
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {

        // Write your code here
        
        DataStream ds = new DataStream(); 
        
        for (int num : nums) {
            
            ds.add(num);
            if (num == number) {
                return ds.getFirstUniqueNum();
            }
        }
        
        return -1;
    }
}