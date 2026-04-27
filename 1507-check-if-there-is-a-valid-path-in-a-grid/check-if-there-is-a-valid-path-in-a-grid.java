import java.util.*;

class Solution {

    int m, n;

    // SAME format as your code (no change)
    int[][][] directions = {
        {}, // 0 unused
        {{0, -1}, {0, 1}},   // 1
        {{-1, 0}, {1, 0}},   // 2
        {{0, -1}, {1, 0}},   // 3
        {{0, 1}, {1, 0}},    // 4
        {{0, -1}, {-1, 0}},  // 5
        {{-1, 0}, {0, 1}}    // 6
    };

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        return dfs(grid, 0, 0, vis);
    }

    private boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {

        if (i == m - 1 && j == n - 1)
            return true;

        vis[i][j] = true;

        for (int[] dir : directions[grid[i][j]]) {

            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || nj < 0 || ni >= m || nj >= n || vis[ni][nj])
                continue;

            // check reverse connection (same logic, cleaner)
            if (canGoBack(grid, ni, nj, i, j)) {
                if (dfs(grid, ni, nj, vis))
                    return true;
            }
        }
        return false;
    }

    private boolean canGoBack(int[][] grid, int ni, int nj, int i, int j) {

        for (int[] back : directions[grid[ni][nj]]) {
            if (ni + back[0] == i && nj + back[1] == j)
                return true;
        }
        return false;
    }
}