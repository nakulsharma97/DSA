class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        int dp[][] =new int[n][m];
        for(int row[]  : dp){
            Arrays.fill(row , -1);
        }
        return solve(s , t , n , m , 0 , 0 , dp) ;
    }
    public int solve(String s , String t , int n , int m , int i ,int j ,int dp[][]){
        if(j == m){
            return 1  ;
        }
        if(i == n){
            return 0 ;
        }
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        if(s.charAt(i) == t.charAt(j)){
            int take = solve(s , t , n , m , i + 1 , j + 1, dp) ;
            int skip = solve(s , t , n , m , i +1 , j , dp) ;
            dp[i][j] = take + skip ;
        }
        else {
              dp[i][j] = solve(s , t , n , m , i + 1 , j , dp) ;
        }
        return dp[i][j] ;
    }
}