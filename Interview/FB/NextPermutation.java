package Interview.FB;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return; 
        
        int i = nums.length - 1; 
        
        while (i > 0 && nums[i] <= nums[i - 1])
            i--;
        
        if (i != 0) {
            int j = nums.length - 1; 
            
            while (j > i && nums[j] <= nums[i - 1])
                j--;
            
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }
        
        this.reverse(nums, i, nums.length - 1);
            
    }
    
    private void reverse(int[] nums, int start, int end) {
        
        
        while (start < end) {
            
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}