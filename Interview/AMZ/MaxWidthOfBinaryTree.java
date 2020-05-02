package Interview.AMZ;
import java.util.*;

public class MaxWidthOfBinaryTree {
    /**
     * @param root: the root
     * @return: the maximum width of the given tree
     */
    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here
        if (root == null)
            return 0;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        root.val = 0;
        queue.offer(root);
        
        int res = 1;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            res = Math.max(res, queue.peekLast().val - queue.peekFirst().val + 1);
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll(); 
                    
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                    
                }
                
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                    
                }
            }
            
        }
        
        return res;
    }
}