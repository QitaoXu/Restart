package Interview.AMZ; 

import java.util.*; 

public class CancatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Trie trie = new Trie(); 
        
        for (String word : words) {
            trie.insert(word);
        }
        
        List<String> results = new ArrayList<String>();
        
        for (String word : words) {
            
            List<String> combination = new ArrayList<String>();
            if (dfs(word, 0, combination, trie))
                results.add(word);
        }
        
        return results;
    }
    
    private boolean dfs(String word, 
                        int startIndex, 
                        List<String> combination, 
                        Trie trie) {
        
        if (startIndex == word.length()) {
            return combination.size() > 1;
        }
        
        for (int i = startIndex + 1; i < word.length() + 1; i++) {
            
            String prefix = word.substring(startIndex, i);
            
            if (!trie.search(prefix))
                continue;
            
            
            combination.add(prefix);
            if (dfs(word, i, combination, trie))
                return true;
            
            combination.remove(combination.size() - 1);
        }
        
        return false;
    }
}