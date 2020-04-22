package Algo.Course5; 

public class RainbowSort {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) 
            return;
        
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void rainbowSort(int[] colors, 
                             int start, 
                             int end, 
                             int colorFrom, 
                             int colorTo) {
                                 
        if (start >= end)
            return; 
            
        if (colorFrom >= colorTo)
            return; 
            
        int left = start, right = end; 
        int colorMid = colorFrom + (colorTo - colorFrom) / 2; 
        
        while (left <= right) {
            
            while (left <= right && colors[left] <= colorMid) {
                left++;
            }
            
            while (left <= right && colors[right] > colorMid) {
                right--;
            }
            
            if (left <= right) {
                int color = colors[left];
                colors[left] = colors[right];
                colors[right] = color;
                left++;
                right--;
            }
        }
        
        rainbowSort(colors, start, right, colorFrom, colorMid);
        rainbowSort(colors, left, end, colorMid + 1, colorTo);
                                 
    }
}