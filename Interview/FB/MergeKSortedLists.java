package Interview.FB;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
 
class Item implements Comparable<Item> {
    ListNode node; 
    int index; 
    int count;
    
    public Item(ListNode node, int index, int count) {
        this.node = node;
        this.index = index;
        this.count = count;
    }
    
    @Override
    public int compareTo(Item that) {
        
        if (this.node.val != that.node.val) {
            return this.node.val - that.node.val;
        }
        
        else if (this.index != that.index) {
            return this.index - that.index;
        }
        else {
            return this.count - that.count;
        }
    }
    
    
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // if (lists == null || lists.length == 0) {
        //     return null;
        // }
        
        // return mergeKListsHelper(lists, 0, lists.length - 1);
        
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        int count = 0;
        PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        
        for (int i = 0; i < lists.length; i++) {
            
            if (lists[i] != null) {
                priorityQueue.offer(new Item(lists[i], i, count++));
            }
        }
        
        while (!priorityQueue.isEmpty()) {
            
            Item item = priorityQueue.poll();
            node.next = item.node;
            node = node.next;
            
            if (item.node.next != null) {
                priorityQueue.offer(new Item(item.node.next, item.index, count++));
            }
        }
        
        return dummy.next;
        
    }
    
    
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        
        if (start >= end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2; 
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        
        return merge2Lists(left, right);
        
    }
    
    private ListNode merge2Lists(ListNode left, ListNode right) {
        
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        
        while (left != null && right != null) {
            
            if (left.val < right.val) {
                
                node.next = new ListNode(left.val);
                node = node.next;
                left = left.next;
            }
            else {
                node.next = new ListNode(right.val);
                node = node.next;
                right = right.next;
            }
        }
        
        while (left != null) {
            node.next = new ListNode(left.val);
            node = node.next;
            left = left.next;
        }
        
        while (right != null) {
            node.next = new ListNode(right.val);
            node = node.next;
            right = right.next;
        }
        
        return dummy.next;
    }
}