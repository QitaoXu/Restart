package Interview.FB; 

import java.util.*; 

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        
        this.stack = new Stack<TreeNode>();
        
        while (root != null) {
            
            stack.push(root);
            root = root.left;
        }
        
    }
    
    /** @return the next smallest number */
    public int next() {
        
        int res = stack.peek().val;
        moveUpper(stack);
        return res;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return stack.size() > 0;
    }
    
    private void moveUpper(Stack<TreeNode> stack) {
        
        TreeNode node = stack.peek(); 
        
        if (node.right == null) {
            
            node = stack.pop();
            
            while (!stack.isEmpty() && stack.peek().right == node) 
                node = stack.pop();
        }
        
        else {
            node = node.right;
            
            while (node != null) {
                stack.push(node);
                node = node.left;
                
            }
        }
    }
}