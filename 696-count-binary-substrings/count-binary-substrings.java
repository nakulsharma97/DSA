class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0 ;
        int prev = 0 ;
        int curr = 1 ;
        for(int i = 1 ; i < s.length() ;i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curr++ ;
            }
            else {
                res = res +   Math.min(curr , prev) ;
                prev = curr ;
                curr = 1 ;
            }
            
        }
        return res + Math.min(curr , prev) ;
    }
}