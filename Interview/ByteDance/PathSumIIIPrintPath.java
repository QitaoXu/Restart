package Interview.ByteDance;

import java.util.*;  

class PathSumIIIPrintPath {
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
    public int pathSum(TreeNode root, int sum) {
        
        if (root == null)
            return 0; 
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        int res = pathSumHelper(root, sum, results);
        
        printPath(results);
        
        return res;
        
    }
    
    private void printPath(List<List<Integer>> results) {
        
        for (List<Integer> path : results) {
            
            StringBuilder sb = new StringBuilder(); 
            
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i) + " -> ");
            }
            
            sb.append(path.get(path.size() - 1));
            
            System.out.println(sb.toString());
        }
    }
    
    private int pathSumHelper(TreeNode root, int sum, List<List<Integer>> results) {
        
        if (root == null)
            return 0;
        
        List<Integer> path = new ArrayList<Integer>();
        
        int res = pathSumHelper(root.left, sum, results) + 
                  pathSumHelper(root.right, sum, results) + 
                  findPath(root, sum, path, results);
        
        return res;
    }
    
    private int findPath(TreeNode root, 
                         int sum, 
                         List<Integer> path, 
                         List<List<Integer>> results) {
        
        if (root == null)
            return 0; 
        
        int res = 0; 
        
        path.add(root.val);
        
        if (sum - root.val == 0) {
            results.add(new ArrayList<Integer>(path));
            res += 1;
            
        }
        
        res += findPath(root.left, sum - root.val, path, results);
        res += findPath(root.right, sum - root.val, path, results);
        
        path.remove(path.size() - 1);
        
        return res;
    }
}