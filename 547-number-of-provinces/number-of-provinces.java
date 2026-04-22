class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>() ;
        int res = 0 ;
        for(int i = 0 ; i < isConnected.length ;i++){
            if(!visited.contains(i)){
                dfs(i , visited , isConnected) ;
                res++ ;
            }
        }
        return res ;
    }
    public void dfs(int node , Set<Integer> visited , int[][] isConnected){

        visited.add(node);
        for(int j = 0 ; j< isConnected.length ;j++){
            if(isConnected[node][j] == 1 && !visited.contains(j)){
                dfs(j , visited , isConnected) ;
            }
        }
    }
}