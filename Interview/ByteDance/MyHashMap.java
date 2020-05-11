package Interview.ByteDance; 

import java.util.*; 

class Pair<U, V> {
    
    U first;
    V second; 
    
    public Pair(U first, V second) {
        this.first = first; 
        this.second = second;
    }
}

class Bucket {
    
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key) {
        
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        
        return -1;
    }
    
    public void update(Integer key, Integer val) {
        boolean found = false; 
        
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                pair.second = val; 
                found = true;
                break;
            }
        }
        
        if (!found) {
            bucket.add(new Pair<Integer, Integer>(key, val));
        }
    }
    
    public void remove(Integer key) {
        
        for (Pair<Integer, Integer> pair : bucket) {
            
            if (pair.first.equals(key)) {
                bucket.remove(pair);
                break;
            }
        }
    }
}

public class MyHashMap {
    
    private List<Bucket> hashTable;
    private int keySpace;

    /** Initialize your data structure here. */
    public MyHashMap() {
        
        this.keySpace = 2069; 
        this.hashTable = new ArrayList<Bucket>(); 
        
        for (int i = 0; i < 2069; i++) {
            this.hashTable.add(new Bucket());
        }
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int hashKey = key % this.keySpace; 
        this.hashTable.get(hashKey).update(key, value);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int hashKey = key % this.keySpace;
        return this.hashTable.get(hashKey).get(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.keySpace; 
        this.hashTable.get(hashKey).remove(key);
    }
}
