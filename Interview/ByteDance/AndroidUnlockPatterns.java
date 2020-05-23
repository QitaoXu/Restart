package Interview.ByteDance; 

class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[3][9] = skip[9][3] = 6;
        skip[9][7] = skip[7][9] = 8; 
        skip[7][1] = skip[1][7] = 4;
        skip[1][9] = skip[9][1] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[4][6] = skip[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        
        int res = 0;
        
        for (int i = m; i <= n; i++) {
            
            res += dfs(skip, visited, 1, i - 1) * 4;
            res += dfs(skip, visited, 2, i - 1) * 4;
            res += dfs(skip, visited, 5, i - 1);
        }
        
        return res;
    }
    
    private int dfs(int[][] skip, boolean[] visited, int curt, int remain) { 
        
        if (remain == 0)
            return 1;
        
        visited[curt] = true;
        
        int res = 0;
        
        for (int i = 1; i <= 9; i++) {
            
            if (visited[i] == false && (skip[curt][i] == 0 || visited[skip[curt][i]] == true))
                res += dfs(skip, visited, i, remain - 1);
        }
        
        visited[curt] = false;
        
        return res;
    }
}