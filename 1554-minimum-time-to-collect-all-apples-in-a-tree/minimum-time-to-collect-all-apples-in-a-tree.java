class Solution {
    public int dfs(int src ,int parent , List<List<Integer>> l, List<Boolean> hasApple ){
        int time = 0 ;
        for(int neigh : l.get(src)){
          if(neigh == parent){
            continue ;
          
          }
          int timetakenchild = dfs(neigh ,src , l , hasApple) ;
          if(timetakenchild > 0 || hasApple.get(neigh)){
            time += timetakenchild + 2 ;
          }
        }
        return time ;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int res = 0 ;
        List<List<Integer>> l = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            l.add(new ArrayList<>()) ;
        }
        for(int edge[] : edges){
            int from = edge[0] ;
            int to = edge[1] ;
            l.get(from).add(to) ;
            l.get(to).add(from) ;
        }
        return dfs(0,-1,l , hasApple) ;
    }
}