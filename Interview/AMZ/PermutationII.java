package Interview.AMZ;

import java.util.*; 

public class PermutationII {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        
        if (nums == null)
            return new ArrayList<List<Integer>>(); 
            
        Arrays.sort(nums); 
        
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, permutation, visited, results);
        
        return results;
    }
    
    private void dfs(int[] nums,
                     List<Integer> permutation, 
                     boolean[] visited, 
                     List<List<Integer>> results) {
                         
        
        if (permutation.size() == nums.length) {
            
            results.add(new ArrayList<Integer>(permutation));
            return;
        } 
        
        for (int i = 0; i < nums.length; i++) {
            
            if (visited[i] == true)
                continue;
                
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)
                continue;
                
            permutation.add(nums[i]);
            visited[i] = true; 
            
            dfs(nums, permutation, visited, results);
            
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
};