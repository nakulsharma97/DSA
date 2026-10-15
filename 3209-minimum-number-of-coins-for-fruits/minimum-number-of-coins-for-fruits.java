class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length ;
        int dp[] = new int[n+1];
        for(int i = 0 ; i <= n ;i++){
            dp[i] = -1 ;
        }
        dp[n] = 0 ;
        dp[n-1] =  prices[n-1] ;
        for(int i = n -2 ; i >= 0 ;i-- ){
            int max = Integer.MAX_VALUE ;
            for(int j = i +1 ; j <= Math.min(2*i + 2 , n) ;j++){
                max = Math.min(max , dp[j]) ;
            }
            dp[i] = prices[i] + max ;
        }
        return dp[0] ;
    }
}