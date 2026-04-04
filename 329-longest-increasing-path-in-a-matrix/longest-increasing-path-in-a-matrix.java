class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        int visited[][]  = new int[m][n] ;
        for(int row[] : visited) {
            Arrays.fill(row , -1) ;
        }
        int max = 0  ;
        for(int i = 0 ; i < m ;i++){
            for(int j = 0  ; j < n; j++){
                max = Math.max(max , dfs(matrix , visited  , i ,j ,m, n)) ;
            }
        }
        return max ;

    } 
    public int dfs(int[][]matrix , int[][] visited , int row , int col , int m , int n){
        if(visited[row][col] != -1) return visited[row][col] ;
        int[][] dir = {
            {0 , 1 },
            {1 , 0},
            {-1 , 0},
            {0 , -1} 
          } ;
           int max = 1 ;
          for(int i = 0 ; i<4 ;i++){
            int newrow = row + dir[i][0] ;
            int newcol = col + dir[i][1] ;
           
            if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && matrix[newrow][newcol] > matrix[row][col])
            {
                max = Math.max( max , 1 + dfs(matrix , visited , newrow , newcol , m , n )) ;
            }
          }
          visited[row][col] = max ;
          return max ;

    }
}