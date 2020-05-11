package Interview.ByteDance;
import java.util.*; 

public class SwimInRisingWater {
    
    class Point {
        
        int x; 
        int y; 
        int t;
        
        public Point (int x, int y, int t) {
            this.x = x;
            this.y = y; 
            this.t = t;
        }
    }
    
    public int swimInWater(int[][] grid) {
        
        int n = grid.length; 
        
        Queue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            
            @Override
            public int compare(Point a, Point b) {
                return a.t - b.t;
            }
        });
        
        boolean[][] visited = new boolean[n][n]; 
        
        queue.offer(new Point(0, 0, grid[0][0]));
        visited[0][0] = true;
        
        int res = 0; 
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0}; 
        
        while (!queue.isEmpty()) {
            
            Point point = queue.poll(); 
            res = Math.max(res, point.t); 
            
            if (point.x == n - 1 && point.y == n - 1)
                return res;
            
            for (int i = 0; i < 4; i++) {
                
                int nx = point.x + dx[i];
                int ny = point.y + dy[i]; 
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] == true) 
                    continue;
                
                queue.offer(new Point(nx, ny, grid[nx][ny]));
                visited[nx][ny] = true;
                    
            }
        }
        
        return -1;
    }
}