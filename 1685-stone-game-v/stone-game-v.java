class Solution {
    int n ;
    int dp[][] ;
    int prefix[] ;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length ;
        dp = new int[n][n] ;
        int sum = 0 ;
        for(int i = 0 ; i < n;i++){
            sum += stoneValue[i] ;
        }
        for(int row[] : dp){
            Arrays.fill(row , -1)  ;
        }
         prefix = new int[n+1] ;
        for(int  i = 0; i <  n;i++){
            prefix[i+1] = prefix[i]  + stoneValue[i] ;
        }
        return solve(0 , n-1, stoneValue) ;
    }
    public int solve(int left , int right , int [] stoneValue){
        if(right == left){
            return 0 ;
        }
        if(dp[left][right] != -1){
            return dp[left][right] ;
        }
        int ans = 0 ;
        for(int k  = left ; k < right ;k++){
            int leftsum = prefix[k+1] - prefix[left] ;
            int rightsum = prefix[right +1] - prefix[k+1];
            if(leftsum < rightsum){
               ans = Math.max(ans , leftsum + solve(left , k  , stoneValue));
            }
            else if(rightsum < leftsum){
                ans = Math.max(ans , rightsum + solve(k+1 , right , stoneValue));
            }
            else {
                ans = Math.max(ans , Math.max(leftsum + solve(left , k  ,stoneValue) , rightsum + solve(k+1 , right , stoneValue)) ) ;
            }
        }
        return dp[left][right] = ans ;
    }
}