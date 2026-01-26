class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long degre[] = new long[n] ;
        for(int edge[] :roads){
            degre[edge[0]]++ ;
            degre[edge[1]]++ ;
        }
        Arrays.sort(degre) ;
        long res = 0 ;
        long label = 1 ;
        for(int i = 0 ; i < n ;i++){
            res = res + (degre[i]  * label) ;
            label++ ;
        }
        return res ;
    }

}