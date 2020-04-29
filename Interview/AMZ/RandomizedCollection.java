package Interview.AMZ;
import java.util.*;
import java.util.Random; 

public class RandomizedCollection {
    
    List<Integer> nums; 
    Map<Integer, LinkedHashSet<Integer>> numToIndexSet;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
        this.nums = new ArrayList<Integer>();
        this.numToIndexSet = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.rand = new Random();
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        boolean alreadyExisted = numToIndexSet.containsKey(val);
        
        if (!alreadyExisted) {
            numToIndexSet.put(val, new LinkedHashSet<Integer>());
        }
        
        numToIndexSet.get(val).add(nums.size());
        nums.add(val);
        return !alreadyExisted;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if (!numToIndexSet.containsKey(val))
            return false;
        
        LinkedHashSet<Integer> valSet = numToIndexSet.get(val);
        int indexToReplace = valSet.iterator().next();
        
        int last = nums.get(nums.size() - 1);
        LinkedHashSet<Integer> lastSet = numToIndexSet.get(nums.get(nums.size() - 1));
        
        nums.set(indexToReplace, last);
        valSet.remove(indexToReplace);
        
        if (indexToReplace < nums.size() - 1) {
            
            lastSet.remove(nums.size() - 1);
            lastSet.add(indexToReplace);
        }
        
        nums.remove(nums.size() - 1);
        if (valSet.isEmpty())
            numToIndexSet.remove(val);
        
        return true;
        
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
