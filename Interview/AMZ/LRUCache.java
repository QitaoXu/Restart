package Interview.AMZ;
import java.util.*;

public class LRUCache {
    
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
    Map<Integer, ListNode> keyToPrev;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
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
        
        if (!keyToPrev.containsKey(key)) 
            return -1;
        
        ListNode prev = keyToPrev.get(key); 
        int val = prev.next.val; 
        this.kick(prev);
        return val;
    }
    
    public void put(int key, int value) {
        
        if (keyToPrev.containsKey(key)) {
            
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