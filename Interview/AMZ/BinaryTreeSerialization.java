package Interview.AMZ; 

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeSerialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return "";
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<String> order = new ArrayList<String>(); 
        
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            
            TreeNode node = queue.poll(); 
            
            if (node != null) {
                
                order.add(Integer.toString(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
            
            else {
                
                order.add("#");
            }
            
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < order.size() - 1; i++) {
            sb.append(order.get(i) + " ");
        }
        sb.append(order.get(order.size() - 1));
        System.out.println(sb.toString());
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data.length() == 0)
            return null; 
        
        List<TreeNode> bfsOrder = new ArrayList<TreeNode>(); 
        
        String[] vals = data.split(" ");
        
        for (String val : vals) {
            
            if (!val.equals("#")) {
                bfsOrder.add(new TreeNode(Integer.parseInt(val)));
            }
            
            else {
                bfsOrder.add(null);
            }
        }
        
        TreeNode root = bfsOrder.get(0); 
        List<TreeNode> nodes = new ArrayList<TreeNode>(); 
        nodes.add(root); 
        
        int slow = 0, fast = 1; 
        
        while (slow < nodes.size()) {
            
            TreeNode node = nodes.get(slow);
            slow += 1;
            
            node.left = bfsOrder.get(fast);
            node.right = bfsOrder.get(fast + 1);
            fast += 2;
            
            if (node.left != null) 
                nodes.add(node.left);
            
            if (node.right != null)
                nodes.add(node.right);
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));