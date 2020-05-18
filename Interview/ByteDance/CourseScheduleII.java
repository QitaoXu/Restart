package Interview.ByteDance; 

import java.util.*; 

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Set<Integer>> graph = this.buildGraph(numCourses, prerequisites);
        return topologicalSorting(graph);
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] pres) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int node = 0; node < n; node++) {
            graph.put(node, new HashSet<Integer>());
        }
        
        for (int[] pre : pres) {
            
            graph.get(pre[1]).add(pre[0]);
        }
        
        return graph;
    }
    
    private int[] topologicalSorting(Map<Integer, Set<Integer>> graph) {
        
        Map<Integer, Integer> indegrees = getIndegrees(graph);
        
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        for (int node : graph.keySet()) {
            
            if (indegrees.get(node) == 0) {
                queue.offer(node);
            }
        }
        
        List<Integer> order = new ArrayList<Integer>(); 
        
        while (!queue.isEmpty()) {
            
            int node = queue.poll(); 
            order.add(node); 
            
            for (int neighbor : graph.get(node)) {
                
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) 
                    queue.offer(neighbor);
            }
        }
        
       if (order.size() != graph.size()) {
           return new int[0];
       }
       else {
           int[] res = new int[order.size()]; 
           
           for (int i = 0; i < order.size(); i++) {
               res[i] = order.get(i);
           }
           
           return res;
       }
        
    }
    
    private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
        
        int n = graph.size(); 
        
        Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>(); 
        
        for (int node = 0; node < n; node++) {
            
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