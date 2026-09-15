class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length() ;
        int ans = 0 ;
        int left = 0 ;
        while(left <= n - k){
            if(ispalin(s , left , left + k -1)){
                ans++ ;
                left = left + k ;
            }
            else if(left <= n - k -1  && ispalin(s , left , left + k )){
                ans++ ;
                left = left + k + 1 ;
            }
            else {
                left++ ;
            }
        }
        return ans ;
    }
    public boolean ispalin(String s , int i , int n ){
        while(i < n){
            if(s.charAt(i) != s.charAt(n)){
                return false ;
            }
            i++ ; 
            n-- ;
        }
        return true ;
    }
}