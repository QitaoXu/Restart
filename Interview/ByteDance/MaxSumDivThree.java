package Interview.ByteDance;

public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        
        int min1 = Integer.MAX_VALUE / 2, min2 = Integer.MAX_VALUE / 2, res = 0; 
        
        for (int num : nums) {
            
            res += num;
            
            if (num % 3 == 1) {
                
                min2 = Math.min(min2, min1 + num);
                min1 = Math.min(min1, num);
                
            } else if (num % 3 == 2) {
                
                min1 = Math.min(min1, min2 + num);
                min2 = Math.min(min2, num);
                
            }
        }
        
        if (res % 3 == 1)
            return res - min1;
        
        else if (res % 3 == 2)
            return res - min2;
        
        else
            return res;
        
    }
}