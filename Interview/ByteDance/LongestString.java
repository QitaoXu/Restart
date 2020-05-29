package Interview.ByteDance; 

public class LongestString {

    public String findLongestWord(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int longest = 0;
        int offset = 0; 
        int start = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) {

            if (i != 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') // "  performance  "
                continue;

            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                
                System.out.println("i = " + i);
                System.out.println(s.substring(start, i));

                
                if (i - start > longest) {

                    longest = i - start; 
                    offset = start; 
                
                    res = i != s.length() - 1 ? s.substring(offset, i) : s.substring(offset, i + 1);
                }

                
                start = i + 1;
                    
                
            }
        }

        return res;
    }
}