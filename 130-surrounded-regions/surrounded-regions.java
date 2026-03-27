class Solution {
    public void solve(char[][] board) {
        int n = board.length ;
        int m = board[0].length ;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0 ; i < m ; i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs( 0 , i , vis , board) ;
            }
            if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(n-1 , i , vis , board) ;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs( i , 0 , vis , board) ;
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs( i,m-1 , vis , board) ;
            }
        }
        for(int i = 0 ; i < n ;i++){
            for(int  j = 0 ; j < m ;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X' ;
                }
            
            }
        }
        return  ;
    }
    public void dfs(int row , int col , boolean[][] vis , char[][] board){

        
        int n = board.length ;
        int m = board[0].length ;
        if(row > n-1 || col > m-1 || row <0 || col < 0 || board[row][col] == 'X' || vis[row][col]){
            return ;
        }
        vis[row][col] = true ;
        dfs(row + 1 , col , vis , board ) ;
        dfs(row , col + 1 , vis , board) ;
        dfs(row - 1 , col , vis , board);
        dfs(row , col -1 , vis , board) ;
    }
}