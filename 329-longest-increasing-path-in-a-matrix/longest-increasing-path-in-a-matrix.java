class Solution {
    int dir [][] = {
        {0 ,-1},
        {1, 0},
        {0 ,1},
        {-1 , 0} 
    };
    public int dfs(int i , int j ,int[][] dp, int matrix[][]){
        int row = matrix.length ;
        int col = matrix[0].length ;
        if(dp[i][j]  != -1){
            return dp[i][j] ;
        }
        int max = 1 ;
        for(int d[] : dir){
            int ni = d[0] + i  ;
            int nj = d[1] + j  ;
            if(ni >= 0 && ni < row && nj >= 0 && nj < col && matrix[ni][nj] > matrix[i][j] ){
         max = Math.max(max ,  1 + dfs(ni , nj , dp  , matrix)) ;
            }
        }
        dp[i][j] = max ;
        return max ;

    }
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length ;
        int col = matrix[0].length ;
        int ans = 0 ;
        int max =  0 ;
        int dp[][] = new int[row][col] ;
        for(int r []  : dp ){
            Arrays.fill(r , -1) ;
        }
        for(int i = 0 ; i< row ;i++){
           for(int j = 0 ; j < col ;j++){
            max = dfs(i , j ,dp, matrix ) ;
            ans = Math.max(ans , max) ;
           }
        }
        return ans  ;
    }
}