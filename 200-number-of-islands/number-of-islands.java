class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {
                { 0, -1 },
                { 1, 0 },
                { 0, 1 },
                { -1, 0 }
        };
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
       for(int i = 0 ; i < n ;i++){
        for(int j = 0 ; j < m ; j++){
            if(grid[i][j] == '1' && !visited[i][j]){
                ans++ ;
                q.offer(new int[]{i,j}) ;
                visited[i][j] = true ;
                while(!q.isEmpty()){
                    int curr[] = q.poll() ;
                    int a = curr[0] ;
                    int b = curr[1] ;
                    for(int d[]  : dir){
                        int na = a + d[0] ;
                        int nb = b + d[1] ;
                        if(na >= 0 && na  < n && nb >= 0 && nb  < m){
                            if(grid[na][nb] == '1' && !visited[na][nb]){
                                q.offer(new int[]{na , nb}) ;
                                visited[na][nb] = true ;
                            }
                        }
                    }
                }
            }
        }
       }
        return ans;
    }
}