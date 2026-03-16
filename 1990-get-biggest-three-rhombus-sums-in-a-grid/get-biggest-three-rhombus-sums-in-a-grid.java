import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // side = 0
                set.add(grid[r][c]);

                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {

                    int sum = 0;

                    for (int k = 0; k < side; k++) {

                        // top -> right
                        sum += grid[r - side + k][c + k];

                        // right -> bottom
                        sum += grid[r + k][c + side - k];

                        // bottom -> left
                        sum += grid[r + side - k][c - k];

                        // left -> top
                        sum += grid[r - k][c - side + k];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {
            if (i == size) break;
            ans[i++] = val;
        }

        return ans;
    }
}