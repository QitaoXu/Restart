package Interview.ByteDance; 

import java.util.*; 

public class MeetingRoomsI {

    class Interval {
        int start;
        int end; 

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        
        if (intervals == null || intervals.size() == 0)
            return true;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            
            @Override
            public int compare(Interval a, Interval b) {
                
                if (a.start != b.start)
                    return a.start - b.start;
                    
                return a.end - b.end;
            }
            
        });
        
        Interval prev = null; 
        
        for (Interval interval : intervals) {
            
            if (prev != null && prev.end > interval.start)
                return false;
                
            prev = interval;
        }
        
        return true;
    }
}