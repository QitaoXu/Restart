package Interview.AMZ; 

import java.util.*; 

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<String>(wordList);
        
        List<List<String>> results = new ArrayList<>(); 
        
        if (!set.contains(endWord))
            return results; 
        
        set.add(beginWord); 
        
        Map<String, Integer> distance = new HashMap<String, Integer>();
        bfs(endWord, beginWord, set, distance);
        
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(beginWord, endWord, set, path, distance, results);
        return results;
    }
    
    private void bfs(String start, String end, Set<String> set, Map<String, Integer> distance) {
        
        Queue<String> queue = new LinkedList<String>(); 
        queue.offer(start);
        distance.put(start, 0); 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                String node = queue.poll(); 
                
                for (String neighbor : getNeighbors(node)) {
                    
                    if (!set.contains(neighbor))
                        continue;
                    
                    if (distance.containsKey(neighbor))
                        continue;
                    
                    queue.offer(neighbor);
                    distance.put(neighbor, distance.get(node) + 1);
                }
            }
        }
    }
    
    private List<String> getNeighbors(String node) {
        
        List<String> neighbors = new ArrayList<String>(); 
        
        for (int i = 0; i < node.length(); i++) {
            
            String prefix = node.substring(0, i);
            String suffix = node.substring(i + 1, node.length()); 
            
            for (int j = 0; j < 26; j++) {
                
                if (node.charAt(i) == 'a' + j)
                    continue;
                
                String neighbor = prefix + Character.toString('a' + j) + suffix;
                neighbors.add(neighbor);
            }
        }
        
        return neighbors;
    }
    
    private void dfs(String curt, 
                     String target, 
                     Set<String> set, 
                     List<String> path, 
                     Map<String, Integer> distance, 
                     List<List<String>> results) {
        
        
        if (curt.equals(target)) {
            
            results.add(new ArrayList<String>(path));
            return;
        }
        
        for (String neighbor : getNeighbors(curt)) {
            
            if (!set.contains(neighbor))
                continue; 
            
            if (distance.get(neighbor) != distance.get(curt) - 1)
                continue;
            
            path.add(neighbor);
            dfs(neighbor, target, set, path, distance, results);
            path.remove(path.size() - 1);
        }
    }
}