package Interview.FB; 

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String ans = ""; 
        int carry = 0;
        String a = num1;
        String b = num2;
        
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            
            ans = sum % 10 + ans;
            carry = sum / 10;
        }
        
        if (carry != 0) {
            ans = carry + ans;
        }
        
        return ans;
    }
}