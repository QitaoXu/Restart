package Algo.Course6; 
import java.util.*; 

public class KSumII {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (A == null || A.length < k) 
            return results;
            
        Arrays.sort(A);
        List<Integer> combination = new ArrayList<Integer>();
        
        dfs(A, 0, combination, target, k, results);
        
        return results;
    }
    
    private void dfs(int[] nums, 
                     int startIndex, 
                     List<Integer> combination, 
                     int target, 
                     int k, 
                     List<List<Integer>> results) {
        
        if (k == 0) {
            if (target == 0) {
                results.add(new ArrayList<Integer>(combination));
            }
            return;
        }
        
        for (int i = startIndex; i < nums.length - k + 1; i++) {
            
            if (target - nums[i] < 0) 
                break;
                
            if (i != startIndex && nums[i] == nums[i - 1])
                continue;
                
            combination.add(nums[i]);
            dfs(nums, i + 1, combination, target - nums[i], k - 1, results);
            combination.remove(combination.size() - 1);
            
        }
                         
    }
}