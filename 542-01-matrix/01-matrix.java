class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }
        int row = mat.length;
        int col = mat[0].length;
        int maxvalue = row * col;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                } else {
                    mat[i][j] = maxvalue;
                }
            }
        }
            int[][] direction = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
            while (!q.isEmpty()) {
                int[] cell = q.poll();
                for (int[] dir : direction) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r >= 0 && r < row && c >= 0 && c < col && mat[r][c] > mat[cell[0]][cell[1]] + 1  ) {
                        q.offer(new int[] { r, c });
                        mat[r][c] = mat[cell[0]][cell[1]] +  1;

                    }
                }

            
        }
        return mat ;
    }
}