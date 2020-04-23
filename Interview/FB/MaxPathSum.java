package Interview.FB;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxGain(root);
        return this.maxSum;
    }
    
    private int maxGain(TreeNode node) {
        
        if (node == null)
            return 0; 
        
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0); 
        
        int priceStartNewPath = node.val + leftGain + rightGain; 
        
        maxSum = Math.max(maxSum, priceStartNewPath);
        
        return node.val + Math.max(leftGain, rightGain);
    }

}