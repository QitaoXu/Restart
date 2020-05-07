package Interview.AMZ;

import java.util.*; 

public class MazeII {
    class Point {
        
        int x;
        int y;
        int step;
        
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || maze.length == 0)
            return -1;
        
        int m = maze.length, n = maze[0].length;
        
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(start[0], start[1], 0));
        int[][] distance = new int[m][n];
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {
            
            Point point = queue.poll(); 
            
            if (point.step >= distance[point.x][point.y])
                continue;
            
            distance[point.x][point.y] = point.step;
            
            for (int i = 0; i < 4; i++) {
                
                int nx = point.x;
                int ny = point.y; 
                int step = point.step;
                
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    step += 1;
                }
                
                nx -= dx[i];
                ny -= dy[i];
                step -= 1;
                
                queue.offer(new Point(nx, ny, step));
            }
        }
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}