package Interview.FB;

public class LongestSubstringWithAtMostKCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if (s == null || s.length() == 0)
            return 0;
        
        int ans = Integer.MIN_VALUE; 
        int right = 0, left = 0; 
        int sum = 0; 
        char[] sa = s.toCharArray();
        int[] charCount = new int[256];
        
        for (right = 0; right < s.length(); right++) {
            
            charCount[sa[right]]++;
            
            if (charCount[sa[right]] == 1)
                sum++;
            
            while (sum > k) {
                
                charCount[sa[left]]--;
                if (charCount[sa[left]] == 0)
                    sum--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}