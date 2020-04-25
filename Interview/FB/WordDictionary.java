package Interview.FB;

public class WordDictionary {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        if (word == null) 
            return false;
        
        return searchHelper(this.root, word, 0);
        
    }
    
    private boolean searchHelper(TrieNode node, String word, int index) {
        
        if (node == null) 
            return false;
        
        if (index >= word.length()) {
            return node.isWord;
        }
        
        char c = word.charAt(index); 
        
        if (c == '.') {
            
            for (Character child : node.children.keySet()) {
                
                if (searchHelper(node.children.get(child), word, index + 1)) 
                    return true;
            }
            return false;
        }
        
        else {
            return searchHelper(node.children.get(c), word, index + 1);
        }
        
    }
}