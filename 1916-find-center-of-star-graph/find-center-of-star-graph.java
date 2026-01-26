class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int edge = edges.length ;
        for(int i = 0 ; i < edge ; i++){
            int v = edges[i][0] ;
            int u = edges[i][1] ;
            map.put(v , map.getOrDefault(v, 0) + 1) ;
            map.put(u , map.getOrDefault(u  , 0) +1) ;
            if(map.get(v) == edge){
                return v ;
            }
            if(map.get(u) == edge){
                return u ;
            }
        }
        return -1 ;
    }

    
}