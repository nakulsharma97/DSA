class Solution {
    public int dfs(int[][] grid , int i , int j  ,boolean[][] vis){
        int n = grid.length ;
        int m  = grid[0].length ;
       //  vis[i][j] = true ;
        if(i < 0 || i >= n || j < 0 || j >= m){
            return  0 ;
        }
           
           if(grid[i][j] == 0 || vis[i][j]){
            return 0 ;
           }
           int area = 1 ;
           vis[i][j]  = true ;

        area += dfs(grid , i + 1 , j , vis) ;
        area += dfs(grid , i , j +1 , vis) ;
        area += dfs( grid , i -1 , j , vis)  ;
        area += dfs(grid , i , j-1 , vis);
        return area ;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        int ans = 0 ; 
        int max =  0 ;
        boolean vis[][] = new boolean[n][m] ;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                  ans = dfs(grid , i  , j , vis) ;
                  max = Math.max(max , ans) ;
                 
                }
            }
            
        }
        return max  ;
    }
}