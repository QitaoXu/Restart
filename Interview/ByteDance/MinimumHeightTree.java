package Interview.ByteDance;

import java.util.*; 

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (n == 1) {
            return Arrays.asList(0);
        }
        
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        Map<Integer, Integer> indegrees = getIndegrees(graph);
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int node : graph.keySet()) {
            
            if (indegrees.get(node) == 1) {
                queue.offer(node);
            }
        }
        
        List<Integer> res = new ArrayList<Integer>(); 
        
        while(!queue.isEmpty()) {
            
            res = new ArrayList<Integer>(); 
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                int node = queue.poll();
                res.add(node); 
                
                for (int neighbor : graph.get(node)) {
                    indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                    if (indegrees.get(neighbor) == 1)
                        queue.offer(neighbor);
                }
            }
        }
        
        return res;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>(); 
        
        for (int node = 0; node < n; node++) {
            
            graph.put(node, new HashSet<Integer>());
        }
        
        for (int[] edge : edges) {
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
    private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
        
        Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>(); 
        
        for (int node : graph.keySet()) {
            indegrees.put(node, 0);
        }
        
        for (int node : graph.keySet()) {
            for (int neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        
        return indegrees;
    }
}