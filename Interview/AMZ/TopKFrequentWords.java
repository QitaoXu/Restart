package Interview.AMZ;

import java.util.*; 

public class TopKFrequentWords {
    
    class Item {
        
        String word; 
        int count; 
        
        public Item(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        
        if (words == null || words.length < k) 
            return null; 
            
        Map<String, Integer> wordToCount = new HashMap<String, Integer>();
        
        for (String word : words) {
            
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Item> queue = new PriorityQueue<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                
                if (a.count != b.count) {
                    return a.count - b.count;
                }
                
                return b.word.compareTo(a.word);
            }
        });
        
        for (String word : wordToCount.keySet()) {
            
            queue.offer(new Item(word, wordToCount.get(word)));
            
            if (queue.size() > k) 
                queue.poll();
        }
        
        String[] results = new String[k];
        
        int i = k - 1;
        
        while (!queue.isEmpty()) {
            
            results[i--] = queue.poll().word;
        }
        
        return results;
    }
}