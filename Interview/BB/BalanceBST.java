package Interview.BB;

import java.util.*; 

public class BalanceBST {

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
    public TreeNode balanceBST(TreeNode root) {
        
        if (root == null)
            return null;
        
        List<TreeNode> inorder = new ArrayList<TreeNode>(); 
        
        traverse(root, inorder);
        
        if (inorder.size() <= 2)
            return root;
        
        return balance(inorder, 0, inorder.size() - 1);
    }
    
    private TreeNode balance(List<TreeNode> inorder, int start, int end) {
        
        if (start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = inorder.get(mid);
        
        root.left = balance(inorder, start, mid - 1);
        root.right = balance(inorder, mid + 1, end);
        
        return root;
    }
    
    private void traverse(TreeNode root, List<TreeNode> order) {
        
        if (root == null)
            return;
        
        traverse(root.left, order);
        order.add(root);
        traverse(root.right, order);
    }
}