package Interview.FB; 

import java.util.*; 

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> results = new ArrayList<Integer>();
        if (s == null || s.length() < p.length())
            return results;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        Map<Character, Integer> running = new HashMap<Character, Integer>();
        
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            running.put(s.charAt(i), running.getOrDefault(s.charAt(i), 0) + 1);
        } 
        
        
        if (running.equals(map)) {
            results.add(0);
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            
            char newAdd = s.charAt(i);
            char oldRemove = s.charAt(i - p.length());
            
            running.put(newAdd, running.getOrDefault(newAdd, 0) + 1);
            running.put(oldRemove, running.get(oldRemove) - 1);
            
            if (running.get(oldRemove) == 0) {
                running.remove(oldRemove);
            }
            
            if (running.equals(map)) {
                results.add(i - p.length() + 1);
            }
            
        }
        
        return results;
        
    }
}