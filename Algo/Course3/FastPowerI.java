package Algo.Course3;

public class FastPowerI {

    public int getFastPowerRecursive(int x, int n) {

        if (n == 0) 
            return 1; 

        if (n % 2 == 0) {

            int tmp = getFastPowerRecursive(x, n / 2);
            return tmp * tmp;
        }

        else {

            int tmp = getFastPowerRecursive(x, n / 2); 
            return tmp * tmp * x;
        }
    }

    public int getFastPowerIterative(int x, int n) {

        if (n == 0) {
            return 1; 
        }

        int ans = 1, base = x;

        while (n != 0) {

            if (n % 2 == 1) {

                ans = ans * base;
            }

            base *= base;
            n /= 2;
        }

        return ans;
 
    }

}