class Solution {
    public int reverse(int n){
        int rev = 0 ;
        while( n > 0){
            rev = rev * 10 + (n % 10) ;
            n = n / 10 ;
        }
        return rev ;
    }
    public int mirrorDistance(int n) {
        int res = Integer.MAX_VALUE ;
        int diff = Math.abs(n - reverse(n)) ;
        res = Math.min(res , diff) ;
        return res == Integer.MAX_VALUE ? -1 : res ;
    }
    
}