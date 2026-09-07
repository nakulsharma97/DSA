class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length() ;
         int mod = 1_000_000_007;
        int end[] = new  int[26] ;
        for(int i = 0 ; i < n ;i++){
           int index = s.charAt(i) - 'a' ;
           long total = 1 ;
           for(int count : end){
            total = (total + count) % mod ;
           }
            end[index] = (int) total ;
        }
        long ans = 0 ;
        for(int i = 0 ; i< 26 ;i++){
            ans = (ans + end[i]) % mod;
        }
        return (int) ans  ;
    }
}