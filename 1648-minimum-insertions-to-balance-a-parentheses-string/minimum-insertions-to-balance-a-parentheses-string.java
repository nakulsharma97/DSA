class Solution {
    public int minInsertions(String s) {
        int n = s.length() ;
        int open = 0 ;
        int  i = 0 ;
        int ans  = 0 ;
        while(i < n){
            char ch = s.charAt(i)  ;
            if(ch =='('){
                open++ ;
            }
            else {
                if(i + 1 < n && s.charAt(i+1) == ')'){
                    i++ ;
                }
                else {
                    ans++ ;
                }
                if(open > 0){
                    open-- ;
                }
                else {
                    ans++ ;
                }
            }
            i++ ;
        }
        ans += open * 2 ;
        return ans ;
    }
}