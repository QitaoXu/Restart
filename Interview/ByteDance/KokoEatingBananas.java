package Interview.ByteDance; 

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        
        int start = 1, end = 0; 
        
        for (int pile : piles) {
            
            end = Math.max(end, pile);
        }
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            if (canEat(piles, mid, H)) {
                end = mid;
            }
            
            else {
                start = mid;
            }
        }
        
        if (canEat(piles, start, H))
            return start;
        
        if (canEat(piles, end, H))
            return end;
        
        return -1;
        
    }
    
    private boolean canEat(int[] piles, int k, int h) {
        
        int hours = 0; 
        
        for (int pile : piles) {
            
            hours += pile % k == 0 ? pile / k : pile / k + 1;
            
            if (hours > h)
                return false;
        }
        
        return hours <= h;
        
    }
}