class Solution {
    public boolean canPartitionGrid(int[][] grid) {
     int n = grid.length ;
     int m = grid[0].length ;
     long total = 0 ;
     long row[] = new long[n] ;
     long col[] = new long[m] ;
     for(int i = 0 ; i < n;i++){
        for(int j = 0 ; j < m ;j++){
            total += grid[i][j] ;
            row[i] += grid[i][j] ;
            col[j] += grid[i][j] ;
        }
     } 
     if(total % 2 != 0){
        return false ;
     }
     long upper = 0  ;
     for(int i = 0 ; i < n - 1 ;i++){
         upper += row[i] ;
        if(upper == total - upper){
            return true ;
        }
     }  
     long  left = 0  ;
     for(int i = 0 ;  i < m -1 ;i++){
        left += col[i] ;
        if(left == total - left){
            return true ;
        }
     }
    return false ;
    }
}