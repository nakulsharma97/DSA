import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];

        int[] dr = {0, 1, 0, -1}; // Right, Down, Left, Up
        int[] dc = {1, 0, -1, 0};

        int row = 0;
        int col = 0;
        int dir = 0;

        for (int count = 0; count < m * n; count++) {

            result.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];

            if (nextRow < 0 || nextRow >= m ||
                nextCol < 0 || nextCol >= n ||
                visited[nextRow][nextCol]) {

                dir = (dir + 1) % 4;
            }

            row += dr[dir];
            col += dc[dir];
        }

        return result;
    }
}