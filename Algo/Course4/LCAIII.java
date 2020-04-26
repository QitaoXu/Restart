package Algo.Course4;

class ResultTypeLCAIII {
    
    boolean hasA; 
    boolean hasB; 
    TreeNode lca; 
    
    public ResultTypeLCAIII(boolean hasA, boolean hasB, TreeNode lca) {
        this.hasA = hasA;
        this.hasB = hasB;
        this.lca = lca;
    }
}

public class LCAIII {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        
        ResultTypeLCAIII res = lcaHelper(root, A, B);
        return res.hasA == true && res.hasB == true ? res.lca : null;
        
    }
    
    private ResultTypeLCAIII lcaHelper(TreeNode root, TreeNode A, TreeNode B) {
        
        if (root == null) 
            return new ResultTypeLCAIII(false, false, null);
            
        ResultTypeLCAIII left = lcaHelper(root.left, A, B);
        ResultTypeLCAIII right = lcaHelper(root.right, A, B); 
        
        boolean hasA = left.hasA || right.hasA || root == A; 
        boolean hasB = left.hasB || right.hasB || root == B;
        
        if (root == A || root == B)
            return new ResultTypeLCAIII(hasA, hasB, root);
            
        if (left.lca != null && right.lca != null) 
            return new ResultTypeLCAIII(hasA, hasB, root);
            
        if (left.lca != null)
            return new ResultTypeLCAIII(hasA, hasB, left.lca);
            
        if (right.lca != null)
            return new ResultTypeLCAIII(hasA, hasB, right.lca);
            
        return new ResultTypeLCAIII(hasA, hasB, null);
            
        
    }
}