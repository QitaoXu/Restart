package Algo.Course3;

class ArrayReader {

    int[] array; 

    public ArrayReader () {
        this.array = new int[1000];
    }

    public int get(int k) {
        if (k >= array.length) 
            return Integer.MAX_VALUE;
        return array[k];
    }

}

public class SearchInBigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        
        int start = 0, end = 1; 
        
        while (reader.get(end) < target) {
            end = end << 1;
        }
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            if (reader.get(mid) < target) 
                start = mid;
                
            else 
                end = mid;
        }
        
        if (reader.get(start) == target) 
            return start;
            
        if (reader.get(end) == target) 
            return end;
            
        return -1;
    }
}