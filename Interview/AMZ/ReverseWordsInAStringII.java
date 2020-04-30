package Interview.AMZ; 

public class ReverseWordsInAStringII {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        int pre = 0;
        for (int i = 0; i <= str.length; i++) {
            
            if (i == str.length || str[i] == ' ') {
                swap(str, pre, i - 1);
                pre = i + 1;
            }
        }
        
        swap(str, 0, str.length - 1);
        
        return str;
    }
    
    private void swap(char[] str, int start, int end) {
        
        while (start < end) {
            
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp; 
            start++;
            end--;
        }
    }
}