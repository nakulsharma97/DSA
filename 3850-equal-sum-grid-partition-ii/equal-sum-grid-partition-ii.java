class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
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
        int[][] tra = transpose(grid);
        return check(tra, total) || check(reverse(tra), total);
    }

    public boolean check(int[][] A, long total) {
        int m = A.length;
        int n = A[0].length;
        long upp =0 ;
        Set<Long> seen = new HashSet<>() ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
            seen.add((long)A[i][j]) ;         
            upp += (long)A[i][j] ;
            }
            long bottom = total - upp  ;
            long diff = upp -bottom ;
            if(diff == 0){
                return true ;
            }
            if(diff == A[0][0] || diff == A[0][n-1] || diff == A[i][0]){
                return true ;

            }
            if(n > 1 &&  i > 0 && seen.contains(diff) ){
                return true ;
            }
        }
        return false ;
    }

    public int[][] reverse (int [][] A){
        int n =A.length ;
        int m =A[0].length ;
        int [][] res = new int[n][m] ;
        for(int i = 0 ; i< n ;i++){
            res[i] = A[A.length -1 - i] ;
        }
        return res ;
    }

    public int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

}