package Interview.ByteDance;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        int res = 1; 
        int[][] memo = new int[m][n];
        boolean[][] visited = new boolean[m][n]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                res = Math.max(res, dfs(matrix, i, j, memo, visited));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, 
                    int i, 
                    int j, 
                    int[][] memo,
                    boolean[][] visited) {
        
        if (visited[i][j] == true)
            return memo[i][j]; 
        
        int m = matrix.length, n = matrix[0].length;
        memo[i][j] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (int d = 0; d < 4; d++) {
            
            int nx = i + dx[d];
            int ny = j + dy[d];
            
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[i][j])
                continue;
            
            memo[i][j] = Math.max(memo[i][j], 1 + dfs(matrix, nx, ny, memo, visited)); 
            
        }
        
        visited[i][j] = true;
        return memo[i][j];
    }
}