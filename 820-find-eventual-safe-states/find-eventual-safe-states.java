class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer , Boolean > map = new HashMap<>() ;
        List<Integer> l = new ArrayList<>() ;
        int n = graph.length ;
for(int i = 0 ; i < n ;i++){
    if(dfs(i , graph , map)) {
        l.add(i) ;
    }
}
return l ;
    }

    public boolean dfs(int node ,int[][] graph,  HashMap<Integer ,Boolean > map){
if(map.containsKey(node)){
    return map.get(node) ;
}
map.put(node,false) ;
for(int nei : graph[node]){

   if(!dfs(nei , graph , map)) {
    return false ;
   }
} 
map.put(node , true) ;
return true ;

    }
}