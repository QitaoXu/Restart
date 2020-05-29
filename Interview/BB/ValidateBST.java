package Interview.BB;

public class ValidateBST {

    class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
    
    class ResultType {
        
        TreeNode minNode;
        TreeNode maxNode;
        boolean isBST;
        
        public ResultType(boolean isBST) {
            
            this.minNode = null;
            this.maxNode = null;
            this.isBST = isBST;
        }
        
    }
    public boolean isValidBST(TreeNode root) {
        
        return isBSTHelper(root).isBST;
    }
    
    private ResultType isBSTHelper(TreeNode root) {
        
        if (root == null)
            return new ResultType(true);
        
        ResultType left = isBSTHelper(root.left);
        ResultType right = isBSTHelper(root.right); 
        
        if (!left.isBST || !right.isBST)
            return new ResultType(false);
        
        else if (left.maxNode != null && left.maxNode.val >= root.val)
            return new ResultType(false);
        
        else if (right.minNode != null && right.minNode.val <= root.val)
            return new ResultType(false);
        else {
            
            ResultType res = new ResultType(true);
            res.minNode = left.minNode == null ? root : left.minNode;
            res.maxNode = right.maxNode == null ? root : right.maxNode;
            
            return res;
        }
    }
}