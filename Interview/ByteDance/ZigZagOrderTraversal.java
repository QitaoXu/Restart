package Interview.ByteDance;

import java.util.*; 

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>(); 
        if (root == null)
            return results; 
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); 
        
        int count = 0; 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll(); 
                level.add(node.val); 
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if (count % 2 == 0)
                results.add(level);
            
            else 
                results.add(reverse(level));
            
            count += 1;
        }
        
        return results;
    }
    
    private List<Integer> reverse(List<Integer> level) {
        
        int start = 0, end = level.size() - 1; 
        
        while (start < end) {
            
            int temp = level.get(start); 
            level.set(start, level.get(end));
            level.set(end, temp);
            start++;
            end--;
        }
        
        return level;
    }
}