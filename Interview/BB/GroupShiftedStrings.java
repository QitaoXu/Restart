package Interview.BB;

import java.util.*; 

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> groups = new HashMap<>(); 
        
        for (String word : strings) {
            
            String candidate = getCandidate(word);
            
            if (!groups.containsKey(candidate))
                groups.put(candidate, new ArrayList<String>());
            
            groups.get(candidate).add(word);
        }
        
        List<List<String>> results = new ArrayList<>(); 
        
        for (List<String> group : groups.values()) {
            
            results.add(group);
        }
        
        return results;
    }
    
    private String getCandidate(String word) {
        
        int shift = word.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < word.length(); i++) {
            
            int reminder = (int)((word.charAt(i) - shift) % 26); // "ba" -> "az"
            
            if (reminder < 0)
                reminder += 26;
            
            char c = (char)('a' + reminder);
            sb.append(c);
        }
        
        return sb.toString();
    }
}