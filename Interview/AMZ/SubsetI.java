package Interview.AMZ; 
import java.util.*; 

public class SubsetI {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (nums == null) 
            return results;
        
        Arrays.sort(nums);
        
        List<Integer> combination = new ArrayList<Integer>(); 
        
        dfs(nums, 0, combination, results);
        
        return results;
    }
    
    private void dfs(int[] nums, int startIndex, List<Integer> combination, List<List<Integer>> results) {
        
        results.add(new ArrayList<Integer>(combination)); 
        
        for (int i = startIndex; i < nums.length; i++) {
            
            combination.add(nums[i]);
            dfs(nums, i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}