class Solution {
    public int findCenter(int[][] edges) {
        int pair[]  =  edges[0] ; // v1 , v2
        int pair1[] =  edges[1] ; // v2 , v3
        if(pair[0] == pair1[0] || pair[0] == pair1[1]){
            return pair[0] ;
        }
        return pair[1] ;

    }
}