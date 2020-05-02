package Interview.AMZ;
import java.util.*; 

public class MostFrequentSubtreeSum {
    
    /**
     * @param root: the root
     * @return: all the values with the highest frequency in any order
     */
    public int[] findFrequentTreeSum(TreeNode root) {
    
        // Write your code here
        
        if (root == null)
            return new int[0];
        
        Map<Integer, Integer> sumToCount = new HashMap<Integer, Integer>();
        int[] countAndMaxFreq = {0, 0};
        
        getSum(root, sumToCount, countAndMaxFreq);
        
        int count = countAndMaxFreq[0];
        int maxFreq = countAndMaxFreq[1];
        
        int[] res = new int[count]; 
        int i = 0;
        
        for (Integer sum : sumToCount.keySet()) {
            
            if (sumToCount.get(sum) == maxFreq) {
                res[i++] = sum;
            }
        }
        
        return res;
    }
    
    private int getSum(TreeNode root, Map<Integer, Integer> sumToCount, int[] countAndMaxFreq) {
        
        if (root == null) 
            return 0;
            
        int leftSum = getSum(root.left, sumToCount, countAndMaxFreq);
        int rightSum = getSum(root.right, sumToCount, countAndMaxFreq);
        
        int sum = leftSum + root.val + rightSum;
        
        sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        
        if (sumToCount.get(sum) > countAndMaxFreq[1]) {
            
            countAndMaxFreq[1] = sumToCount.get(sum);
            countAndMaxFreq[0] = 1;
        }
        
        else if (sumToCount.get(sum) == countAndMaxFreq[1]) {
            countAndMaxFreq[0] += 1;
        }
        
        return sum;
        
    }
}