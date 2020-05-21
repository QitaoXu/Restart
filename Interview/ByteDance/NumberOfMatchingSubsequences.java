package Interview.ByteDance;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        
        int n = S.length();
        int[][] nextPos = new int[n][26];
        
        for (int j = 0; j < 26; j++) {
            nextPos[n - 1][j] = -1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            
            nextPos[i][S.charAt(i) - 'a'] = i;
            
            if (i == 0)
                break;
            
            for (int j = 0; j < 26; j++) {
                nextPos[i - 1][j] = nextPos[i][j];
            }
        }
        
        int ans = 0; 
        
        for (String word : words) {
            
            if (isSubsequence(word, nextPos))
                ans++;
        }
        
        return ans;
    }
    
    private boolean isSubsequence(String word, int[][] nextPos) {
        
        int wordLength = word.length();
        int sLength = nextPos.length;
        
        int i = 0, j = 0; 
        
        for (i = 0, j = 0; i < wordLength && j < sLength; i++, j++) {
            
            j = nextPos[j][word.charAt(i) - 'a'];
            
            if (j < 0)
                return false;
        }
        
        return i == wordLength;
    }
}