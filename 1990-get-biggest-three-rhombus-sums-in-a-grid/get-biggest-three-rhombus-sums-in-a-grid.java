import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        int[][] d1 = new int[m][n];
        int[][] d2 = new int[m][n];

        // ↘ diagonal
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                d1[i][j] = grid[i][j];
                if(i-1 >= 0 && j-1 >= 0){
                    d1[i][j] += d1[i-1][j-1];
                }
            }
        }

        // ↙ diagonal
        for(int i = 0; i < m; i++){
            for(int j = n-1; j >= 0; j--){
                d2[i][j] = grid[i][j];
                if(i-1 >= 0 && j+1 < n){
                    d2[i][j] += d2[i-1][j+1];
                }
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){

                set.add(grid[r][c]);
                if(set.size() > 3) set.remove(set.first());

                for(int side = 1; r-side >= 0 && r+side < m && c-side >= 0 && c+side < n; side++){

                    int top_r = r-side, top_c = c;
                    int right_r = r, right_c = c+side;
                    int bottom_r = r+side, bottom_c = c;
                    int left_r = r, left_c = c-side;

                    int sum = 0;

                    sum += d1[right_r][right_c];
                    if(top_r-1 >= 0 && top_c-1 >= 0)
                        sum -= d1[top_r-1][top_c-1];

                    sum += d2[bottom_r][bottom_c];
                    if(right_r-1 >= 0 && right_c+1 < n)
                        sum -= d2[right_r-1][right_c+1];

                    sum += d1[bottom_r][bottom_c];
                    if(left_r-1 >= 0 && left_c-1 >= 0)
                        sum -= d1[left_r-1][left_c-1];

                    sum += d2[left_r][left_c];
                    if(top_r-1 >= 0 && top_c+1 < n)
                        sum -= d2[top_r-1][top_c+1];

                    sum -= (grid[top_r][top_c] + grid[right_r][right_c] +
                            grid[bottom_r][bottom_c] + grid[left_r][left_c]);

                    set.add(sum);
                    if(set.size() > 3) set.remove(set.first());
                }
            }
        }

        int[] ans = new int[set.size()];
        int i = ans.length - 1;

        for(int val : set){
            ans[i--] = val;
        }

        return ans;
    }
}