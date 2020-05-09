package Interview.ByteDance;

public class LargestPathSumInMatrix {

    public int largestPathSumInMatrix(int[][] matrix) {


        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][m];
        int[][] memo = new int[m][n];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] seen = new boolean[m][n];
                res = Math.max(res, dfs(matrix, i, j, memo, visited, seen));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] memo, boolean[][] visited, boolean[][] seen) {

        if (visited[x][y] == true)
            return memo[x][y]; 

        int m = matrix.length, n = matrix[0].length; 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int res = matrix[x][y];

        for (int d = 0; d < 4; d++) {
            
            int nx = x + dx[d]; 
            int ny = y + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || seen[nx][ny] == true)
                continue;

            seen[nx][ny] = true;
            res = Math.max(res, matrix[x][y] + dfs(matrix, nx, ny, memo, visited, seen));
            seen[nx][ny] = false;
        }

        memo[x][y] = res;
        visited[x][y] = true;

        return memo[x][y];
    }
}