class Solution {
   

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0 ;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        if (check(grid, total) || check(reverse(grid), total)) {
            return true;
        }
        int[][] transpos = transpose(grid);
        return check(transpos, total) || check(reverse(transpos), total);
    }

    public boolean check(int[][] A, long total) {
        Set<Long> seen = new HashSet<>();
        int m = A.length;
        int n = A[0].length;
        long top = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top += (long) A[i][j];
                seen.add((long) A[i][j]);
            }
            long bottom = total - top;
            long diff = top - bottom;
            if (diff == 0)
                return true;

            if (diff == A[0][0] || diff == A[0][n - 1] || diff == A[i][0]) {
                return true;
            }
            if(n > 1  && i > 0 && seen.contains(diff)){
                return true ;
            }
        }
        return false;
    }

    private int[][] reverse(int[][] A) {
        int[][] res = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[A.length - 1 - i];
        }

        return res;
    }

    private int[][] transpose(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] res = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
}
