package Interview.AMZ; 

import java.util.*; 

import java.util.Random;

public class RandomizedSet {
    
    List<Integer> nums; 
    Map<Integer, Integer> numToIndex;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
        this.nums = new ArrayList<Integer>();
        this.numToIndex = new HashMap<Integer, Integer>();
        this.rand = new Random();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (numToIndex.containsKey(val))
            return false;
        
        numToIndex.put(val, nums.size());
        nums.add(val);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if (!numToIndex.containsKey(val))
            return false;
        
        int index = numToIndex.get(val);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1); 
            nums.set(index, last);
            numToIndex.put(last, index);
        }
        numToIndex.remove(val);
        nums.remove(nums.size() - 1);
        
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        return nums.get(rand.nextInt(nums.size()));
        
    }
}