class Solution {
    int t[][]  ;
    public int longestStrChain(String[] words) {
        int n = words.length  ;
        t = new int[n][n+1] ;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
         for(int row[] : t){
            Arrays.fill(row , -1) ;
         }
         return list(words , -1 , 0) ;
    }
    int list(String[] words , int prev , int curr){
        if (curr == words.length) {
    return 0;
}
         if( t[curr][prev+1] != -1){
            return t[curr][prev +1] ;
         }
         int take = 0 ;
         if(prev == -1 || check(words[curr] , words[prev])){
            take = 1 + list(words , curr , curr + 1) ;
         }
         int skip  = list(words , prev , curr +1) ;
         return t[curr][prev+1] = Math.max(take , skip) ;
    }
    public boolean check(String large , String small){
        int a = large.length() ;
        int b =small.length() ;
        if(a != b +1){
          return false ;
        }
        int i = 0 ;
        int j  = 0 ;
        while(i < a ){
            if(j < b && large.charAt(i) == small.charAt(j)){
                j++ ;
            }
            i++ ;
        }
        return j == b ;
    }
}