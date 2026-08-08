class Solution {
   int[][] dp = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() ;
        int m = text2.length() ;
        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return solve(text1 , text2 , 0 , 0) ;
    }
    public int solve(String text1 , String text2 , int i ,int j){
        if(i >= text1.length() || j >= text2.length()){
            return 0  ;
        }
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        if(text1.charAt(i) == text2.charAt(j)){
        return dp[i][j] =  1 + solve(text1 , text2 , i+ 1,j+1) ;
        } 
        else {
        return dp[i][j] = Math.max(solve(text1 , text2 , i , j+1) , solve(text1 , text2 , i + 1, j)) ;
        }
// return Math.max(take , skip );
    }
}