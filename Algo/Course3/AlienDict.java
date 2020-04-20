package Algo.Course3; 
import java.util.*; 

public class AlienDict {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (graph.keySet().contains(word.charAt(i))) 
                    continue;
                graph.put(word.charAt(i), new HashSet<Character>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int index = 0; index < Math.min(words[i].length(), words[i + 1].length()); index++) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                    break;
                }
            }
        }
        
        return topoSorting(graph);
        
    }
    
    private Map<Character, Integer> getIndegrees(Map<Character, Set<Character>> graph) {
        
        Map<Character, Integer> indegrees = new HashMap<Character, Integer>();
        
        for (Character node : graph.keySet()) {
            indegrees.put(node, 0);
        }
        
        for (Character node : graph.keySet()) {
            for (Character neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        
        return indegrees;
    }
    
    private String topoSorting(Map<Character, Set<Character>> graph) {
        
        Map<Character, Integer> indegrees = getIndegrees(graph); 
        
        Queue<Character> queue = new PriorityQueue<Character>(); 
        
        for (Character node : graph.keySet()) {
            if (indegrees.get(node) == 0) {
                queue.offer(node);
            }
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        while (!queue.isEmpty()) {
            
            Character node = queue.poll(); 
            sb.append(node);
            
            for (Character neighbor : graph.get(node)) {
                
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
            
        }
        
        return sb.length() == graph.keySet().size() ? sb.toString() : "";
    }
}