package Interview.AMZ; 

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class CopyListWithRandomPointer {

    class Node {

        int val;
        Node next; 
        Node random; 

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }
        
        copyNext(head);
        copyRandom(head);
        
        return splitList(head);
    }
    
    private void copyNext(Node head) {
        
        while (head != null) {
            
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            newNode.random = head.random;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(Node head) {
        
        while (head != null) {
            
            if (head.next.random != null)
                head.next.random = head.random.next;
            
            head = head.next.next;
        }
    }
    
    private Node splitList(Node head) {
        
        Node newHead = head.next; 
        
        while (head != null) {
            
            Node temp = head.next;
            head.next = temp.next;
            head = head.next; 
            
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            
        }
        
        return newHead;
    }
}