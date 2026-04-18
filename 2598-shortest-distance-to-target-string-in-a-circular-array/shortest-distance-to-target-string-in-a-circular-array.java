import java.util.*;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {

                int straight = Math.abs(i - startIndex);
                int circular = n - straight;

                int dist = Math.min(straight, circular);

                result = Math.min(result, dist);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}