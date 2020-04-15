package Algo.Course1;

import java.util.*;

public class LongestPalindrome {

    public int getLongestPalindrome(String s) {

        if (s == null || s.length() == 0)
            return 0; 

        Set<Character> set = new HashSet<Character>(); 

        for (char c : s.toCharArray()) {
            if (set.contains(c)) 
                set.remove(c);
            else 
                set.add(c);
        }

        int odd = set.size(); 

        if (odd > 0) 
            odd -= 1;

        return s.length() - odd;
    }
}