class Solution {
    int N;
    int M;
    int K;
    int dp[][][];
    int mod = (int) 1e9  + 7 ;
    public int numOfArrays(int n, int m, int k) {
        N = n ;
        M = m ;
        K = k ;
       dp = new int[51][51][101] ;
        
for (int i = 0; i < 51; i++) {
    for (int j = 0; j < 51; j++) {
        Arrays.fill(dp[i][j], -1);
    }
}
        return solve(0 , 0 , 0) ;
    }

    public int solve(int idx, int create, int max) {
        if (idx == N) {
            if (create == K) {
                return 1;
            }
            return 0;
        }
        if(dp[idx][create][max] != -1){

            return  dp[idx][create][max];
        }
        int result = 0;
        for (int i = 1; i <= M; i++) {
            if (i > max) {
                result = (result + solve(idx + 1, create + 1, i))  % mod;
            } else {
                result = (result + solve(idx + 1, create, max)) % mod;
            }
        }
        return dp[idx][create][max] = result % mod;
    }
}