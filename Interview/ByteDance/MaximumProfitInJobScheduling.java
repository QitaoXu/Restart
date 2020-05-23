package Interview.ByteDance;

import java.util.*; 


class MaximumProfitInJobScheduling {
    class Job {
    
        int start;
        int end; 
        int profit; 
        
        public Job(int start, int end, int profit) {
            
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<Job>(); 
        
        for (int i = 0; i < startTime.length; i++) {
            
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        
        Collections.sort(jobs, new Comparator<Job>() {
            
            @Override 
            public int compare(Job a, Job b) {
                if (a.end != b.end)
                    return a.end - b.end;
                
                return a.start - b.start;
            }
        });
        
        TreeMap<Integer, Integer> endToMaxProfit = new TreeMap<Integer, Integer>(); 
        endToMaxProfit.put(jobs.get(0).end, jobs.get(0).profit);
        
        int max = jobs.get(0).profit; 
        
        for (int i = 1; i < jobs.size(); i++) {
            
            Job job = jobs.get(i); 
            
            Integer prevEnd = endToMaxProfit.floorKey(job.start); 
            
            if (prevEnd == null) {
                max = Math.max(max, job.profit);
                endToMaxProfit.put(job.end, max);
            }
            
            else {
                max = Math.max(max, job.profit + endToMaxProfit.get(prevEnd));
                endToMaxProfit.put(job.end, max);
            }
        }
        
        return max;
        
    }
}