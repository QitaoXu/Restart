package Interview.ByteDance;
import java.util.*;

public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<String>(wordList); 
        
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> distance = new HashMap<String, Integer>(); 
        
        queue.offer(beginWord);
        distance.put(beginWord, 1); 
        
        Map<String, String> prev = new HashMap<>();
        
        while (!queue.isEmpty()) {
            
            String node = queue.poll(); 
            
            if (node.equals(endWord)) {
                
                printPath(node, beginWord, prev);
                return distance.get(node);
            }
            
            for (String neighbor : getNeighbors(node, words)) {
                if (distance.keySet().contains(neighbor))
                    continue; 
                
                if (!words.contains(neighbor))
                    continue;
                
                queue.offer(neighbor);
                distance.put(neighbor, distance.get(node) + 1);
                prev.put(neighbor, node);
            }
        }
        
        return 0;
    }
    
    private void printPath(String end, String start, Map<String, String> prev) {
        
        Stack<String> stack = new Stack<>();
        
        String node = end;
        
        while (!node.equals(start)) {
            
            stack.push(node);
            node = prev.get(node);
        }
        
        stack.push(start);
        
        StringBuilder sb = new StringBuilder(); 
        
        while (stack.size() > 1) {
            
            sb.append(stack.pop() + " -> ");
        }
        
        sb.append(stack.pop());
        System.out.println(sb.toString());
        
    }
    
    private List<String> getNeighbors(String node, Set<String> words) {
        List<String> neighbors = new ArrayList<String>(); 
        
        for (int i = 0; i < node.length(); i++) {
            
            String left = node.substring(0, i);
            String right = node.substring(i + 1, node.length());
            
            for (int j = 0; j < 26; j++) {
                char c = (char)('a' + j);
                if (c == node.charAt(i))
                    continue;
                StringBuilder sb = new StringBuilder();
                sb.append(left);
                sb.append(c);
                sb.append(right);
            
                String neighbor = sb.toString();
                
                if (!words.contains(neighbor))
                    continue;
                neighbors.add(neighbor);
            }
            
        }
        
        return neighbors;
        
    }
}