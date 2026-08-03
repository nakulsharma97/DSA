class Solution {
    public int countValidPrefixes(String s) {
        int ans = 0 ;
        int zero = 0 ;
        int one = 0 ;
        int n = s.length() ;
        for(int i = 0 ; i < n ;i++){
            char ch = s.charAt(i) ;
            if(ch == '1'){
                one++ ;
            }
            if(ch == '0'){
                zero++ ;
            }
            if(Math.abs(zero - one) <= 1){
                ans++ ;
            }
        }
        return ans   ;
    }
}