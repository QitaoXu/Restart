package Interview.FB;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    long dist;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y; 
        this.dist = x * x + y * y;
    }
    
    @Override 
    public int compareTo(Point that) {
        
        if (this.dist != that.dist) 
            return (int)(that.dist - this.dist);
        
        else if (this.x != that.x) 
            return that.x - this.x; 
        
        else 
            return that.y - this.y;
    }
}

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        
        int[][] res = new int[K][2];
        PriorityQueue<Point> priorityQueue = new PriorityQueue<Point>();
        
        for (int[] p : points) {
            
            Point point = new Point(p[0], p[1]);
            priorityQueue.offer(point); 
            
            if (priorityQueue.size() > K) {
                priorityQueue.poll();
            }
        }
        
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();
            res[index][0] = point.x;
            res[index][1] = point.y;
            index++;
        }
        
        return res;
        
    }
}