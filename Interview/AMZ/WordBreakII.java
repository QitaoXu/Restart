package Interview.AMZ;
import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Trie trie = new Trie(); 
        
        for (String word : wordDict) {
            trie.add(word);
        }
        
        List<String> combination = new ArrayList<String>(); 
        Map<String, List<String>> memo = new HashMap<String, List<String>>();
        
        return dfs(s, combination, memo, trie);
    }
    
    private List<String> dfs(String s, List<String> combination, Map<String, List<String>> memo, Trie trie) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        if (s.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<String> partitions = new ArrayList<String>(); 
        
        for (int index = 1; index < s.length() + 1; index++) {
            
            String prefix = s.substring(0, index);
            
            if (!trie.search(prefix))
                continue;
            
            combination.add(prefix);
            List<String> subPartitions = this.dfs(s.substring(index, s.length()), combination, memo, trie);
            for (String subPartition : subPartitions) {
                partitions.add(prefix + " " + subPartition);
                
            }
            combination.remove(combination.size() - 1);
        }
        
        if (trie.search(s)) 
            partitions.add(s);
        
        memo.put(s, partitions);
        return partitions;
    }
}