package Interview.AMZ; 

import java.util.*; 

public class BinaryTreeRightSideView {
    /**
     * @param root: the root of the given tree
     * @return: the values of the nodes you can see ordered from top to bottom
     */
    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        
        List<Integer> results = new ArrayList<Integer>(); 
        
        if (root == null)
            return results; 
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll(); 
                
                if (i == size - 1)
                    results.add(node.val);
                    
                if (node.left != null) 
                    queue.offer(node.left);
                    
                if (node.right != null)
                    queue.offer(node.right);
                    
            }
        }
        
        return results;
    }
}