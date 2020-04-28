package Interview.AMZ;

import java.util.*; 
class TrieNode {
    
    Map<Character, TrieNode> children; 
    boolean isWord; 
    
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

class Trie {
    TrieNode root; 
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void add(String word) {
        
        TrieNode node = this.root; 
        char[] wa = word.toCharArray(); 
        
        for (int i = 0; i < word.length(); i++) {
            
            char c = wa[i]; 
            
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            
            node = node.children.get(c);
        }
        
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = this.find(word);
        return node != null && node.isWord == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.find(prefix);
        return node != null;
    }
    
    private TrieNode find(String word) {
        
        TrieNode node = this.root; 
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); 
            
            if (!node.children.containsKey(c))
                return null;
            
            node = node.children.get(c);
        }
        
        return node;
    }
}

public class WordBreakI {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if (s == null || wordDict == null || wordDict.size() == 0)
            return false;
        
        Trie trie = new Trie(); 
        for (String word : wordDict) {
            trie.add(word);
        }
        
        int startIndex = 0;
        Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
        
        return dfs(s, startIndex, memo, trie);
        
        
    }
    
    private boolean dfs(String s, int startIndex, Map<Integer, Boolean> memo, Trie trie) {
        
        if (memo.containsKey(startIndex))
            return memo.get(startIndex);
        
        if (startIndex == s.length()) {
            return true;
        }
        
        for (int index = startIndex + 1; index < s.length() + 1; index++) {
            
            String prefixString = s.substring(startIndex, index);
            if (!trie.search(prefixString))
                continue;
            
            if (dfs(s, index, memo, trie)) {
                memo.put(startIndex, true);
                return true;
            }
                
        }
        
        memo.put(startIndex, false);
        return false;
    }
    
    
}