package Interview.BB;

import java.util.*; 

public class BBPlayGround {

    public static void main(String[] args) {

        CoinChangeIII ccIII = new CoinChangeIII();
        int[] coins = {1, 2, 5};
        int amount = 5;

        List<List<Integer>> results = ccIII.coinChangeCombinations(amount, coins);

        for (List<Integer> combination : results) {

            for (int coin : combination) {
                System.out.print(coin + " ");
            }
            System.out.println("");
        }
    }
}