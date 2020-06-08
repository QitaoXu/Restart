package Interview.BB;

import java.util.*; 
class TestPoint{

    int x;
    int y;

    public TestPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object that) {

        if (that == this)
            return true; 

        if (that == null)
            return false;

        if (!(that instanceof TestPoint)) {

            return false;
        }

        TestPoint thatTestPoint = (TestPoint) that;
        return Integer.compare(this.x, thatTestPoint.x) == 0 && Integer.compare(this.y, thatTestPoint.y) == 0;
        
    }
}

public class BBPlayGround {

    public static void main(String[] args) {

        // CoinChangeIII ccIII = new CoinChangeIII();
        // int[] coins = {1, 2, 5};
        // int amount = 5;

        // List<List<Integer>> results = ccIII.coinChangeCombinations(amount, coins);

        // for (List<Integer> combination : results) {

        //     for (int coin : combination) {
        //         System.out.print(coin + " ");
        //     }
        //     System.out.println("");
        // }

        String test = "aabbbbac";
        CandyCrushII candyCrushII = new CandyCrushII(); 

        System.out.println(candyCrushII.deleteExtra(test));

        BitCombination bc = new BitCombination();
        String bits = "11?1?0";

        List<String> bitsCombination = bc.getBitCombinations(bits);

        for (String combination : bitsCombination) {
            System.out.println(combination);
        }

        HashSet<TestPoint> set = new HashSet<>();

        TestPoint a = new TestPoint(1, 1);
        set.add(a);

        TestPoint b = new TestPoint(1, 1);

        System.out.println(set.contains(b));
    }
}