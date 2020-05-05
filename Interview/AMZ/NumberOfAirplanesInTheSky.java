package Interview.AMZ;

import java.util.*; 

public class NumberOfAirplanesInTheSky {
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
        boolean isLanding;
        
        public Point(int val, boolean isLanding) {
            this.val = val; 
            this.isLanding = isLanding;
        }
    }
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        
        if (airplanes == null || airplanes.size() == 0)
            return 0; 
            
        List<Point> points = new ArrayList<>(); 
        
        for (Interval airplane : airplanes) {
            
            points.add(new Point(airplane.start, false));
            points.add(new Point(airplane.end, true));
            
        }
        
        Collections.sort(points, new Comparator<Point>() {
            
            @Override
            public int compare(Point a, Point b) {
                if (a.val != b.val)
                    return a.val - b.val;
                    
                else 
                    return a.isLanding ? -1 : 1;
            }
        });
        
        int res = 0;
        int curt = 0; 
        
        for (Point point : points) {
            
            if (point.isLanding) {
                curt -= 1;
            }
            
            else {
                curt += 1;
            }
            
            res = Math.max(res, curt);
        }
        
        return res;
    }
}