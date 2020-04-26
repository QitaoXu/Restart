package Algo.Course4;

public class FlatternBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        flatternAndReturnLastNode(root);
    }
    
    private TreeNode flatternAndReturnLastNode(TreeNode root) {
        
        if (root == null)
            return null;
            
        TreeNode leftLastNode = flatternAndReturnLastNode(root.left);
        TreeNode rightLastNode = flatternAndReturnLastNode(root.right);
        
        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLastNode != null)
            return rightLastNode;
            
        else if (leftLastNode != null)
            return leftLastNode;
        else
            return root;
    }
}