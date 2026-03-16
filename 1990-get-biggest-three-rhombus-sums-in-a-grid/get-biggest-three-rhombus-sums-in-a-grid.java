import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){

                // side = 0
                set.add(grid[r][c]);
                if(set.size() > 3) set.remove(set.first());

                for(int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++){

                    int sum = 0;

                    for(int k = 0; k < side; k++){

                        sum += grid[r - side + k][c + k];      // top -> right
                        sum += grid[r + k][c + side - k];      // right -> bottom
                        sum += grid[r + side - k][c - k];      // bottom -> left
                        sum += grid[r - k][c - side + k];      // left -> top
                    }

                    set.add(sum);

                    if(set.size() > 3){
                        set.remove(set.first());
                    }
                }
            }
        }

        int[] ans = new int[set.size()];
        int i = ans.length - 1;

        for(int val : set){
            ans[i--] = val; // reverse order
        }

        return ans;
    }
}