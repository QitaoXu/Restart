package Interview.ByteDance;

public class PathSumIII {
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
        
        return pathSum(root.left, sum) + pathSum(root.right, sum) + findPath(root, sum);
    }
    
    private int findPath(TreeNode root, int sum) {
        
        if (root == null)
            return 0; 
        
        int res = 0; 
        
        if (sum - root.val == 0)
            res += 1;
        
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        
        return res;
    }
}