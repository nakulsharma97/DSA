class Solution {
     boolean dp[] ;
    public boolean winnerSquareGame(int n) {
        dp = new boolean[n+1] ;
      //  Arrays.fill(dp , -1) ;
         dp[0] = false ;
        for(int i = 1 ; i < n+1 ;i++){
            for(int k = 1 ; k * k <= i;k++){
                if(dp[i - (k*k)] == false ){
                    dp[i] = true ;
                    break  ;
                }
            }
        }
        return dp[n]  ;

    }
    
}