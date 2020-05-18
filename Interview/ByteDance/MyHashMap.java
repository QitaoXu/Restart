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

class Bucket<U, V> {
    
    private List<Pair<U, V>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<U, V>>();
    }
    
    public V get(U key) {
        
        for (Pair<U, V> pair : bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        
        return null;
    }
    
    public void update(U key, V val) {
        boolean found = false; 
        
        for (Pair<U, V> pair : bucket) {
            if (pair.first.equals(key)) {
                pair.second = val; 
                found = true;
                break;
            }
        }
        
        if (!found) {
            bucket.add(new Pair<U, V>(key, val));
        }
    }
    
    public void remove(U key) {
        
        for (Pair<U, V> pair : bucket) {
            
            if (pair.first.equals(key)) {
                bucket.remove(pair);
                break;
            }
        }
    }
}

public class MyHashMap<U, V> {
    
    private List<Bucket<U, V>> hashTable;
    private int keySpace;

    /** Initialize your data structure here. */
    public MyHashMap() {
        
        this.keySpace = 2069; 
        this.hashTable = new ArrayList<Bucket<U, V>>(); 
        
        for (int i = 0; i < 2069; i++) {
            this.hashTable.add(new Bucket<U, V>());
        }
        
    }
    
    /** value will always be non-negative. */
    public void put(U key, V value) {
        
        int hashKey = key.hashCode() % this.keySpace; 
        this.hashTable.get(hashKey).update(key, value);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(U key) {
        
        int hashKey = key.hashCode() % this.keySpace;
        return this.hashTable.get(hashKey).get(key) == null ? -1 : (int)this.hashTable.get(hashKey).get(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(U key) {
        int hashKey = key.hashCode() % this.keySpace; 
        this.hashTable.get(hashKey).remove(key);
    }
}
