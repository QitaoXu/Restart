package Interview.FB; 

public class ValidatePalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        int left = 0, right = s.length() - 1; 
        
        while (left < right) {
            
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            
            left++;
            right--;
        }
        
        if (left >= right) 
            return true;
        
        return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
        
    }
    
    private boolean isSubPalindrome(String s, int left, int right) {
        
        while (left < right) {
            
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}