package Algo.Course3;

public class FastPowerII {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        
        boolean isNegative = false;
        
        if (n < 0) {
            
            x = 1 / x;
            n = -(n + 1);
            isNegative = true;
        }
        
        double ans = 1, base = x; 
        
        while (n != 0) {
            
            if (n % 2 == 1) {
                ans *= base;
            }
            
            base *= base; 
            n /= 2;
        }
        
        if (isNegative) {
            ans = ans * x;
        }
        
        return ans;
    }
}