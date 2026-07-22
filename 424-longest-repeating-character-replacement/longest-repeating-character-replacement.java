class Solution {
    public int characterReplacement(String s, int k) {
     int n = s.length() ;
     int hash[] = new int[26] ;
     int maxcount = 0 ;
     int maxlen =  0 ;
     int left  =  0 ;
     for(int i = 0 ; i < n ;i++){
        char ch = s.charAt(i) ;
        hash[ch - 'A']++ ;
        maxcount = Math.max(maxcount , hash[ch - 'A']) ;
        while((i - left + 1) - maxcount  > k){
            hash[s.charAt(left) - 'A']-- ;
            left++ ;
        }
        maxlen = Math.max(maxlen , (i - left + 1)) ;
     }
     return maxlen ;
    }
}