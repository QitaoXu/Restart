package Interview.AMZ;

import java.util.*; 

public class Permutation {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        
        if (nums == null)
            return new ArrayList<List<Integer>>();
        
        List<Integer> permutation = new ArrayList<Integer>(); 
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        
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
                
            permutation.add(nums[i]);
            visited[i] = true;
            
            dfs(nums, permutation, visited, results);
            
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}