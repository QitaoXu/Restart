package Interview.ByteDance;

import java.util.*; 

public class PathSumII {
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>(); 
        
        if (root == null)
            return results; 
        
        List<Integer> path = new ArrayList<>();
        
        findAllPath(root, sum, path, results);
        
        return results;
    }
    
    private void findAllPath(TreeNode root, 
                             int sum, 
                             List<Integer> path, 
                             List<List<Integer>> results) {
        
        
        if (root == null)
            return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum - root.val == 0) {
            results.add(new ArrayList<Integer>(path));
        }
        
        findAllPath(root.left, sum - root.val, path, results);
        findAllPath(root.right, sum - root.val, path, results);
        
        path.remove(path.size() - 1);
    }
}