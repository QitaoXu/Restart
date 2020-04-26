package Algo.Course4;

class TreeNode {

    TreeNode left;
    TreeNode right; 
    int val; 

    public TreeNode (int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}

class ResultType {
    
    boolean isBST; 
    TreeNode maxNode;
    TreeNode minNode;
    
    public ResultType(boolean isBST) {
        this.isBST = isBST; 
        this.maxNode = null;
        this.minNode = null;
    }
    
}

public class ValidBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        
        return isValidBSTHelper(root).isBST;
        
        
    }
    
    private ResultType isValidBSTHelper(TreeNode root) {
        
        if (root == null)
            return new ResultType(true);
            
        ResultType left = isValidBSTHelper(root.left);
        ResultType right = isValidBSTHelper(root.right);
        
        if (left.isBST == false || right.isBST == false)
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