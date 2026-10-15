class Solution {
    int n ;
    int dp[][] ; 
    public int lengthOfLIS(int[] nums) {
        n = nums.length ;
        dp = new int[n+1][n+1] ;
        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return solve(0 , -1 , nums) ;
    }
    public int solve(int i , int p , int nums[]){
        if( i >= n){
            return 0;
        }
        if(p != -1 && dp[i][p+1] != -1){
            return dp[i][p+1] ;
        }
        int take = 0 ;
        if(p == -1 || nums[p] < nums[i]){
            take = 1 + solve(i +  1 , i , nums) ;
        }
        int skip = solve(i +1 , p , nums);
        if(p != -1){
         dp[i][p+1] = Math.max(take , skip) ;
        }
         return Math.max(take , skip) ;
   
    }
}