package Interview.AMZ; 

import java.util.*; 

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        Map<Integer, Set<Integer>> graph = buildGraph(seqs); 
        return topologicalSorting(org, graph);
    }
    
    private Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> seqs) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> nodes = new HashSet<Integer>(); 
        
        for (List<Integer> seq : seqs) {
            for (int node : seq) {
                nodes.add(node);
            }
        }
        
        for (int node : nodes) {
            graph.put(node, new HashSet<Integer>());
        }
        
        for (List<Integer> seq : seqs) {
            
            for (int i = 0; i < seq.size() - 1; i++) {
                int prev = seq.get(i);
                int next = seq.get(i + 1);
                
                graph.get(prev).add(next);
            }
        }
        
        return graph;
    }
    
    private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegrees = new HashMap<>(); 
        
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
    
    private boolean topologicalSorting(int[] org, Map<Integer, Set<Integer>> graph) {
        
        Map<Integer, Integer> indegrees = getIndegrees(graph);
        
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        for (int node : graph.keySet()) {
            
            if (indegrees.get(node) == 0)
                queue.offer(node);
        }
        
        List<Integer> order = new ArrayList<Integer>();
        
        while (!queue.isEmpty()) {
            
            if (queue.size() > 1)
                return false;
            
            int node = queue.poll();
            order.add(node); 
            
            for (int neighbor : graph.get(node)) {
                
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }
        
        if (order.size() != org.length)
            return false;
        
        else if (order.size() != graph.size())
            return false;
        
        else {
            
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) != org[i])
                    return false;
            }
            
            return true;
        }
            
    }
}