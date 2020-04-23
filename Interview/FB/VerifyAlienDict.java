package Interview.FB;

public class VerifyAlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        
        if (words == null || words.length == 0) {
            return true;
        }
        
        if (order == null || order.length() == 0) {
            return true;
        }
        
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            
            if (!cmp(words[i], words[i + 1], index)) 
                return false;
        }
        
        return true;
    }
    
    private boolean cmp(String a, String b, int[] index) {
        
        int i = 0; 
        
        while (i < a.length() && i < b.length()) {
            
            if (index[a.charAt(i) - 'a'] == index[b.charAt(i) - 'a'])
                i++;
            
            else 
                break;
        }
        
        if (i < a.length() && i == b.length()) 
            return false;
        
        if (i < a.length() && i < b.length() 
            && index[a.charAt(i) - 'a'] > index[b.charAt(i) - 'a']) 
            return false;
        
        return true;
        
    }
}