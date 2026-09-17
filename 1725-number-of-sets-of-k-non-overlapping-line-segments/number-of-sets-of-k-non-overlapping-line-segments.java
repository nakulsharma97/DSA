class Solution {
    int mod = 1000000000 +  7 ;
    public int numberOfSets(int n, int K) {
        int dp[][] = new int[1001][1001] ;
        for(int i = 0 ; i <= n-1 ;i++){
            dp[0][i] = 1 ;
        }

        for(int k = 1 ; k <= K ;k++){
            int prev[] = new int[n+1] ;
            for(int x= n-1 ; x >= 0 ;x--){
                prev[x] = (prev[x+1] + dp[k-1][x] ) % mod ;
            }
            for(int i = n -1 ; i >= 0 ;i--){
                 int take =  prev[i+1] % mod;
                 int skip = dp[k][i+1] % mod ;
                 dp[k][i] = (take + skip) % mod ;
            }
        }
        return dp[K][0] ;
    }
}