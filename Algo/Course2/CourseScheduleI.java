package Algo.Course2;
import java.util.*;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites); 
        return topologicalSorting(graph);
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] pres) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int[] pre : pres) {
            graph.get(pre[1]).add(pre[0]);
        }
        
        return graph;
    }
    
    private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
        
        HashMap<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
        
        for (Integer node : graph.keySet()) {
            indegrees.put(node, 0);
        }
        
        for (Integer node : graph.keySet()) {
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        
        return indegrees;
    }
    
    private boolean topologicalSorting(Map<Integer, Set<Integer>> graph) {
        
        Map<Integer, Integer> indegrees = this.getIndegrees(graph);
        
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> order = new ArrayList<Integer>(); 
        
        for (Integer node : graph.keySet()) {
            if (indegrees.get(node) == 0) {
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            
            int node = queue.poll(); 
            order.add(node); 
            
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return order.size() == graph.keySet().size();
    }
}