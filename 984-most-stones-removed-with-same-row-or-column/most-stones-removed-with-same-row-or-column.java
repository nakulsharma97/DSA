import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] &&
                            (stones[curr][0] == stones[j][0] ||
                             stones[curr][1] == stones[j][1])) {
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }

        return n - components;
    }
}