package Interview.BB; 

import java.util.*; 

public class CoinChangeIII {

    public List<List<Integer>> coinChangeCombinations(int amount, int[] coins) {
        
        List<List<Integer>> results = new ArrayList<>();

        List<Integer> combination = new ArrayList<>();

        dfs(coins, amount, 0, combination, results);

        return results;

    }

    private void dfs(int[] coins, int target, int index, List<Integer> combination, List<List<Integer>> results) {

        if (target == 0) {

            results.add(new ArrayList<Integer>(combination));
            return;
        }

        if (index == coins.length)
            return; 

        for (int i = index; i < coins.length; i++) {

            int coin = coins[i];
            if (target - coin < 0)
                break;

            combination.add(coin);
            dfs(coins, target - coin, i, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}