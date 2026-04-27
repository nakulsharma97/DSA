class Solution {

    // directions: up, right, down, left
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        return dfs(grid, 0, 0, vis);
    }

    private boolean dfs(int[][] grid, int r, int c, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;
        
        if (r == m - 1 && c == n - 1) return true;
        
        vis[r][c] = true;

        for (int d : getDirections(grid[r][c])) {
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) continue;

            // check reverse connection
            if (isConnected(grid[nr][nc], (d + 2) % 4)) {
                if (dfs(grid, nr, nc, vis)) return true;
            }
        }
        return false;
    }

    private int[] getDirections(int type) {
        switch (type) {
            case 1: return new int[]{1, 3}; // right, left
            case 2: return new int[]{0, 2}; // up, down
            case 3: return new int[]{3, 2}; // left, down
            case 4: return new int[]{1, 2}; // right, down
            case 5: return new int[]{3, 0}; // left, up
            case 6: return new int[]{1, 0}; // right, up
        }
        return new int[]{};
    }

    private boolean isConnected(int type, int dir) {
        for (int d : getDirections(type)) {
            if (d == dir) return true;
        }
        return false;
    }
}