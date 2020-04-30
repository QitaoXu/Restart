package Interview.AMZ;

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        if (board[x][y] == 'E') {
            dfsEmpty(board, x, y, visited);
        }
        
        else {
            board[x][y] = 'X';
        }
        
        return board;
    }
    
    private void dfsEmpty(char[][] board, int x, int y, boolean[][] visited) {
        
        if (Character.isDigit(board[x][y]))
            return;
        
        int m = board.length, n = board[0].length;
        
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; 
        int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
        
        
        visited[x][y] = true;
        
        for (int i = 0; i < 8; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
                continue;
                
            if (board[nx][ny] == 'M') {
                
                if (Character.isDigit(board[x][y])) 
                    board[x][y] = Character.forDigit(Character.digit(board[x][y], 10) + 1, 10);
                else
                    board[x][y] = '1';
            }
            
        }
        
        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
                    continue;
                dfsEmpty(board, nx, ny, visited);
            }
        }
        
    }
}