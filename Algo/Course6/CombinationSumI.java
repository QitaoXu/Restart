package Algo.Course6; 
import java.util.*; 

public class CombinationSumI {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        
        List<Integer> combination = new ArrayList<Integer>(); 
        int startIndex = 0;
        Arrays.sort(candidates);
        dfs(candidates, combination, startIndex, target, results);
        
        return results;
    }
    
    private void dfs(int[] nums,
                     List<Integer> combination, 
                     int startIndex, 
                     int target, 
                     List<List<Integer>> results) {
            
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        
        for (int index = startIndex; index < nums.length; index++) {
            
            if (target - nums[index] < 0)
                break;
                
            if (index != 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            
            combination.add(nums[index]);
            dfs(nums, combination, index, target - nums[index], results);
            combination.remove(combination.size() - 1);
        }
        
    }
}