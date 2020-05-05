package Interview.AMZ;

import java.util.*; 

public class MeetingRoomsII {
    class Interval {

        int start;
        int end; 
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    class Point {
        
        int val; 
        boolean isStart;
        
        public Point(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
    }
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0)
            return 0;
        
        List<Point> points = new ArrayList<>(); 
        
        for (Interval interval : intervals) {
            
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        
        Collections.sort(points, new Comparator<Point>() {
            
            @Override
            public int compare(Point a, Point b) {
                if (a.val != b.val)
                    return a.val - b.val;
                    
                else 
                    return a.isStart == false ? -1 : 1;
            }
        });
        
        int res = 0;
        int running = 0; 
        
        for (Point point : points) {
            
            if (point.isStart) {
                running += 1;
            }
            
            else {
                running -= 1;
            }
            
            res = Math.max(res, running);
        }
        
        return res;
    }
}