package Interview.ByteDance;

public class AddStringsII {

    class ResultType {

        int carry;
        String ans; 

        public ResultType(int carry, String ans) {
            this.carry = carry;
            this.ans = ans;
        }
    }

    public String addStringsII(String num1, String num2) {

        if (num1.indexOf(".") == -1) {
            num1 = num1 + ".0";
        }

        if (num2.indexOf(".") == -1) {
            num2 = num2 + ".0";
        }

        String[] a = num1.split("\\.");
        String[] b = num2.split("\\.");

        ResultType decimal = addStrings(a[1], b[1], 0);
        ResultType integer = addStrings(a[0], b[0], decimal.carry);

        return integer.carry > 0 ? integer.carry + integer.ans + "." + decimal.ans : integer.ans + "." + decimal.ans;

    }

    public ResultType addStrings(String num1, String num2, int carry) {

        String ans = "";
        String a = num1;
        String b = num2; 

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {

            int sum = carry; 

            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0; 

            ans = sum % 10 + ans;
            carry = sum / 10;
        }

        return new ResultType(carry, ans);
    }
}