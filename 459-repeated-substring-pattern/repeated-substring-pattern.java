class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n  = s.length() ;
        for(int len = 1 ; len <= n / 2 ;len++){
             if(n % len != 0){
                continue ;
             }
             int time = n / len ;
             String ss = s.substring(0 , len ) ;
             StringBuilder str = new StringBuilder() ;
             while(time > 0){
                str.append(ss) ;
                time-- ;
             }
             if(s.equals(str.toString())){
                return true ;
             }
        }
        return false ;
    }
}