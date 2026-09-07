class Solution {
    public int distinctSubseqII(String s) {
        int n  = s.length() ;
        int end[] = new int[26] ;
        long mod = 1_000_000_007 ;
        for(int i = 0 ; i < n ;i++){
            int ind = s.charAt(i) - 'a' ;
            long total = 1 ;
            for(int count : end){
                total = (total + count) % mod ;
            }
            end[ind] = (int) total ;
        }
        long ans = 0 ;
        for(int count : end){
            ans = (ans + count)  % mod ;
        }
        return (int) ans  ;
    }
}