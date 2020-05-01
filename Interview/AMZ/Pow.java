package Interview.AMZ;

public class Pow {
    public double myPow(double x, int n) {
        
        boolean isNegative = false; 
        
        if (n < 0) {
            
            x = 1 / x; 
            n = -(n + 1);
            isNegative = true;
        }
        
        double ans = 1, base = x;
        
        while (n > 0) {
            
            if (n % 2 == 1)
                ans = ans * base;
            
            base = base * base;
            n = n / 2;
        }
        
        if (isNegative) {
            
            ans = ans * x;
        }
        
        return ans;
    }
}