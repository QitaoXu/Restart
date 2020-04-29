package Interview.AMZ;

public class InsertIntoBST {
    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        
        if (val > root.val)
            root.right = insertIntoBSTRecursive(root.right, val);
        
        else 
            root.left = insertIntoBSTRecursive(root.left, val);
        
        return root;
    }

    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        
        TreeNode node = root; 
        
        while (node != null) {
            
            if (val > node.val) {
                
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                
                else 
                    node = node.right;
            }
            
            else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                
                else 
                    node = node.left;
            }
        }
        
        return new TreeNode(val);
    }
}