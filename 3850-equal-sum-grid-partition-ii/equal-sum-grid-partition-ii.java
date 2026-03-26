import java.util.*;

class Solution {

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;

        // Calculate total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // Check original and reversed rows
        if (check(grid, total) || check(reverseRows(grid), total)) {
            return true;
        }

        // Transpose and check again
        int[][] transposed = transpose(grid);
        return check(transposed, total) || check(reverseRows(transposed), total);
    }

    private boolean check(int[][] A, long total) {
        Set<Long> seen = new HashSet<>();
        long top = 0;

        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++) {

            // Add row values
            for (int val : A[i]) {
                seen.add((long) val);
                top += val;
            }

            long bottom = total - top;
            long diff = top - bottom;

            // Case 1: Perfect partition
            if (diff == 0) return true;

            // Case 2: Edge conditions
            if (diff == A[0][0] || diff == A[0][cols - 1] || diff == A[i][0]) {
                return true;
            }

            // Case 3: Removing one element from top part
            if (cols > 1 && i > 0 && seen.contains(diff)) {
                return true;
            }
        }

        return false;
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

    private int[][] reverseRows(int[][] A) {
        int[][] res = new int[A.length][];

        for (int i = 0; i < A.length; i++) {
            res[i] = A[A.length - 1 - i];
        }

        return res;
    }
}