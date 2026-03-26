class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length  ;
        int m = grid[0].length ;
        long rows[] = new long[n] ;
        long cols[] = new long[m] ;
        long total = 0 ;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0  ; j < m ;j++){
                total += grid[i][j] ;

                rows[i] += grid[i][j] ;
                cols[j] += grid[i][j] ;
            }

        }
        if(total % 2 != 0){
            return false ;
        }
        // for upper 

        long upper = 0 ;
        for(int i = 0 ; i < n -1 ;i++){
           upper += rows[i] ;
           if(upper == total - upper){
            return true ;
           }
        }
         long left = 0 ;
        for(int i = 0 ; i < m -1 ;i++){
           left += cols[i] ;
           if(left == total - left){
            return true ;
           }
        }
        return false ;
    }
}