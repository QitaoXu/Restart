package Interview.FB;
import java.util.*;

class TrieNode {
    
    Map<Character, TrieNode> children; 
    boolean isWord; 
    
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

public class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        
        this.root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = this.root; 
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); 
            
            if (!node.children.keySet().contains(c)) {
                node.children.put(c, new TrieNode());
            }
            
            node = node.children.get(c);
        }
        
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = this.find(word);
        return node != null && node.isWord == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.find(prefix);
        return node != null;
    }
    
    private TrieNode find(String word) {
        
        TrieNode node = this.root; 
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!node.children.keySet().contains(c)) {
                return null;
            }
            
            node = node.children.get(c);
        }
        
        return node;
    }
}
