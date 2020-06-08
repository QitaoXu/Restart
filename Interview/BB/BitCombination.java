package Interview.BB;

import java.util.*; 


public class BitCombination {

    public List<String> getBitCombinations(String bits) {

        List<String> results = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        dfs(bits, 0, path, results);

        return results;
    }

    private void dfs(String bits, int index, StringBuilder path, List<String> results) {

        if (index == bits.length()) {

            results.add(path.toString());
            return;
        }

        if (bits.charAt(index) == '?') {

            path.append('1');
            dfs(bits, index + 1, path, results);
            path.deleteCharAt(path.length() - 1);

            path.append('0');
            dfs(bits, index + 1, path, results);
            path.deleteCharAt(path.length() - 1);
        }

        else {

            path.append(bits.charAt(index));
            dfs(bits, index + 1, path, results);
            path.deleteCharAt(path.length() - 1);
        }
    }
}