class Solution {
    int parent[] ;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n] ;
        for(int i = 0 ; i< n;i++){
            parent[i] = i ;
        }
        for(int i = 1 ; i < n ;i++){
            if(nums[i] - nums[i-1] <= maxDiff){
               union(i-1 , i);
            }
        }
        boolean ans[] = new boolean[queries.length] ;
        for(int i  = 0 ;i < queries.length ;i++){
       int u  = queries[i][0];
       int v = queries[i][1] ;
       ans[i] = find(u) == find(v) ;
        }
        return ans ;
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]) ;
        }
        return parent[x] ;
    }
    public void union(int x , int y){

        int px = find(x) ;
        int  py = find(y) ;
        if(px != py){
            parent[py] = px ;
        }

    }
}