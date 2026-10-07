import java.util.*;
class Solution {
    Set<String> result = new HashSet<>();
    int minRemovals = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int balance,
                     int removals, StringBuilder current) {

        if (removals > minRemovals) {
            return;
        }

        if (index == s.length()) {

            if (balance == 0) {

                if (removals < minRemovals) {
                    minRemovals = removals;
                    result.clear();
                }

                if (removals == minRemovals) {
                    result.add(current.toString());
                }
            }

            return;
        }

        char ch = s.charAt(index);
        if (ch != '(' && ch != ')') {
            current.append(ch);
            dfs(s, index + 1, balance, removals, current);
            current.deleteCharAt(current.length() - 1);
        }

        
        else if (ch == '(') {

            dfs(s, index + 1, balance, removals + 1, current);

            current.append(ch);

            dfs(s, index + 1, balance + 1, removals, current);

            current.deleteCharAt(current.length() - 1);
        }

        else {

            dfs(s, index + 1, balance, removals + 1, current);

            if (balance > 0) {

                current.append(ch);

                dfs(s, index + 1, balance - 1, removals, current);

                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}