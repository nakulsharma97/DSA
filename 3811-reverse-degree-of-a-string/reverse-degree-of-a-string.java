class Solution {
    public int reverseDegree(String s) {
        int n = s.length() ;
        int ans = 0 ;
        int b  = 26 ;
        for(int i = 0 ; i < n ;i++){
            int pro = (b - (s.charAt(i) - 'a')) * (i +1) ;
            ans = ans + pro ; 
        }
        return ans  ;
    }
}