class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length ;
        boolean ans[] = new boolean[m] ;
        int root[] = new int[n] ;
        root[0]= 0 ;
        for(int i = 1 ; i < n ;i++){
           root[i] = ( nums[i] - nums[i - 1] <= maxDiff) ? root[i - 1] : i;
        }
        for(int i = 0 ; i < m ;i++){
            ans[i] = root[queries[i][0]] == root[queries[i][1]];
        }
        return ans ;
    }
}