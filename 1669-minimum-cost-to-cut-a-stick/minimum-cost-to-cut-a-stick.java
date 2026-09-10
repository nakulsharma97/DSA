class Solution {
    int dp[][] ;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length ;
        dp = new int[m+2][m+2] ;
        int arr[] = new int[m+2] ;
        arr[m+1] = n ;
        Arrays.sort(cuts) ;
        for(int i = 0 ; i< m ; i++){
            arr[i+1] = cuts[i] ;
        }
        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return solve(arr , 0 , m +1);
    }
    public int solve(int arr[] , int i , int j){
        if(i + 1 == j){
            return 0 ;
        }
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        int ans = Integer.MAX_VALUE ;
        for(int k = i +1 ; k < j ; k++){
            int cost = arr[j] - arr[i] + solve(arr , i , k) + solve(arr, k , j) ;
            ans = Math.min(ans, cost) ;
        }
        return dp[i][j] = ans ;
    }
}