class Solution {
    int dp[][] ;
    public boolean stoneGame(int[] piles) {
        int n = piles.length ;
        int sum = 0 ;
        dp = new int[n][n] ;
        for(int row[] : dp){
            Arrays.fill(row , 0) ;
        }
        for(int i = 0 ; i < n ;i++){
            sum += piles[i] ;
        }
        int alice = solve(0 , n-1 , piles) ;
        return alice > sum / 2 ;
    }
    public int solve(int i , int j , int[] piles){
        if(i > j){
            return 0 ;
        }
        if(dp[i][j] != 0){
            return dp[i][j] ;
        }
        int takei = piles[i] + Math.min(solve(i + 2 , j , piles) , solve(i + 1, j - 1 , piles)) ;
        int takej = piles[j] + Math.min(solve(i + 1 , j - 1 , piles) , solve(i , j- 2 , piles)) ;
        return dp[i][j] = Math.max(takei , takej) ;
    }
    
}