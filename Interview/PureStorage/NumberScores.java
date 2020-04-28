package Interview.PureStorage; 

import java.util.*; 

public class NumberScores {
	public int computeScores(int num) {

        int score = 0;
        int evenCount = 0; 
        int sevenCount = 0;
        int digitSum = 0;

        List<Integer> digits = new ArrayList<Integer>(); 

        while (num > 0) {

            int digit = num % 10; 

            if (digit % 2 == 0)
                evenCount += 1;

            if (digit == 7)
                sevenCount += 1; 

            digitSum += digit;
            digits.add(digit);

            num = num / 10;
            
        }
        score = evenCount * 4 + sevenCount * 1;

        if (digitSum % 3 == 0)
            score += 2;

        //score += consecutiveFives(digits);

        return score;

    }

    public List<Integer> getDigits(int num) {

        List<Integer> digits = new ArrayList<Integer>();

        if (num == 0) {
            digits.add(0);
            return digits;
        }

        while (num > 0) {

            int digit = num % 10; 

            digits.add(digit);

            num = num / 10;
        }

        return digits;
            
    }

    public List<Integer> consecutiveFives(List<Integer> digits) {

        Integer prevDigit = null; 
        int count = 0;
        List<Integer> consecutiveFiveLengthList = new ArrayList<Integer>();
        
        for (int i = 0; i < digits.size(); i++) {
        	
        	Integer digit = digits.get(i);
        	
        	if (prevDigit != null && prevDigit == 5 && digit == 5) {
        		count += 1;
        	}
        	
        	if ((prevDigit != null && prevDigit != 5) && digit == 5 
        			|| prevDigit == null && digit == 5) {
        		count = 1;
        	}
        	
        	if (digit != 5) {
        		if (count > 1) 
        			consecutiveFiveLengthList.add(count);
        		
        		count = 0;
        	}
        	
        	prevDigit = digit;
        		
        	
        }
        
        if (count > 1)
        	consecutiveFiveLengthList.add(count);

        return consecutiveFiveLengthList;
    }

    public int increasingCount(List<Integer> digits) {

        Integer prevDigit = null; 
        int count = 1;
        int res = 0;

        List<Integer> increasingSequenceLength = new ArrayList<Integer>();

        for (int i = 0; i < digits.size(); i++) {

            Integer digit = digits.get(i);

            if (prevDigit != null && prevDigit + 1 == digit) {
                count += 1;
            }

            if (prevDigit != null && prevDigit + 1 != digit) {
                increasingSequenceLength.add(count);
                count = 1;
            }

            prevDigit = digit;
        }
        
        int uniqueNumCount = digits.size();
        for (int length : increasingSequenceLength) {
        	if (length != 1) {
        		res += length * length;
        		uniqueNumCount -= length;
        	}
        }

        return res + uniqueNumCount;
    }

}