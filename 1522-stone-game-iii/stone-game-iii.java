class Solution {
    int n;
    int dp[][];

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length ;
        dp = new int[2][n] ;
            for(int col[] : dp){
            Arrays.fill(col , Integer.MIN_VALUE) ;
            
        }
        int total  = 0 ;
        for(int i = 0 ; i < n ;i++){
            total += stoneValue[i] ;
        }
        int alice = solve(0 , 0 , stoneValue) ;
        int bob = total - alice ;
         if(alice > bob) {
             return "Alice";
           } 
           else if (alice < bob) {
    return "Bob";
     } else {
    return "Tie";
     }
     }

    public int solve(int i, int per, int[] StoneValue) {
        if (i >= n) {
            return 0;
        }
        if (dp[per][i] != Integer.MIN_VALUE) {
            return dp[per][i];
        }
        int stone = 0;
        int result = (per == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(3, n - i); x++) {
            stone += StoneValue[i + x - 1];
            if (per == 0) {
                result = Math.max(result, stone + solve(i + x, 1, StoneValue));
            } else {
                result = Math.min(result, solve(i + x, 0, StoneValue));
            }
        }
        return dp[per][i] = result;
    }
}