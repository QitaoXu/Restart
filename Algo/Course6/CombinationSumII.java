package Algo.Course6; 
import java.util.*; 

public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<List<Integer>>(); 
        
        if (num == null || num.length == 0) {
            return results;
        }
        
        Arrays.sort(num); 
        
        List<Integer> combination = new ArrayList<Integer>(); 
        int startIndex = 0; 
        
        dfs(num, startIndex, combination, target, results);
        
        return results;
    }
    
    private void dfs(int[] nums,
                     int startIndex, 
                     List<Integer> combination, 
                     int target, 
                     List<List<Integer>> results) {
        
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }   
        
        
        for (int index = startIndex; index < nums.length; index++) {
            
            if (target - nums[index] < 0)
                break;
                
            if (index != startIndex && nums[index] == nums[index - 1])
                continue;
                
            combination.add(nums[index]);
            dfs(nums, index + 1, combination, target - nums[index], results);
            combination.remove(combination.size() - 1);
        }
    }
}