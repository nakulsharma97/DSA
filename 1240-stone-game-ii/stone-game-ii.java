class Solution {
    int dp[][][] = new int[2][101][101] ;
    int n ;
    public int stoneGameII(int[] piles) {
        n = piles.length ;
        for(int a[][] : dp){
            for(int b[] : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(0 , 1  , 1 , piles) ;
    }
    public int solve(int i , int per , int m , int piles[]){
        if(i >= n){
            return 0 ;
        }
        if(dp[per][i][m] != -1){
            return dp[per][i][m] ;
        }
        int result = (per == 1) ? -1 : Integer.MAX_VALUE ;
        int stone = 0;
        for(int x = 1 ; x <= Math.min(2*m , n - i); x++){
           stone += piles[i + x -1] ;
           if(per == 1){
            result = Math.max(result , stone + solve(i + x , 0 , Math.max(x , m ) , piles));
           }
           else {
            result = Math.min(result ,  solve(i +x, 1 ,Math.max(x , m), piles));
           }
        }
        return dp[per][i][m] = result ;
    }
}