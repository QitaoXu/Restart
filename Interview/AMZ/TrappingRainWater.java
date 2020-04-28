package Interview.AMZ;
public class TrappingRainWater {
    public int trap(int[] height) {
        
        if (height == null || height.length == 0)
            return 0; 
        
        int left = 0, right = height.length - 1; 
        int leftMax = height[left], rightMax = height[right];
        int water = 0; 
        
        while (left < right) {
            
            if (height[left] < height[right]) {
                
                if (height[left] < leftMax) {
                    water += leftMax - height[left];
                }
                
                else {
                    leftMax = height[left];
                }
                
                left++;
            }
            
            else {
                
                if (height[right] < rightMax) {
                    water += rightMax - height[right];
                }
                
                else {
                    rightMax = height[right];
                }
                
                right--;
            }
        }
        
        return water;
    }
}