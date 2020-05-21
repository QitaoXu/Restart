package Interview.ByteDance;

public class SortColors {
    public void sortColors(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return;
        
        int colorFrom = 0, colorTo = 0; 
        
        for (int color : nums) {
            
            colorTo = Math.max(color, colorTo);
        }
        
        sortColorHelper(nums, 0, nums.length - 1, colorFrom, colorTo);
    }
    
    private void sortColorHelper(int[] colors, int start, int end, int colorFrom, int colorTo) {
        
        if (start >= end || colorFrom >= colorTo)
            return;
        
        int colorMiddle = colorFrom + (colorTo - colorFrom) / 2;
        int left = start, right = end;
        
        while (left <= right) {
            
            while (left <= right && colors[left] <= colorMiddle) {
                left++;
            }
            
            while (left <= right && colors[right] > colorMiddle) {
                right--;
            }
            
            if (left <= right) {
                
                int tempColor = colors[left];
                colors[left] = colors[right];
                colors[right] = tempColor;
                left++;
                right--;
            }
        }
        
        sortColorHelper(colors, start, right, colorFrom, colorMiddle);
        sortColorHelper(colors, left, end, colorMiddle + 1, colorTo);
    }
}