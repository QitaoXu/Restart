package Algo.Course2;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            List<Integer> level = new ArrayList<Integer>(); 
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll(); 
                
                level.add(node.val); 
                
                if (node.left != null) 
                    queue.offer(node.left);
                    
                if (node.right != null)
                    queue.offer(node.right);
            }
            
            result.add(level);
        }
        
        return result;
    }
}