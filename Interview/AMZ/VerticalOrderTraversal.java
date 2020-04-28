package Interview.AMZ;
import java.util.*; 

class TreeNode {
    TreeNode left; 
    TreeNode right; 
    int val; 

    public TreeNode (int val) {
        this.val = val;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<List<Integer>>(); 
        List<Integer> verticalSum = new ArrayList<Integer>();
        
        if (root == null)
            return results;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>(); 
        
        queue.offer(root);
        cols.offer(0); 
        
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(); 
        Map<Integer, Integer> sumMap = new TreeMap<Integer, Integer>();
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                int col = cols.poll(); 
                
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<Integer>());
                }
                
                map.get(col).add(node.val);
                sumMap.put(col, sumMap.getOrDefault(col, 0) + node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                    cols.offer(col - 1);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    cols.offer(col + 1);
                }
                    
            }
        }
        
        for (Integer col : map.keySet()) {
            results.add(map.get(col));
            verticalSum.add(sumMap.get(col));
        }
        
        System.out.println(verticalSum);
        return results;
        
    }
}