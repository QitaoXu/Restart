package Interview.BB;

public class FlattenMultiLevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        
        if (head == null)
            return head;
        
        Node dummy = new Node();
        dummy.next = head;
        
        flattenDFS(dummy, head);
        
        dummy.next.prev = null;
        
        return dummy.next;
    }
    
    private Node flattenDFS(Node prev, Node curt) {
        
        if (curt == null)
            return prev;
        
        curt.prev = prev;
        prev.next = curt;
        
        Node next = curt.next;
        
        Node tail = flattenDFS(curt, curt.child);
        curt.child = null;
        
        return flattenDFS(tail, next);
    }
}