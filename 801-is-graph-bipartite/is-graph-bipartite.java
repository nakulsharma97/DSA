class Solution {
    public boolean check(int start ,int[][] graph, int color[] ){
 Queue<Integer> q = new LinkedList<>() ;
        q.add(start) ;
        int n = graph.length ;
        color[start] = 0  ;
        while(!q.isEmpty()){
            int node = q.poll() ;
            for(int idx : graph[node]){
                //if adjecaent node not color 
                // give opposite 
                if(color[idx] == -1){
                  color[idx] = 1- color[node] ;
                  q.add(idx) ;
                }
                // is adjacent guy have  same color somone did it before
                else if(color[node] == color[idx]){
                    return false ;
                }
            }
        }
return true ;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
       int color[] = new int[n] ;
        for(int i = 0 ; i <  n  ;i++){
            color[i] = -1   ;
        }
        for(int i = 0 ;i < n ;i++){
      if(color[i] == -1){
        if(check(i , graph , color) == false){

            return false ;
        }
      }
        }
        return true ;
    }
}