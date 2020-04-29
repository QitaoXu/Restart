package Interview.AMZ;

public class ValidateBST {
    
    class ResultType {
        
        boolean isBST; 
        TreeNode minNode;
        TreeNode maxNode; 
        
        public ResultType(boolean isBST) {
            this.isBST = isBST; 
            this.minNode = null;
            this.maxNode = null;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTHelper(root).isBST;
    }
    
    private ResultType isValidBSTHelper(TreeNode root) {
        if (root == null)
            return new ResultType(true);
        
        ResultType left = isValidBSTHelper(root.left);
        ResultType right = isValidBSTHelper(root.right);
        
        if (!left.isBST || !right.isBST)
            return new ResultType(false);
        
        if (left.maxNode != null && left.maxNode.val >= root.val)
            return new ResultType(false);
        
        if (right.minNode != null && right.minNode.val <= root.val)
            return new ResultType(false);
        
        ResultType res = new ResultType(true);
        res.minNode = left.minNode != null ? left.minNode : root;
        res.maxNode = right.maxNode != null ? right.maxNode : root;
        
        return res;
    }
}