package Interview.AMZ;

import java.util.*; 

class Solution {

    class ListNode {
        ListNode next;
        int val; 

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0)
            return null;
        
        mergeByHeap(lists);
        mergeKListsHelper(lists, 0, lists.length - 1);
        return mergeTwoByTwo(lists);
        
    }
    
    private ListNode mergeByHeap(ListNode[] lists) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>(); 
        int count = 0;
        
        for (int i = 0; i < lists.length; i++) {
            
            if (lists[i] == null)
                continue;
            
            priorityQueue.offer(new Item(lists[i], i, count++));
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy; 
        
        while (!priorityQueue.isEmpty()) {
            Item item = priorityQueue.poll(); 
            node.next = item.node;
            node = node.next;
            
            if (item.node.next == null) 
                continue;
            
            priorityQueue.offer(new Item(item.node.next, item.index, count++));
        }
        
        return dummy.next;
    }
    
    private ListNode mergeTwoByTwo(ListNode[] listArray) {
        
        List<ListNode> lists = new ArrayList<ListNode>(); 
        
        for (ListNode list : listArray)
            lists.add(list);
        
        while (lists.size() > 1) {
            
            List<ListNode> newLists = new ArrayList<ListNode>(); 
            
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                
                ListNode l = mergeTwoLists(lists.get(i), lists.get(i + 1));
                newLists.add(l);
            }
            
            if (lists.size() % 2 == 1)
                newLists.add(lists.get(lists.size() - 1));
            
            lists = newLists;
        }
        
        return lists.get(0);
        
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start >= end)
            return lists[start]; 
        
        int mid = start + (end - start) / 2; 
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1); 
        ListNode node = dummy; 
        
        while (l1 != null && l2 != null) {
            
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