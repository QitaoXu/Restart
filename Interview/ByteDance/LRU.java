package Interview.ByteDance;

import java.util.*;  

public class LRU {
    
    class ListNode {
        int key; 
        int val; 
        ListNode next;
        
        ListNode (int key, int val) {
            this.key = key; 
            this.val = val;
            this.next = null;
        }
    }
    
    int capacity; 
    Map<Integer, ListNode> keyToPrev = new HashMap<Integer, ListNode>();
    ListNode head; 
    ListNode tail;

    public LRU(int capacity) {
        this.capacity = capacity; 
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.head = new ListNode(-1, -1);
        this.tail = this.head;
    }
    
    private void popFront() {
        
        this.keyToPrev.remove(this.head.next.key);
        this.head.next = this.head.next.next; 
        this.keyToPrev.put(this.head.next.key, this.head);
    }
    
    private void pushBack(ListNode node) {
        
        this.tail.next = node; 
        this.keyToPrev.put(node.key, this.tail);
        this.tail = this.tail.next;
    }
    
    private void kick(ListNode prev) {
        
        ListNode node = prev.next; 
        if (node == this.tail)
            return; 
        
        prev.next = node.next; 
        this.keyToPrev.put(prev.next.key, prev);
        
        node.next = null; 
        this.pushBack(node);
    }
    
    public int get(int key) {
        
        if (!this.keyToPrev.containsKey(key))
            return -1;
        
        ListNode prev = this.keyToPrev.get(key); 
        int res = prev.next.val; 
        
        this.kick(prev);
        return res;
    }
    
    public void put(int key, int value) {
        
        if (this.keyToPrev.containsKey(key)) {
            ListNode prev = keyToPrev.get(key); 
            this.kick(prev); 
            this.keyToPrev.get(key).next.val = value;
        }
        
        else {
            
            ListNode node = new ListNode(key, value); 
            this.pushBack(node); 
            
            if (keyToPrev.size() > capacity)
                this.popFront();
        }
    }
}