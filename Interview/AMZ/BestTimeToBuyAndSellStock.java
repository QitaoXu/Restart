package Interview.AMZ;

public class BestTimeToBuyAndSellStock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        if (prices == null || prices.length == 0)
            return 0; 
            
        int profit = 0; 
        
        int leftMin = Integer.MAX_VALUE; 
        
        for (int price : prices) {
            
            leftMin = price < leftMin ? price : leftMin;
            profit = Math.max(price - leftMin, profit);
        }
        
        return profit;
    }
}