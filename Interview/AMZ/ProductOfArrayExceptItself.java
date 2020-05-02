package Interview.AMZ;

public class ProductOfArrayExceptItself {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        
        int[] ans = new int[nums.length]; 
        
        ans[0] = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        
        int R = 1; 
        
        for (int i = nums.length - 1; i >= 0; i--) {
            
            ans[i] = ans[i] * R; 
            R = R * nums[i];
        }
        
        return ans;
    }
}