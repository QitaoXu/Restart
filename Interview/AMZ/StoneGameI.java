package Interview.AMZ;

public class StoneGameI {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(piles[i], piles[i + 1]);
        }
        
        for (int i = 0; i < n; i++) {
            
            for (int size = 3; i + size - 1 < n; size++) {
                
                int j = i + size - 1;
                int turn = (i + j + n) % 2;
                
                if (turn == 1) { // Alex's turn
                    
                    dp[i][j] = Math.max(dp[i + 1][j] + piles[i], dp[i][j - 1] + piles[j]);
                }
                
                else { // Lee's turn
                    
                    dp[i][j] = Math.min(dp[i + 1][j] - piles[i], dp[i][j - 1] - piles[j]);
                }
            }
        }
        
        return dp[0][n - 1] > 0;
    }
}