package Interview.AMZ;

import java.util.*; 

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if (root == null)
            return false; 
        
        int xDepth = getDepth(root, x);
        int yDepth = getDepth(root, y); 
        
        if (xDepth == -1 || yDepth == -1)
            return false;
        
        TreeNode xParent = getParent(root, null, x);
        TreeNode yParent = getParent(root, null, y); 
        
        if (xParent == null || yParent == null)
            return false;
        
        return xDepth == yDepth && xParent != yParent;
    }
    
    private TreeNode getParent(TreeNode root, TreeNode parent, int x) {
        if (root == null) {
            return null;
        }
        
        if (root.val == x) {
            return parent;
        }
        
        TreeNode leftParent = getParent(root.left, root, x);
        TreeNode rightParent = getParent(root.right, root, x);
        
        if (leftParent != null) 
            return leftParent;
        
        else if (rightParent != null)
            return rightParent;
        
        else
            return null;
        
    }
    
    private int getDepth(TreeNode root, int x) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        
        queue.offer(root); 
        int depth = -1;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            depth++;
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                if (node.val == x)
                    return depth;
                
                if (node.left != null)
                    queue.offer(node.left);
                
                if (node.right != null) 
                    queue.offer(node.right);
            }
        }
        
        return -1;
    }
}